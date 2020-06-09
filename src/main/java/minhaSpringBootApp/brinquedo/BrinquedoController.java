package minhaSpringBootApp.brinquedo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brinquedos")
public class BrinquedoController {
	@Autowired
	private BrinquedoService service;

	@GetMapping
	public List<Brinquedo> getAll() {
		return service.encontrarTodos();
	}

	@GetMapping("/{id}")
	public Brinquedo getById(@PathVariable("id") String id) {
		return service.encontrarPeloId(id);
	}

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public String post(@RequestBody Brinquedo novo) {
		return service.salvar(novo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> put(@PathVariable("id") String id, @RequestBody Brinquedo alterado) {
		if (!id.equals(alterado.getId())) {
			return ResponseEntity.badRequest().build();
		}
		service.salvar(alterado);
		return ResponseEntity.ok().build();
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") String id) {
		service.excluirPeloId(id);
	}

}
