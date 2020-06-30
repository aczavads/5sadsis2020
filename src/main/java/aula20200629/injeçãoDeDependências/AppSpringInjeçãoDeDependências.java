package aula20200629.injeçãoDeDependências;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppSpringInjeçãoDeDependências implements CommandLineRunner {
	@Autowired
	private Jogo jogo;
	
	public static void main(String[] args) {
		SpringApplication.run(AppSpringInjeçãoDeDependências.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jogo.iniciar();	
		jogo.encerrar();	
	}
	
	@Bean
	public Placar placar() {
		return new Placar() {
			@Override
			public void zerar() {
				System.out.println("--------------------> rapaz... zerou!");
			}
		};
	}

}
