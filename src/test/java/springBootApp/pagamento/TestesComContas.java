package springBootApp.pagamento;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import springBootApp.conta.ContaService;

@WebMvcTest
@AutoConfigureMockMvc
class TestesComContas {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContaService service;

	@Test
	void test() throws Exception {
		mockMvc.perform(get("api/contas/78a197b3-254a-4f54-ad96-25ae11900eb3X")).andExpect(status().isNotFound());
	}

}
