package kp.company.client;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * The client application test.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTest {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Loads context.
	 * 
	 */
	@Test
	public void contextLoads() {
		Assertions.assertThat(restTemplate).isNotNull();
	}
}