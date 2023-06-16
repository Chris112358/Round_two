package com.example.call_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CallApiApplication {

	private static final Logger log = LoggerFactory.getLogger(CallApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CallApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {

			String[] names = {"", "World", "Mickey Mouse", "Christian"};
			String[] params = new String[names.length];

			for (int i = 0; i<names.length; i++) {
				String name = names[i];
				String para;
				if (!name.equals("")) {
					para = "?name=" + name;
				}
				else{
					para = "";
				}
				params[i] = para;
			}

			for (String i : params) {
				Hello phrase = restTemplate.getForObject(
						"http://localhost:8080/api/showHello" + i, Hello.class);
				log.info(phrase.toString());
				System.out.println(phrase.toString());
			}
		};
	}

}
