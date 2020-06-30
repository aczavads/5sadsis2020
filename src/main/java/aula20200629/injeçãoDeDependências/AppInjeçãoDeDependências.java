package aula20200629.injeçãoDeDependências;

public class AppInjeçãoDeDependências {
	
	public static void main(String[] args) {
		
		Placar placar = new Placar() {
			@Override
			public void zerar() {
				System.out.println(">>>>>>>>>>>>>>>> zerou!");
			}
		};
		
		Jogo jogo = new Jogo(placar);
		jogo.iniciar();
		
		jogo.encerrar();
		
	}

}
