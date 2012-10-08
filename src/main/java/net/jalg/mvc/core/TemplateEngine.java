package net.jalg.mvc.core;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import net.jalg.mvc.core.exception.TemplateMergingException;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/** Wrapper around a concrete template engine.
 * 
 * @author Jan Algermissen <algermissen@acm.org>
 */
public class TemplateEngine {

	private VelocityEngine engine;
	
	public TemplateEngine() throws Exception {
		engine = new VelocityEngine();
		engine.addProperty("resource.loader", "class");
		engine.addProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		engine.init();
	}

	/** Merge template and data into a stream.
	 * 
	 * @param path Template path
	 * @param output Stream to write result to.
	 * @param map Data to be made accessable by template
	 */
	public void merge(String path, OutputStream output, Map<String, Object> map) {
		VelocityContext context = new VelocityContext();

		for (String key : map.keySet()) {
			context.put(key, map.get(key));
		}

		try {
			Template template = engine.getTemplate(path);
			OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
			template.merge(context, writer);
			writer.flush();
		} catch (Exception e) {
			throw new TemplateMergingException(path, e);
		}
	}
}
