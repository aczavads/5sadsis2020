package springBootApp.conta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contas")
public class ContaController {
	@Autowired
	private ContaService service;
	
	@PostMapping
	public String post(@RequestBody Conta nova) {
		return service.salvar(nova).getId();
	}
	
	@GetMapping
	public List<Conta> getAll() {
		return service.encontrarTodas();
	}
	
	@GetMapping("/{id}")
	public Conta getOne(@PathVariable("id") String id) {
		return service.encontrarPeloId(id);
	}

}
