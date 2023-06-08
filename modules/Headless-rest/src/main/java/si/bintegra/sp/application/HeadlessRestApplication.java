package si.bintegra.sp.application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import si.bintegra.sp.providers.CorsFilter;
import si.bintegra.sp.providers.RuntimeExceptionHandler;
import si.bintegra.sp.providers.ExceptionHandler;

import javax.ws.rs.GET;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alen
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/sp/api",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=HeadlessSP.Rest",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true",
		"liferay.cors.annotation=false"
	},
	service = Application.class
)
public class HeadlessRestApplication extends Application{

	@Override
	public Set<Object> getSingletons() {
		Set<Object> providers = new HashSet<>();
		providers.add(new CorsFilter());
		providers.add(new ExceptionHandler());
		providers.add(new RuntimeExceptionHandler());
		return providers;
	}
	@GET
	public String get() {
		return "Hello World!";
	}
}