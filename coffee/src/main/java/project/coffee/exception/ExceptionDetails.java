package project.coffee.exception;

public class ExceptionDetails {
	private String message;
	private String url;
	
	
	
	public ExceptionDetails() {
		super();
	}
	
	public ExceptionDetails(String message, String url) {
		super();
		this.message = message;
		this.url = url;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
