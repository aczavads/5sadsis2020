package adapter.base;

import composite.fornecedorComCarga.FornecedorDeEnergia;

public class AdaptadorDeGeradorNuclearParaFornecedorDeEnergia implements FornecedorDeEnergia {
	private GeradorDeEnergiaNuclear gerador;

	public AdaptadorDeGeradorNuclearParaFornecedorDeEnergia(GeradorDeEnergiaNuclear gerador) {
		this.gerador = gerador;
	}
	
	@Override
	public double fornecer() {
		return gerador.energizar();
	}
}
