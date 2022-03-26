package carnerero.agustin.exceptions;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code=HttpStatus.NO_CONTENT)
public class CuadroNotFoundException extends RuntimeException{
	public CuadroNotFoundException(long id) {
		super(MessageFormat.format("No se ha podido encontrar el cuadro con id; {0}", id));
	}
	
}
