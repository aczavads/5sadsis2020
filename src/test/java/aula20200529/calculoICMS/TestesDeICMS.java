package aula20200529.calculoICMS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class TestesDeICMS {
	@Mock
	GerenciadorDeParâmetros gerenciadorDeParâmetros;

	@Test
	void testar_se_venda_possuí_icms_correto_conforme_unidade_federativa_com_mock() {
		UnidadeFederativa pr = new UnidadeFederativa("PR");
		UnidadeFederativa sc = new UnidadeFederativa("SC");
		UnidadeFederativa sp = new UnidadeFederativa("SP");
		
		//GerenciadorDeParâmetros gdp = new GerenciadorDeParâmetrosDefault();		
		//GerenciadorDeVendas gerenciadorDeVendas = new GerenciadorDeVendas(gdp);
		when(gerenciadorDeParâmetros.getPercentualICMS(pr)).thenReturn(new BigDecimal("17.00"));
		when(gerenciadorDeParâmetros.getPercentualICMS(sp)).thenReturn(new BigDecimal("12.00"));
		when(gerenciadorDeParâmetros.getPercentualICMS(sc)).thenReturn(new BigDecimal("7.00"));
		//when(gerenciadorDeParâmetros.getPercentualICMS(null)).thenThrow(new RuntimeException("Estado deve ser informado!"));
		
		GerenciadorDeVendas gerenciadorDeVendas = new GerenciadorDeVendas(gerenciadorDeParâmetros);
		
		BigDecimal alíquotaPR = gerenciadorDeParâmetros.getPercentualICMS(pr);
		BigDecimal alíquotaSC = gerenciadorDeParâmetros.getPercentualICMS(sc);
		BigDecimal alíquotaSP = gerenciadorDeParâmetros.getPercentualICMS(sp);
		
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
