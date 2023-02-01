package project.coffee.exception;

@SuppressWarnings("serial")
public class NullObjectException extends RuntimeException {
	
	private String entityName;

	public NullObjectException() {
		super("NullObject Exception occured");
	}

	public NullObjectException(String entityName) {
		super(entityName + "is null");
		this.entityName = entityName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	

}

