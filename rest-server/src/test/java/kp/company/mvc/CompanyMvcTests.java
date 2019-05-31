package kp.company.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import kp.company.domain.Company;
import kp.company.service.CompanyService;

/**
 * Application tests for company with server-side support.<br>
 * The server is <b>not started</b>.<br>
 * 
 * Loads a web application context and provides a mock web environment.<br>
 * The full Spring application context is started, but without the server.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyMvcTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;

	public static final String TEST_COMPANY_NAME = "C-o-m-p-a-n-y-01";

	/**
	 * Should return the repository index.<br>
	 * Tests a GET request.
	 * 
	 * @throws Exception the exception
	 */
	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		// GIVEN
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders/*-*/
				.get("/");
		// WHEN
		final ResultActions resultActions = mockMvc.perform(requestBuilder);
		// THEN
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/**
	 * Should retrieve the department.<br>
	 * Tests a GET request.
	 * 
	 * @throws Exception the exception
	 */
	@Test
	public void shouldRetrieveCompany() throws Exception {

		// GIVEN
		Mockito.when(companyService.generateNextCompany()).thenReturn(new Company(1, TEST_COMPANY_NAME));
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders/*-*/
				.get("/company");
		// WHEN
		final ResultActions resultActions = mockMvc.perform(requestBuilder);
		// THEN
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(TEST_COMPANY_NAME));
	}

}