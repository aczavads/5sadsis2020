package aula20200508;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class NovosTestesUnitariosBasicos {

	
	
	@Test
	void testarComAssertSeNaoLancaExcecao() {
		assertDoesNotThrow(() -> {
			lancarExcecao(false);
		}, "Vixe!");
	}

	@Test
	void testarComAssertSeLancaExcecao() {
		assertThrows(RuntimeException.class, () -> {
			lancarExcecao(true);
		});
	}

	@Test
	void testarComTryCatchSeNaoLancaExcecao() {
		try {
			lancarExcecao(false);
		} catch (RuntimeException e) {
			fail("Deveria ter lançado a exceção!");
		}
	}

	@Test
	void testarComTryCatchSeLancaExcecao() {
		try {
			lancarExcecao(true);
			fail("Deveria ter lançado a exceção!");
		} catch (RuntimeException e) {
			// Não faremos nada com a exceção porque é justamente isso que queremos, que ele
			// lançe uma exceção!
		}
	}

	public void lancarExcecao(boolean lancar) {
		if (lancar) {
			throw new RuntimeException("Mensagem da exceção");
		}
	}

}
