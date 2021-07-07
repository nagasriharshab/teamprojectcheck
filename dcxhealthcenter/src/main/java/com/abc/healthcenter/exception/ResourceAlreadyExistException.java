<<<<<<< HEAD
package com.abc.healthcenter.exception;

public class ResourceAlreadyExistException extends RuntimeException {
	
	public ResourceAlreadyExistException(String message) {
		super(message);
	}

}
=======
package com.abc.healthcenter.exception;
/**
 * Exception to handle bad requests that attempts duplicate value injection
 * @author NAGA SRI HARSHA
 * date : 07-July-2021
 */
public class ResourceAlreadyExistException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistException(String msg) {
		super(msg);
	}
}
>>>>>>> branch 'master' of https://github.com/likhithlucky/Team1.git
