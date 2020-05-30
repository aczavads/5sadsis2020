package aula20200529.calculoICMS;

import java.math.BigDecimal;

public class GerenciadorDeVendas {

	private GerenciadorDeParâmetros gerenciadorDeParâmetros;

	public GerenciadorDeVendas(GerenciadorDeParâmetros gdp) {
		this.gerenciadorDeParâmetros = gdp;
	}

	public Venda efetuarVenda(UnidadeFederativa uf, BigDecimal valorDaVenda) {
		return new Venda(valorDaVenda, gerenciadorDeParâmetros.getPercentualICMS(uf), uf);
	}

}
