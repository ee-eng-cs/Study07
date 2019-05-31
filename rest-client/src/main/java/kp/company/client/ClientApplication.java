package kp.company.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import kp.company.domain.Company;

/**
 * The RESTful Web Service client application.
 *
 */
@SpringBootApplication
public class ClientApplication {
	private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

	private static final String COMPANY_URL = "http://localhost:8080/company/";

	/**
	 * Main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		SpringApplication.run(ClientApplication.class);
	}

	/**
	 * Produces the REST template.
	 * 
	 * @param builder the REST template builder
	 * @return the REST template
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/**
	 * Produces the command line runner.
	 * 
	 * @param restTemplate the REST template
	 * @return the command line runner
	 * @throws Exception the exception
	 */
	@Bean
	public CommandLineRunner produceRunner(RestTemplate restTemplate) throws Exception {
		return args -> {
			final Company company = restTemplate.getForObject(COMPANY_URL, Company.class);
			logger.info(String.format("run(): company name[%s]", company.getName()));
		};
	}
}