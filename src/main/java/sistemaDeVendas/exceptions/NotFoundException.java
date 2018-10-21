package sistemaDeVendas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String caso) {
		super(caso + ": não encontrado");
	} 
	
	public static NotFoundException build(String caso) { // conferir se ta certo.
		return new NotFoundException(caso);
	}
}
