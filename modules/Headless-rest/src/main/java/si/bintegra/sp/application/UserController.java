package si.bintegra.sp.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
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
}
