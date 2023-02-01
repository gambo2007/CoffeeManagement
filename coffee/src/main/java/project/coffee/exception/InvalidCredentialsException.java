package project.coffee.exception;

public class InvalidCredentialsException extends RuntimeException{
	
	private String credentialName;
	
	public InvalidCredentialsException() {
		super("InvalidCredentialsException occured");
	}
	
	public InvalidCredentialsException(String credentialName) {
		super("Invalid "+credentialName);
		this.credentialName = credentialName;
	}

	public String getCredentialName() {
		return credentialName;
	}

	public void setCredentialName(String credentialName) {
		this.credentialName = credentialName;
	}
	
	

}
