package springBootApp.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TestesComApiRest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testar_get_api_pagamentos() throws Exception {
		ResponseEntity<Void> response = restTemplate.getForEntity("/api/pagamentos/33", Void.class);
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	void testar_post_api_pagamentos() throws Exception {
		BigDecimal response = restTemplate.postForObject("/api/pagamentos/33", "", BigDecimal.class);		
		assertTrue(response.doubleValue() > 0);
	}

}
