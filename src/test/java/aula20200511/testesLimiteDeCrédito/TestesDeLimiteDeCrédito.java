package aula20200511.testesLimiteDeCrédito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestesDeLimiteDeCrédito {

	@Test
	void testar_efetuar_compra_sem_limite_inicial() {
		assertThrows(LimiteDeCréditoExcedido.class, () -> {
			GerenciadorDeCompras gc = new GerenciadorDeCompras();			
			gc.efetuarCompra("484.815.336-02", 10000.00);
		});
	}	
	@Test
	void testar_efetuar_compra_sem_limite() {
		assertThrows(LimiteDeCréditoExcedido.class, () -> {
			GerenciadorDeCompras gc = new GerenciadorDeCompras();
			gc.renovarLimiteDeCrédito("484.815.336-02");
			gc.efetuarCompra("484.815.336-02", 10000.00);
			gc.efetuarCompra("484.815.336-02", 15000.00);
			
			gc.renovarLimiteDeCrédito("137.394.654-76");
			gc.efetuarCompra("137.394.654-76", 30000.00);
		});
	}	
	@Test
	void testar_efetuar_compra_com_limite() {
		assertDoesNotThrow(() -> {
			GerenciadorDeCompras gc = new GerenciadorDeCompras();
			gc.renovarLimiteDeCrédito("484.815.336-02");
			gc.efetuarCompra("484.815.336-02", 10000.00);
			gc.efetuarCompra("484.815.336-02", 15000.00);
			gc.renovarLimiteDeCrédito("484.815.336-02");
			gc.efetuarCompra("484.815.336-02", 1.00);
			
			gc.renovarLimiteDeCrédito("137.394.654-76");
			gc.efetuarCompra("137.394.654-76", 25000.00);
			
			gc.renovarLimiteDeCrédito("137.394.654-76");
			gc.efetuarCompra("137.394.654-76", 25000.00);
			
		});
	}

}
