package net.jalg.mvc.core.exception;

public class TemplateMergingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String path;

    /**
     * @param path The template path
     * @param cause
     */
    public TemplateMergingException(String path, Throwable cause) {
            super("Unable to merge template " + path,cause);
            this.path = path;
    }

    /**
     * @param path The template path
     * @param message
     * @param cause
     */
    public TemplateMergingException(String path, String message, Throwable cause) {
            super("Unable to merge template " + path + "; " + message,cause);
            this.path = path;
    }

    /**
     * @return
     */
    public String getPath() {
            return path;
    }

}