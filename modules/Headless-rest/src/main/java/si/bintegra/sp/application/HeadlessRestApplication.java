package si.bintegra.sp.application;

import javax.ws.rs.GET;
import javax.ws.rs.core.Application;

import com.liferay.portal.remote.cors.annotation.CORS;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Alen
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/sp/api",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=HeadlessSP.Rest",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true",
		"liferay.cors.annotation=true"
	},
	service = Application.class
)
@CORS(allowMethods = "*", allowHeaders = "*", allowOrigin = "*")
public class HeadlessRestApplication extends Application {
	@GET
	public String get() {
		return "Hello World!";
	}
}