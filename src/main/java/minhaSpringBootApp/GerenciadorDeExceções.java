package minhaSpringBootApp;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenciadorDeExceções {
	
	@ExceptionHandler({RegistroNãoEncontradoException.class})
	public ResponseEntity<Void> tratar(RegistroNãoEncontradoException e) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<Void> tratar(EmptyResultDataAccessException e) {
		return ResponseEntity.notFound().build();
	}
	
}
