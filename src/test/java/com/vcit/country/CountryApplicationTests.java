package com.vcit.country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CountryApplicationTests {

	@Autowired
	CountryInfoController countryInfoController;
	
	
	@Test
	void contextLoads() {
		assertThat(countryInfoController).isNotNull();
	}

}
