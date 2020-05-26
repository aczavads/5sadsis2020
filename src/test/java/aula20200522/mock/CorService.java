package aula20200522.mock;

public class CorService {
	private CorRepository repo;
	
	public CorService() {
	}

	public CorService(CorRepository repo) {
		this.repo = repo;
	}
	
	public Cor encontrarPeloId(String id) {
		Cor recuperada = repo.findById(id);
		//recuperada.setNome(recuperada.getNome().toUpperCase());
		//return repo.findById(id);
		return recuperada;
	}
	
	public void renomearCor(String id, String novoNome) {
		Cor cor = repo.findById(id);
		//Cor nova = new Cor("idMaluco", novoNome);
		//repo.save(nova);
		cor.setNome(novoNome);
		repo.save(cor);
		repo.commit();
	}
	

}
