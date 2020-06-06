package springBootApp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler({RegistroNãoEncontrado.class}) 
	public ResponseEntity<Void> handleNotFound(RegistroNãoEncontrado e) {
		return ResponseEntity.notFound().build();
	}

}
