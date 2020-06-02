package springBootApp.pagamento;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@AutoConfigureMockMvc
class TestesComApiRestMockMvc {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PagamentoService service;
	

	@Test
	void testar_get_api_pagamentos() throws Exception {
		mockMvc.perform(get("/api/pagamentos/33")).andExpect(status().isOk());
	}
	@Test
	void testar_post_api_pagamentos() throws Exception {
		String s = mockMvc.perform(post("/api/pagamentos/33")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println(s); 
	}

}
