package telran.java53.edutrek.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ContactAlreadyExistsException extends RuntimeException {
	public ContactAlreadyExistsException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
}
