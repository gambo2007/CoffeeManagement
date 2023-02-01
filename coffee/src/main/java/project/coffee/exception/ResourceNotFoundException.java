package project.coffee.exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String entityName;
	private String attributeName;
	private String attributeValue;
	public ResourceNotFoundException() {
		super("ResourceNotFoundException occured");
	}
	public ResourceNotFoundException(String entityName, String attributeName, String attributeValue) {
		super(entityName +" with "+attributeName+" = "+ attributeValue +" Not found");
		this.entityName = entityName;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
}
