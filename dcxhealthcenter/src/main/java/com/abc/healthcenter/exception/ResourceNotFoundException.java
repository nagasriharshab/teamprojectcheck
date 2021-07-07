<<<<<<< HEAD
package com.abc.healthcenter.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
=======
package com.abc.healthcenter.exception;
/**
 * Exception to handle bad requests asking for unavailable resources
 * @author NAGA SRI HARSHA
 * date : 07-Jul-2021
 */
public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4221517700552239490L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
>>>>>>> branch 'master' of https://github.com/likhithlucky/Team1.git
