package aula20200515.testesDeParcelamento;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestesComParcelamento {

	@Test
	void testar_se_valor_total_das_parcelas_esta_correto() {
		List<Parcela> parcelas = Parcelamento.parcelar(new BigDecimal("1000.00"), 3, false, new BigDecimal("300.00"));
		BigDecimal total = new BigDecimal("0.00");
		for (Parcela parcela : parcelas) {
			total = total.add(parcela.getValor());
		}
		assertEquals(new BigDecimal("1000.00"), total);
	}

	@Test
	void testar_valor_menor_parcela_maior_que_valor() {
		assertThrows(ValorDaParcelaInferiorAoValorMínimoException.class, () -> {
			List<Parcela> parcelas = Parcelamento.parcelar(new BigDecimal("20.00"), 2, false, new BigDecimal("30.00"));
		});
	}

	@Test
	void testar_100_em_duas_parcelas_valor_ok() {
		List<Parcela> parcelas = Parcelamento.parcelar(new BigDecimal("100.00"), 2, true, new BigDecimal("7.00"));

		assertEquals(2, parcelas.size());

		assertEquals(new BigDecimal("50.00"), parcelas.get(0).getValor());
		assertEquals(1, parcelas.get(0).getNúmero());

		assertEquals(new BigDecimal("50.00"), parcelas.get(1).getValor());
		assertEquals(2, parcelas.get(1).getNúmero());
	}

	@Test
	void testar_100_em_três_parcelas_valor_ok_diferença_na_primeira() {
		List<Parcela> parcelas = Parcelamento.parcelar(new BigDecimal("100.00"), 3, true, new BigDecimal("7.00"));

		assertEquals(3, parcelas.size());

		assertEquals(new BigDecimal("33.34"), parcelas.get(0).getValor());
		assertEquals(1, parcelas.get(0).getNúmero());

		assertEquals(new BigDecimal("33.33"), parcelas.get(1).getValor());
		assertEquals(2, parcelas.get(1).getNúmero());

		assertEquals(new BigDecimal("33.33"), parcelas.get(2).getValor());
		assertEquals(3, parcelas.get(2).getNúmero());

	}

}
