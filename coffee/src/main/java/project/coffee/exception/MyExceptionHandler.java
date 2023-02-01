package project.coffee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import project.coffee.exception.NullObjectException;
import project.coffee.exception.ExceptionDetails;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class MyExceptionHandler {
	@ExceptionHandler(NullPointerException.class)
	public ExceptionDetails handleNullPointerException(NullPointerException e, WebRequest request) {
		
		return new ExceptionDetails(e.getMessage(), request.getDescription(false));
	}
	
	@ExceptionHandler(NullObjectException.class)
	public ExceptionDetails handleNullObjectException(NullObjectException e, WebRequest request)
	{
		return new ExceptionDetails(e.getMessage(), request.getDescription(false));
	}
	
	@ExceptionHandler(DataAlreadyInUseException.class)
	public ExceptionDetails handleDataAlreadyInUseException(DataAlreadyInUseException e, WebRequest request)
	{
		return new ExceptionDetails(e.getMessage(), request.getDescription(false));
	}
	
	@ExceptionHandler(Exception.class)
	public ExceptionDetails handleGenericException(Exception e, WebRequest request)
	{
		System.out.println("Some exception occured");
		return new ExceptionDetails(e.getMessage(), request.getDescription(false));
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ExceptionDetails handleInvalidCredentialsException(InvalidCredentialsException e, WebRequest request)
	{
		return new ExceptionDetails(e.getMessage(), request.getDescription(false));
	}
	
	
	
	
	
}
