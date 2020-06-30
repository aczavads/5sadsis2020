package aula20200629.injeçãoDeDependências;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Jogo {
	private Placar placar;
	
	@Autowired
	public Jogo(Placar placar) {
		//this.placar = new Placar();
		this.placar = placar;
	}
	
	public void iniciar() {
		System.out.println("Iniciando o jogo.");
		placar.zerar();
	}
	
	public void encerrar() {
		System.out.println("Encerrando o jogo.");		
	}

}
