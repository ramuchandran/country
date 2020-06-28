package com.vcit.country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CountryInfoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnCapital() throws Exception {
		this.mockMvc.perform(get("/country/captial/tw")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"alpha2Code\":\"TW\",\"name\":\"Taiwan\",\"capital\":\"Taipei\"}")));
	}
	
	@Test
	public void shouldReturnNotFoundErrorCode() throws Exception {
		this.mockMvc.perform(get("/country/captial/twa")).andDo(print())
		.andExpect(status().is4xxClientError())
		.andExpect(status().reason(containsString("Country with the code do not exist")));
	}

}
