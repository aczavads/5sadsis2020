package aula20200518.testesDeParcelamento;


public class InteiroMaiorQueZero {
	private Integer valor;
	
	public InteiroMaiorQueZero(int valor) {
		if (valor <= 0) {
			throw new ValorInválidoException();
		}
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
}
