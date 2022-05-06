package de.tanukihardwarestore.Price.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void addPricesTestCase1() throws Exception {
		final String baseUrl = "http://localhost:"+port+"/price";
		URI uri = new URI(baseUrl);
		List<HardwareComponent> request = new LinkedList<>();

		request.add(new HardwareComponent(5552.09F));
		request.add(new HardwareComponent(1300.00F));
		request.add(new HardwareComponent(77.96F));
		request.add(new HardwareComponent(406.95F));
		request.add(new HardwareComponent(96.00F));
		request.add(new HardwareComponent(73.87F));

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<List<HardwareComponent>> httpRequest = new HttpEntity<>(request, headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, httpRequest, String.class);

		String expectedJSON = "{\"total\":7506.87}";

		assertEquals(200, result.getStatusCodeValue());
		assertEquals(expectedJSON,result.getBody());
	}

	@Test
	public void addPricesTestCase2() throws Exception {
		final String baseUrl = "http://localhost:"+port+"/price";
		URI uri = new URI(baseUrl);
		List<HardwareComponent> request = new LinkedList<>();

		request.add(new HardwareComponent(5552.09F));
		request.add(new HardwareComponent(142.78F));
		request.add(new HardwareComponent(77.96F));
		request.add(new HardwareComponent(87.68F));
		request.add(new HardwareComponent(96.00F));
		request.add(new HardwareComponent(73.87F));

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<List<HardwareComponent>> httpRequest = new HttpEntity<>(request, headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, httpRequest, String.class);

		String expectedJSON = "{\"total\":6030.38}";

		assertEquals(200, result.getStatusCodeValue());
		assertEquals(expectedJSON,result.getBody());
	}

	@Test
	public void addPricesEmptyList() throws Exception {
		final String baseUrl = "http://localhost:"+port+"/price";
		URI uri = new URI(baseUrl);
		List<HardwareComponent> request = new LinkedList<>();

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<List<HardwareComponent>> httpRequest = new HttpEntity<>(request, headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, httpRequest, String.class);

		String expectedJSON = "{\"total\":0.0}";

		assertEquals(200, result.getStatusCodeValue());
		assertEquals(expectedJSON,result.getBody());
	}

}
