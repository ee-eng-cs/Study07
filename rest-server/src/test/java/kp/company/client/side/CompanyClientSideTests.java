package kp.company.client.side;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import kp.company.domain.Company;

/**
 * Client side tests for company.<br>
 * The server is <b>started</b>.<br>
 * 
 * The full-stack integration test.<br>
 * Loads a WebServerApplicationContext and provides a real web environment.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyClientSideTests {
	private static final Log logger = LogFactory.getLog(CompanyClientSideTests.class);

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String COMPANY_NAME_BEGIN = "C-o-m-p-a-n-y-";

	/**
	 * Should find company.
	 */
	@Test
	public void shouldFindCompany() {

		// GIVEN
		// WHEN
		final ResponseEntity<Company> responseEntity = restTemplate.getForEntity("/company/", Company.class);
		// THEN
		Assertions.assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
		final Company company = responseEntity.getBody();
		Assertions.assertThat(company.getName().contains(COMPANY_NAME_BEGIN));
		logger.info("shouldFindCompany():");
	}
}
