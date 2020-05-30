package aula20205029.springBootApp.pagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PagamentoService {
	private PagamentoRepository repo;
	
	
	@Autowired
	public void setRepo(PagamentoRepository repo) {
		this.repo = repo;
	}
	
	public BigDecimal dobrarValorPagamento(Long id) {
		Pagamento pagamento = repo.findById(id).get();
		return pagamento.getValor().multiply(new BigDecimal("2.00")).setScale(2, RoundingMode.DOWN);
	}


	public void gravarPagamentoTeste(Long id, Date pagoEm, BigDecimal valor) {
		Pagamento p = new Pagamento(id, pagoEm, valor);
		repo.save(p);
	}

}
