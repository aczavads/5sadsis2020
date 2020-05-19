package aula20200518.testesDeParcelamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Parcelamento {

	//+ parcelar(valorParaParcelar : BigDecimal, quantidadeDeParcelas : int, diferençaNaPrimeiraParcela : boolean, valorMínimoDaParcela : BigDecimal) : List<Parcela>
	public static List<Parcela> parcelar(
			DecimalMaiorQueZero valorParaParcelar, InteiroMaiorQueZero quantidadeDeParcelas, boolean diferençaNaPrimeiraParcela, DecimalPositivo valorMínimoDaParcela) {
			
		BigDecimal valorParcela = valorParaParcelar.getValor().divide(new BigDecimal(quantidadeDeParcelas.getValor()), 2, RoundingMode.HALF_DOWN);		
		validarSeValorParcelaSuperiorAoMínimo(valorParcela, valorMínimoDaParcela.getValor());
		
		BigDecimal diferença = valorParaParcelar.getValor().subtract(valorParcela.multiply(new BigDecimal(quantidadeDeParcelas.getValor())));
		ArrayList<Parcela> parcelas = new ArrayList<>();
		for (int i = 1; i <= quantidadeDeParcelas.getValor(); i++) {
			parcelas.add(new Parcela(i, valorParcela));
		}		
		if (diferençaNaPrimeiraParcela) {
			parcelas.get(0).setValor(valorParcela.add(diferença));
		} else {
			parcelas.get(parcelas.size()-1).setValor(valorParcela.add(diferença));
		}
		return parcelas;
	}

	private static void validarSeValorParcelaSuperiorAoMínimo(BigDecimal valorDaParcela, BigDecimal valorMínimoDaParcela) {
		if (valorDaParcela.compareTo(valorMínimoDaParcela)<0) {
			throw new ValorDaParcelaInferiorAoValorMínimoException();
		}		
	}

}
