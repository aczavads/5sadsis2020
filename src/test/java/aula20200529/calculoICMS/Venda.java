package aula20200529.calculoICMS;

import java.math.BigDecimal;

public class Venda {

	private BigDecimal valorDaVenda;
	private BigDecimal alíquotaICMS;
	private UnidadeFederativa ufDestino;

	public Venda(BigDecimal valorDaVenda, BigDecimal alíquotaICMS, UnidadeFederativa ufDestino) {
		this.valorDaVenda = valorDaVenda;
		this.alíquotaICMS = alíquotaICMS;
		this.ufDestino = ufDestino;
	}
	
	public BigDecimal getAlíquotaICMS() {
		return alíquotaICMS;
	}
	public BigDecimal getValorDaVenda() {
		return valorDaVenda;
	}
	public UnidadeFederativa getUfDestino() {
		return ufDestino;
	}

}
