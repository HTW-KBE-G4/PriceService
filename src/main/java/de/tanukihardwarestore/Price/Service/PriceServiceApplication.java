package de.tanukihardwarestore.Price.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
public class PriceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceServiceApplication.class, args);
	}

	@PostMapping("/price")
	public String convert(@RequestBody List<HardwareComponent> request) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		double res = PriceCalculator.addPrices(request);
		return objectMapper.writeValueAsString(new Result(res));
	}

}
