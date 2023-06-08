package si.bintegra.sp.providers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RuntimeExceptionHandler implements ExceptionMapper<RuntimeException> {
    private static final Log _log = LogFactoryUtil.getLog(RuntimeExceptionHandler.class);
    @Override
    public Response toResponse(RuntimeException e) {
        _log.error(e.getMessage(), e);
        return Response.status(500).build();
    }
}
