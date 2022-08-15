package myyk.util.exception;

public class SystemException extends Exception {

	private static final long serialVersionUID = 7898169216474351319L;

	private String message;
	
	public SystemException() {
		super();
		this.message = "System failed...!";
	}
	
	public SystemException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
