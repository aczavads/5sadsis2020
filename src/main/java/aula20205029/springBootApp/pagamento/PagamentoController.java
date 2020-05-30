package aula20205029.springBootApp.pagamento;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
	@Autowired
	private PagamentoService service;
	
	@GetMapping("/{id}")
	public void get(@PathVariable("id") Long id) {
		service.gravarPagamentoTeste(id, new Date(), new BigDecimal(System.currentTimeMillis()));
	}
	
	@PostMapping("/{id}")
	public BigDecimal post(@PathVariable("id") Long id) {
		System.out.println(">>> " + id);
		return service.dobrarValorPagamento(id);
	}
	

}
