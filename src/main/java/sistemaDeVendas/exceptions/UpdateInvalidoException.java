package sistemaDeVendas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UpdateInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UpdateInvalidoException(String caso) {
		super(caso + ": é invalido para update.");
	}
	

}
