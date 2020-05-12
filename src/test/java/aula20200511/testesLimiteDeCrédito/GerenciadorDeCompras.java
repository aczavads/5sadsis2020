package aula20200511.testesLimiteDeCrédito;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeCompras {
	private static final double LIMITE_DE_CRÉDITO_PADRÃO = 25000.00;
	private Map<String, Double> limitePorCpfCliente = new HashMap<>();

	public void efetuarCompra(String cpfCliente, double valor) {
		if (!limitePorCpfCliente.containsKey(cpfCliente)) {
			throw new LimiteDeCréditoExcedido();
		}
		Double saldoLimiteDeCrédito = limitePorCpfCliente.get(cpfCliente);
		if (saldoLimiteDeCrédito - valor < 0.00) {
			throw new LimiteDeCréditoExcedido();			
		}
		limitePorCpfCliente.put(cpfCliente, saldoLimiteDeCrédito - valor);		
	}

	public void renovarLimiteDeCrédito(String cpfCliente) {
		limitePorCpfCliente.put(cpfCliente, LIMITE_DE_CRÉDITO_PADRÃO);
	}

}
