package carnerero.agustin.exceptions;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class TiendaFullException extends RuntimeException {
	
	public TiendaFullException(Long id) {
		super(MessageFormat.format("Has sobrepasado la capacidad máxima de la tienda con id; {0}", id));
	}
}
