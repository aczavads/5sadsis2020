package adapter.base;

import composite.fornecedorComCarga.FornecedorDeEnergia;

public class AdaptadorSubclasseDeGeradorParaFornecedor extends GeradorDeEnergiaNuclear implements FornecedorDeEnergia {

	@Override
	public double fornecer() {
		//Isto NÃO É um delegation!
		return this.energizar();
	}
}
