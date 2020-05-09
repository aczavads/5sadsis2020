package aula20200508;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestesUnitariosBasicos {

	@Test
	void testarGerarExceção() {
		
		assertThrows(RuntimeException.class, () -> {
			gerarExceção();
		});
		
	}
	
	
	public void gerarExceção() {
		throw new RuntimeException("Teste");
	}

}
