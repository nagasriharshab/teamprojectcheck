
package com.abc.healthcenter.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abc.healthcenter.model.ErrorResponse;


/**
 * 
 * @author NAGA SRI HARSHA
 * date : 11-July-2021
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * method to handle ProductAlreadyExistException
	 * @param e
	 * @return ResponseEntity containing errorResponse and status
	 */
	@ExceptionHandler(value = ResourceAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> handleProductAlreadyExistException(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * method to handle ResourceNotFoundException
	 * @param e
	 * @return ResponseEntity containing errorResponse and status
	 */
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception e){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	/**
	 * method to handle InvalidCredentialsException
	 * @param e
	 * @return ResponseEntity containing errorResponse and status
	 */
	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleInvalidCredentialsException(Exception e){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	/**
	 * method to handle UnauthorisedAttemptException
	 * @param e
	 * @return ResponseEntity containing errorResponse and status
	 */
	@ExceptionHandler(value = UnauthorisedAttemptException.class)
	public ResponseEntity<ErrorResponse> handleUnauthorisedAttemptException(Exception e){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError(e.getMessage());
		errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.UNAUTHORIZED);
	}
	/**
	 * method to handle ResourceNotAvailableException
	 * @param e
	 * @return ResponseEntity containing errorResponse and status
	 */
	@ExceptionHandler(value = ResourceNotAvailableException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotAvailableException(Exception e){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError(e.getMessage());
		errorResponse.setStatus(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
	}
	/**
	 * method to override MethodArgumentNotValid to check the inputs to the controllers
	 * ResponseEntity containing errorResponse,TIMESTAMP and status
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);
	}
}