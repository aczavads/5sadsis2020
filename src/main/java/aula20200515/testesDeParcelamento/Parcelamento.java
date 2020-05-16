package aula20200515.testesDeParcelamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Parcelamento {

	//+ parcelar(valorParaParcelar : BigDecimal, quantidadeDeParcelas : int, diferençaNaPrimeiraParcela : boolean, valorMínimoDaParcela : BigDecimal) : List<Parcela>
	public static List<Parcela> parcelar(
			BigDecimal valorParaParcelar, int quantidadeDeParcelas, boolean diferençaNaPrimeiraParcela, BigDecimal valorMínimoDaParcela) {
		
		validarValorPositivo(valorParaParcelar);
		validarValorPositivo(valorMínimoDaParcela);
		validarValorPositivo(quantidadeDeParcelas);
		
		BigDecimal valorParcela = valorParaParcelar.divide(new BigDecimal(quantidadeDeParcelas), 2, RoundingMode.HALF_DOWN);
		BigDecimal diferença = valorParaParcelar.subtract(valorParcela.multiply(new BigDecimal(quantidadeDeParcelas)));
		ArrayList<Parcela> parcelas = new ArrayList<>();
		for (int i = 1; i <= quantidadeDeParcelas; i++) {
			parcelas.add(new Parcela(i, valorParcela));
		}		
		if (diferençaNaPrimeiraParcela) {
			parcelas.get(0).setValor(valorParcela.add(diferença));
		} else {
			parcelas.get(parcelas.size()-1).setValor(valorParcela.add(diferença));
		}
		return parcelas;
	}

	private static void validarValorPositivo(int valor) {
		if (valor <= 0) {
			throw new ValorInválidoException();
		}
	}

	private static void validarValorPositivo(BigDecimal valor) {
		if (valor == null || valor.doubleValue() <= 0.00) {
			throw new ValorInválidoException();
		}
	}
	
}
