package minhaSpringBootApp.brinquedo;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class Brinquedo {
	@Id
	private String id;
	
	private String nome;
	
	private Integer idadeMinimaEmMeses;
	

	public Brinquedo(String id, String nome, Integer idadeMinimaEmMeses) {
//		if (nome == null || nome.trim().length() == 0) {
//			throw new ValorInválidoException(); 
//		}
		this.id = id;
		this.nome = nome;
		this.idadeMinimaEmMeses = idadeMinimaEmMeses;
	}

	public Brinquedo() {
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Integer getIdadeMinimaEmMeses() {
		return idadeMinimaEmMeses;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdadeMinimaEmMeses(Integer idadeMinimaEmMeses) {
		this.idadeMinimaEmMeses = idadeMinimaEmMeses;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brinquedo other = (Brinquedo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
