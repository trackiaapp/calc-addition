package trackia.app.example.calc.addition.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import trackia.app.configuration.TrackiaConfiguration;
import trackia.app.util.RestTemplateJournal;

@Configuration
@AllArgsConstructor
public class RestTemplateConfig {
	final TrackiaConfiguration config;

    @Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setReadTimeout(3000);
		RestTemplateJournal restTemplate = new RestTemplateJournal(config);
		restTemplate.setRequestFactory(requestFactory);
		
		return restTemplate;
	}
}
