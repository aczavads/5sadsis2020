package springBootApp.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class TestesComPagamentos {
	@Mock
	PagamentoRepository repo;
	

	@Test
	void test01() {
		
		when(repo.findById(55L)).thenReturn(Optional.of(new Pagamento(55L, new Date(), new BigDecimal("100.00"))));

		PagamentoService service = new PagamentoService();
		service.setRepo(repo);
		
		BigDecimal valorDobrado = service.dobrarValorPagamento(55L);
		
		assertEquals(new BigDecimal("200.00"), valorDobrado);
	}

}
