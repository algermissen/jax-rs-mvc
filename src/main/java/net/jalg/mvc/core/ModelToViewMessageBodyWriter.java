/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jalg.mvc.core;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class ModelToViewMessageBodyWriter implements MessageBodyWriter<ModelAndView> {
	
	TemplateEngine engine;
	
	@PostConstruct
	public void init() throws Exception {
		engine = new TemplateEngine();
	}
	
	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		return ModelAndView.class.isAssignableFrom(arg0);
	}

	@Override
	public void writeTo(ModelAndView mav, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream output)
			throws IOException, WebApplicationException {
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("entity", mav.getModel());
			engine.merge(mav.getView(),output,map);
	}

	@Override
	public long getSize(ModelAndView arg0, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4) {
		return -1;
	}

}
