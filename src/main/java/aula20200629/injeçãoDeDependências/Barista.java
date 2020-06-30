package aula20200629.injeçãoDeDependências;

public class Barista {

	public Café prepararCafé(double quantidadeEmMl, 
			Cafeteira cafeteira, Filtro filtro, Água água, GrãoDeCafé grãos, Moinho moinho) {
		if (água.getPh() > 5.5) {
			throw new RuntimeException("Água muito ácida!");
		}
		cafeteira.loadFiltro(filtro);
		cafeteira.loadCaféMoído(moinho.moer(grãos, 3));
		return new Café();
	}

	public Café prepararCafé(double quantidadeEmMl) {
		Cafeteira cafeteira = buscarCafeteira();
		Filtro filtro = buscarFiltro();
		Água água = buscarÁgua();
		GrãoDeCafé grãos = buscarGrãosDeCafé(quantidadeEmMl);
		Moinho moinho = buscarMoinho();
		if (água.getPh() > 5.5) {
			throw new RuntimeException("Água muito ácida!");
		}
		cafeteira.loadFiltro(filtro);
		cafeteira.loadCaféMoído(moinho.moer(grãos, 3));
		return new Café();
	}

	private Moinho buscarMoinho() {
		// TODO Auto-generated method stub
		return null;
	}

	private GrãoDeCafé buscarGrãosDeCafé(double quantidadeEmMl) {
		// TODO Auto-generated method stub
		return null;
	}

	private Água buscarÁgua() {
		// TODO Auto-generated method stub
		return null;
	}

	private Filtro buscarFiltro() {
		// TODO Auto-generated method stub
		return null;
	}

	private Cafeteira buscarCafeteira() {
		// TODO Auto-generated method stub
		return null;
	}

}
