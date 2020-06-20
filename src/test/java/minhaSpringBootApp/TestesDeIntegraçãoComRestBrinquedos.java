package minhaSpringBootApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import minhaSpringBootApp.brinquedo.Brinquedo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TestesDeIntegraçãoComRestBrinquedos {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	void testandoGetByIdComDadoInexistente() throws Exception {
		//restTemplate.postForEntity("/api/brinquedos", new Brinquedo("006fcc26-32c8-4403-bbed-d1571241bff2", "teste", 18), String.class);
		
		ResponseEntity<Brinquedo> resposta = restTemplate.getForEntity("/api/brinquedos/006fcc26-32c8-4403-bbed-d1571241bff2", Brinquedo.class);
		assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
	}
	
	@Test
	void testandoPost() throws Exception {
		final String ID = "9ed74865-5dde-461e-a31a-80611912b8e8";
		ResponseEntity<String> resposta = restTemplate.postForEntity("/api/brinquedos", new Brinquedo(ID, "teste", 18), String.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(ID, resposta.getBody());
	}


}
