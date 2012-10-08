package net.jalg.mvc.core.ep;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import net.jalg.mvc.core.exception.TemplateMergingException;

/**
 * @author Jan Algermissen <algermissen@acm.org>
 *
 */
@Provider
public class TemplateMergingExceptionMapper implements ExceptionMapper<TemplateMergingException> {
	
	private static final Logger logger = Logger.getLogger(TemplateMergingExceptionMapper.class.getName());

	@Override
	public Response toResponse(TemplateMergingException e) {
		logger.log(Level.SEVERE, "Error when merging template" , e);
		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

}
