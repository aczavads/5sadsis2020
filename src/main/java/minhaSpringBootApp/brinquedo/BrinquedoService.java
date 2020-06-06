package minhaSpringBootApp.brinquedo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import minhaSpringBootApp.RegistroNãoEncontradoException;

@Service
@Transactional
public class BrinquedoService {
	@Autowired
	private BrinquedoRepository repo;
	
	public String salvar(Brinquedo b) {
		return repo.save(b).getId();
	}
	
	public void excluirPeloId(String id) {
		repo.deleteById(id);
	}
	
	public List<Brinquedo> encontrarTodos() {
		return repo.findAll();
	}
	
	public Brinquedo encontrarPeloId(String id) {
		//return repo.findById(id).get();
		return repo.findById(id).orElseThrow(RegistroNãoEncontradoException::new);
	}

}
