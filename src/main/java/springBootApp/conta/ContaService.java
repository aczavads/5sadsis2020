package springBootApp.conta;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootApp.RegistroNãoEncontrado;

@Service
@Transactional
public class ContaService {
	@Autowired
	private ContaRepository repo;
	
	
	public Conta encontrarPeloId(String id) {
		return repo.findById(id).orElseThrow(RegistroNãoEncontrado::new);
	}
	
	public Conta salvar(Conta c) {
		return repo.save(c);
	}

	public List<Conta> encontrarTodas() {
		return repo.findAll();
	}

}
