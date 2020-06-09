package minhaSpringBootApp;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import minhaSpringBootApp.brinquedo.Brinquedo;
import minhaSpringBootApp.brinquedo.BrinquedoController;
import minhaSpringBootApp.brinquedo.BrinquedoService;

@WebMvcTest
@AutoConfigureMockMvc
class TestesComRestBrinquedos {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private BrinquedoController controller;
	
	@MockBean
	private BrinquedoService service;

	
	@Test
	void testandoGetByIdComDadoExistente() throws Exception {
		Brinquedo b = new Brinquedo("1", "Teste", 18);
		
		when(service.encontrarPeloId("1")).thenReturn(b);
		
		mockMvc.perform(get("/api/brinquedos/1"))
		.andExpect(jsonPath("$.id").value("1"))
		.andExpect(jsonPath("$.nome").value("Teste"))
		.andExpect(jsonPath("$.idadeMinimaEmMeses").value(18))
		.andExpect(status().isOk());
	}
	
	@Test
	void testandoGetByIdComDadoInexistente() throws Exception {		
		when(service.encontrarPeloId("2")).thenThrow(RegistroNãoEncontradoException.class);
		
		mockMvc.perform(get("/api/brinquedos/2"))
		.andExpect(status().isNotFound());
	}

	@Test
	void testandoGetAll() throws Exception {
		Brinquedo a = new Brinquedo("1", "Teste1", 1);
		Brinquedo b = new Brinquedo("2", "Teste2", 2);
		Brinquedo c = new Brinquedo("3", "Teste3", 3);
		when(service.encontrarTodos()).thenReturn(Arrays.asList(a,b,c));
		
		mockMvc.perform(get("/api/brinquedos"))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$.[0].id").value("1"))
		.andExpect(jsonPath("$.[1].id").value("2"))
		.andExpect(jsonPath("$.[2].id").value("3"))
		.andExpect(jsonPath("$.[0].nome").value("Teste1"))
		.andExpect(jsonPath("$.[1].nome").value("Teste2"))
		.andExpect(jsonPath("$.[2].nome").value("Teste3"))
		.andExpect(jsonPath("$.[0].idadeMinimaEmMeses").value("1"))
		.andExpect(jsonPath("$.[1].idadeMinimaEmMeses").value("2"))
		.andExpect(jsonPath("$.[2].idadeMinimaEmMeses").value("3"))
		.andExpect(status().isOk());
	}
	
	
	@Test
	void testandoPost() throws Exception {
		when(service.salvar(ArgumentMatchers.any(Brinquedo.class))).thenReturn("5c116792-9a5e-4970-bce7-83005422b1ec");
		
		Map<String, String> giraGira  = new HashMap<String, String>() {{
		    put("id", "5c116792-9a5e-4970-bce7-83005422b1ec");
		    put("nome", "Gira Gira");
		    put("idadeMinimaEmMeses", "12");
		}};
		
		String giraGiraAsJson = objectMapper.writeValueAsString(giraGira);
		
		/*
		String giraGiraAsJson = "{" 
		+ "\"id\": \"5c116792-9a5e-4970-bce7-83005422b1ec\"," 
		+ "\"nome\": \"Gira Gira\"," 
		+ "\"idadeMinimaEmMeses\": 12" 
		+ "}";
		*/
		
		mockMvc.perform(post("/api/brinquedos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(giraGiraAsJson))
		.andExpect(status().isCreated())
		.andExpect(content().string("5c116792-9a5e-4970-bce7-83005422b1ec"));
	}
	
	

}
