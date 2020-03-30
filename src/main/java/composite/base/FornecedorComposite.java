package composite.base;

import java.util.ArrayList;
import java.util.List;

public class FornecedorComposite implements FornecedorDeEnergia {
	private List<FornecedorDeEnergia> fornecedoresDeEnergia;

	public FornecedorComposite() {
		fornecedoresDeEnergia = new ArrayList<>();
	}
	
	@Override
	public void fornecer() {
		/*
		for (FornecedorDeEnergia fe : fornecedoresDeEnergia) {
			fe.fornecer();
		}
		*/
		fornecedoresDeEnergia.forEach(fe -> fe.fornecer());
		
	}

	public void adicionarFornecedor(FornecedorDeEnergia fornecedor) {
		this.fornecedoresDeEnergia.add(fornecedor);
	}

}
