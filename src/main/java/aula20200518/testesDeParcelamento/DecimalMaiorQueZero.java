package aula20200518.testesDeParcelamento;

import java.math.BigDecimal;

public class DecimalMaiorQueZero {
	private BigDecimal valor;

	public DecimalMaiorQueZero(String valor) {
		if (valor == null) {
			throw new ValorInválidoException();
		}
		this.valor = new BigDecimal(valor);
		if (this.valor.compareTo(BigDecimal.ZERO) <= 0) {
			throw new ValorInválidoException();
		}
	}
	
	public BigDecimal getValor() {
		return valor;
	}

}
