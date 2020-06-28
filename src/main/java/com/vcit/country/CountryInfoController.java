package com.vcit.country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CountryInfoController {
	
	RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(CountryInfoController.class);
	
	public CountryInfoController(RestTemplateBuilder templateBuilder) {
		restTemplate = templateBuilder.build();
	}
	
	@GetMapping("/")
	public String greet() {
		return "Hello World";
	}

	@GetMapping("/country/captial/{code}")
	public CountryInfo capital(@PathVariable String code) {
		
		System.out.println("Capital");
		CountryInfo countryInfo= null;
		try {
			ResponseEntity<CountryInfo> entity = restTemplate.getForEntity("https://restcountries.eu/rest/v2/alpha/"+code, CountryInfo.class);
			logger.info("Status Code Value :"+entity.getStatusCodeValue());
			countryInfo = entity.getBody();
			logger.info("CountyInfo :"+ countryInfo);
			logger.info("Status Code :"+entity.getStatusCode());
			
		}catch (HttpClientErrorException exception) {
			logger.info("Exception :"+exception.getStatusCode());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Country with the code do not exist.");
		}
		return countryInfo;
	}
}
