package project.coffee.exception;

public class DataAlreadyInUseException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String fieldValue;
	
	
	public DataAlreadyInUseException() {
		super("DataAlreadyInUseException occured");
	}



	public DataAlreadyInUseException(String fieldName, String fieldValue) {
		super("DataAlreadyInUseException occured: "+ fieldName + ":"+ fieldValue +" is already taken");
	}



	public String getFieldName() {
		return fieldName;
	}



	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}



	public String getFieldValue() {
		return fieldValue;
	}



	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
}
