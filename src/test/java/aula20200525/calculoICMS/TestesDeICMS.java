package aula20200525.calculoICMS;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class TestesDeICMS {

	@Test
	void testar_se_venda_possuí_icms_correto_conforme_unidade_federativa() {
		UnidadeFederativa pr = new UnidadeFederativa("PR");
		UnidadeFederativa sc = new UnidadeFederativa("SC");
		UnidadeFederativa sp = new UnidadeFederativa("SP");
		
		GerenciadorDeParâmetros gdp = new GerenciadorDeParâmetrosDefault();		
		GerenciadorDeVendas gerenciadorDeVendas = new GerenciadorDeVendas(gdp);
		
		BigDecimal alíquotaPR = gdp.getPercentualICMS(pr);
		BigDecimal alíquotaSC = gdp.getPercentualICMS(sc);
		BigDecimal alíquotaSP = gdp.getPercentualICMS(sp);
		
		Venda vendaPR = gerenciadorDeVendas.efetuarVenda(pr, new BigDecimal("2000.00"));
		Venda vendaSC = gerenciadorDeVendas.efetuarVenda(sc, new BigDecimal("2000.00"));
		Venda vendaSP = gerenciadorDeVendas.efetuarVenda(sp, new BigDecimal("2000.00"));
		
		assertEquals(alíquotaPR, vendaPR.getAlíquotaICMS());
		assertEquals(alíquotaSC, vendaSC.getAlíquotaICMS());
		assertEquals(alíquotaSP, vendaSP.getAlíquotaICMS());
		assertEquals(new BigDecimal("17.00"), vendaPR.getAlíquotaICMS());
		assertEquals(new BigDecimal("7.00"), vendaSC.getAlíquotaICMS());
		assertEquals(new BigDecimal("12.00"), vendaSP.getAlíquotaICMS());
	}

}
