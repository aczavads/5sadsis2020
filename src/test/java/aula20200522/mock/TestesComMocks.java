package aula20200522.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

class TestesComMocks {

	@Test
	void testar_encontrarPeloId() {
		CorRepository repo = Mockito.mock(CorRepository.class);
		when(repo.findById("125")).thenReturn(new Cor("125", "teste"));
		
		CorService service = new CorService(repo);
		Cor recuperada = service.encontrarPeloId("125");
		
		assertNotNull(recuperada);
		assertEquals("125", recuperada.getId());	
		assertEquals("teste", recuperada.getNome());	
		verify(repo, times(1)).findById("125");
	}
	/*
	@Test
	void testar_encontrarPeloId() {
		CorRepository repo = new CorRepository() {
			int contadorChamadaFindById;
			int contadorChamadaRollback;
			int contadorChamadaSave;
			int contadorChamadaCommit;
			@Override
			public void save(Cor cor) {
				contadorChamadaSave++;
			}
			
			@Override
			public void rollback() {
				contadorChamadaRollback++;
			}
			
			@Override
			public Cor findById(String id) {
				contadorChamadaFindById++;
				return new Cor(id, "teste");
			}
			
			@Override
			public void commit() {
				contadorChamadaCommit++;
			}
			
		};
		CorService service = new CorService(repo);
		Cor recuperada = service.encontrarPeloId("125");
		
		assertNotNull(recuperada);
		assertEquals("125", recuperada.getId());	
		assertEquals(1, contadorChamadaFindById);
	}
	*/
	
	
	@Test
	void testar_renomearCor() {
		CorRepository repo =  Mockito.mock(CorRepository.class);
		ArgumentCaptor<Cor> captorCor = ArgumentCaptor.forClass(Cor.class);		
		
		when(repo.findById("22")).thenReturn(new Cor("22","Blue"));
		
		CorService service = new CorService(repo);
		service.renomearCor("22", "Azul");
				
		verify(repo).findById("22");
		verify(repo).commit();
		verify(repo, never()).rollback();
		
		verify(repo).save(captorCor.capture());		
		assertEquals("22", captorCor.getValue().getId());
		assertEquals("Azul", captorCor.getValue().getNome());

	}

}
