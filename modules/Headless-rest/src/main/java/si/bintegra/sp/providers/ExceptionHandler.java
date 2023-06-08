package si.bintegra.sp.providers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import si.bintegra.sp.application.SubscriptionController;

import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
@PreMatching
public class ExceptionHandler implements ExceptionMapper<Exception> {

    private static final Log _log = LogFactoryUtil.getLog(ExceptionHandler.class);
    @Override
    public Response toResponse(Exception e) {
        _log.error(e.getMessage(), e);
        return Response.status(500).build();
    }
}
