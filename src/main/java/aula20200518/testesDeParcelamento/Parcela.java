package aula20200518.testesDeParcelamento;

import java.math.BigDecimal;

public class Parcela {
	//- número : int
	private int número;
	
	//- valor : BigDecimal
	private BigDecimal valor;
	
	
	//+ setValor(valor : BigDecimal) : void
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	//+ getNúmero() : int
	public int getNúmero() {
		return número;
	}
	
	//+ getValor() : BigDecimal
	public BigDecimal getValor() {
		return valor;
	}

	//+ Parcela(número : int, valor : BigDecimal)
	public Parcela(int número, BigDecimal valor) {
		this.número = número;
		this.valor = valor;
	}
}
