package trackia.app.example.calc.addition.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import trackia.app.util.RestTemplateJournal;

@Configuration
public class RestTemplateConfig {

    @Value("${server.connection-timeout:3000}") private String timeOut;

    @Bean
	public RestTemplate restTemplate() {
		int timeout = Integer.parseInt(timeOut);
        
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setReadTimeout(timeout);
		RestTemplateJournal restTemplate = new RestTemplateJournal();
		restTemplate.setRequestFactory(requestFactory);
		
		return restTemplate;
	}
}
