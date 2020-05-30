package aula20200529.calculoICMS;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeParâmetrosDefault implements GerenciadorDeParâmetros {
	private Map<UnidadeFederativa, BigDecimal> alíquotasICMS = new HashMap<>();

	public GerenciadorDeParâmetrosDefault() {
		alíquotasICMS.put(new UnidadeFederativa("PR"), new BigDecimal("17.00"));
		alíquotasICMS.put(new UnidadeFederativa("SC"), new BigDecimal("7.00"));
		alíquotasICMS.put(new UnidadeFederativa("SP"), new BigDecimal("12.00"));
	}
	
	@Override
	public BigDecimal getPercentualICMS(UnidadeFederativa uf) {
		return this.alíquotasICMS.get(uf);
	}

}
