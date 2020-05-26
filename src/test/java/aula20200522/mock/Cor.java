package aula20200522.mock;

public class Cor {
	private String id;
	private String nome;

	public Cor(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.trim().length() == 0) {
			throw new RuntimeException("Nome da Cor não pode ser nulo nem vazio!");
		}
		this.nome = nome;
	}

}
