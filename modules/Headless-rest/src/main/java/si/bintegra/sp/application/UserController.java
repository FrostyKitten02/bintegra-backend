package si.bintegra.sp.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.remote.cors.annotation.CORS;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.request.LoginRequestDto;
import si.bintegra.sp.dto.request.UserRequest;
import si.bintegra.sp.dto.response.UserResponse;
import si.bintegra.sp.service.ConsultantLocalServiceUtil;
import si.bintegra.sp.util.Mapper;
import si.bintegra.sp.util.RoleChecker;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.Locale;
import java.util.UUID;

@Component(
        properties = "defaultController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = UserController.class
)
@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public class UserController {

    @GET
    @CORS(allowMethods = "*", allowHeaders = "*", allowOrigin = "*")
    public UserResponse getCurrentUser(@Context HttpServletRequest httpReq) throws PortalException {
        UserResponse res = new UserResponse();
        User user = PortalUtil.getUser(httpReq);
        if(RoleChecker.isUserGuest(user)) {
            res.setSuccess(false);
            return res;
        }

        res.setSuccess(true);
        res.setUser(Mapper.toUserDto(user, ConsultantLocalServiceUtil.getConsultantByUserId(user.getUserId()) != null));
        return res;
    }



    @POST
    @Path("/login")
    public UserResponse loginUser(@RequestBody UserRequest req, @Context HttpServletRequest httpReq) throws PortalException {
        UserResponse res = new UserResponse();
        User user = PortalUtil.getUser(httpReq);

        if (!RoleChecker.isUserGuest(user)) {
            res.setSuccess(false);
            res.setUser(Mapper.toUserDto(user, ConsultantLocalServiceUtil.getConsultantByUserId(user.getUserId()) != null));
            return res;
        }
        LoginRequestDto loginRequest = req.getLoginRequest();

        final long userId = UserLocalServiceUtil.authenticateForBasic(PortalUtil.getDefaultCompanyId(), CompanyConstants.AUTH_TYPE_EA, loginRequest.getEmail(), loginRequest.getPassword());

        if (userId == 0) {
            res.setSuccess(false);
            return res;
        }

        User loggedInUser = UserLocalServiceUtil.getUser(userId);
        res.setUser(Mapper.toUserDto(loggedInUser, ConsultantLocalServiceUtil.getConsultantByUserId(userId) != null));
        res.setSuccess(true);

        return res;
    }

    @POST
    @Path("/register")
    public void register(@RequestBody UserRequest req) throws PortalException {
        long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
        Role role = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
        User admin = UserLocalServiceUtil.getRoleUsers(role.getRoleId()).get(0);

        if (req.getRegisterRequest().getBirthYear() == null) {
            req.getRegisterRequest().setBirthYear(1);
        }

        if (req.getRegisterRequest().getBirthMonth() == null) {
            req.getRegisterRequest().setBirthMonth(1);
        }

        if (req.getRegisterRequest().getBirthDay() == null) {
            req.getRegisterRequest().setBirthDay(1);
        }

        if (req.getRegisterRequest().getMale() == null) {
            req.getRegisterRequest().setMale(true);
        }

        String screenName = UUID.randomUUID().toString();

        UserLocalServiceUtil.addUser(
                admin.getUserId(), companyId, false, req.getRegisterRequest().getPassword(), req.getRegisterRequest().getRepeatPassword(), false, screenName, req.getRegisterRequest().getEmail(),
                Locale.ENGLISH, req.getRegisterRequest().getFirstName(), null, req.getRegisterRequest().getLastName(), 0, 0, req.getRegisterRequest().getMale(), req.getRegisterRequest().getBirthMonth(), req.getRegisterRequest().getBirthDay(),
                req.getRegisterRequest().getBirthYear(), "", new long[0], new long[0], new long[0], new long[0], false, null
        );
//        long creatorUserId, long companyId, boolean autoPassword, String password1, String password2, boolean autoScreenName, String screenName, String emailAddress,
//        Locale locale, String firstName, String middleName, String lastName, long prefixListTypeId, long suffixListTypeId, boolean male, int birthdayMonth, int birthdayDay,
//        int birthdayYear, String jobTitle, long[] groupIds, long[] organizationIds, long[] roleIds, long[] userGroupIds, boolean sendEmail, ServiceContext serviceContext
    }
}
