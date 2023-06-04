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
import si.bintegra.sp.dto.LoginRequestDto;
import si.bintegra.sp.dto.UserRequest;
import si.bintegra.sp.dto.UserResponse;
import si.bintegra.sp.util.Mapper;
import si.bintegra.sp.util.RoleChecker;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.Locale;

@Component(
        properties = "defaultController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = UserController.class
)
@Path("/user")
@Produces("application/json")
@Consumes("application/json")
@CORS(allowMethods = "*", allowHeaders = "*", allowOrigin = "*")
public class UserController extends Application {

    @GET
    public UserResponse getCurrentUser(@Context HttpServletRequest httpReq) throws PortalException {
        UserResponse res = new UserResponse();
        User user = PortalUtil.getUser(httpReq);
        if(RoleChecker.isUserGuest(user)) {
            res.setSuccess(false);
            return res;
        }

        res.setSuccess(true);
        res.setUser(Mapper.toUserDto(user));
        return res;
    }



    @POST
    @Path("/login")
    public UserResponse loginUser(@RequestBody UserRequest req, @Context HttpServletRequest httpReq) throws PortalException {
        UserResponse res = new UserResponse();

        if (!RoleChecker.isUserGuest(PortalUtil.getUser(httpReq))) {
            res.setSuccess(false);
            res.setUser(Mapper.toUserDto(PortalUtil.getUser(httpReq)));
            return res;
        }
        LoginRequestDto loginRequest = req.getLoginRequest();

        final long userId = UserLocalServiceUtil.authenticateForBasic(PortalUtil.getDefaultCompanyId(), CompanyConstants.AUTH_TYPE_EA, loginRequest.getEmail(), loginRequest.getPassword());

        if (userId == 0) {
            res.setSuccess(false);
            return res;
        }

        User loggediInUser = UserLocalServiceUtil.getUser(userId);
        res.setUser(Mapper.toUserDto(loggediInUser));
        res.setSuccess(true);
        return res;
    }

    @POST
    @Path("/register")
    public void register(@RequestBody UserRequest req) throws PortalException {
        long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
        Role role = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
        User admin = UserLocalServiceUtil.getRoleUsers(role.getRoleId()).get(0);


        UserLocalServiceUtil.addUser(
                admin.getUserId(), companyId, false, req.getRegisterRequest().getPassword(), req.getRegisterRequest().getRepeatPassword(), false, "defaultScreenName", req.getRegisterRequest().getEmail(),
                Locale.ENGLISH, req.getRegisterRequest().getFirstName(), null, req.getRegisterRequest().getLastName(), 0, 0, req.getRegisterRequest().getMale(), req.getRegisterRequest().getBirthMonth(), req.getRegisterRequest().getBirthDay(),
                req.getRegisterRequest().getBirthYear(), "", new long[0], new long[0], new long[0], new long[0], false, null
        );
//        long creatorUserId, long companyId, boolean autoPassword, String password1, String password2, boolean autoScreenName, String screenName, String emailAddress,
//        Locale locale, String firstName, String middleName, String lastName, long prefixListTypeId, long suffixListTypeId, boolean male, int birthdayMonth, int birthdayDay,
//        int birthdayYear, String jobTitle, long[] groupIds, long[] organizationIds, long[] roleIds, long[] userGroupIds, boolean sendEmail, ServiceContext serviceContext
    }
}
