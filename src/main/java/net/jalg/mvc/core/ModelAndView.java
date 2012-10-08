package net.jalg.mvc.core;

public class ModelAndView {

	private Object model;
	private String view;

	public ModelAndView(Object model, String view) {
		this.model = model;
		this.view = view;
	}

	public Object getModel() {
		return model;
	}

	public String getView() {
		return view;
	}

}
