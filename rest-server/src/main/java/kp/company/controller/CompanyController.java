package kp.company.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kp.company.domain.Company;
import kp.company.service.CompanyService;

/**
 * The RESTful web service controller for the company.
 *
 */
@RestController
public class CompanyController {

	private static final Log logger = LogFactory.getLog(CompanyController.class);

	private final CompanyService companyService;

	/**
	 * Constructor.
	 * 
	 * @param companyService the company service
	 */
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

	/**
	 * Reads the company.<br>
	 * Enabling CORS (Cross-Origin Resource Sharing) is needed for JavaScript
	 * clients.
	 * 
	 * @return the company
	 */
	@CrossOrigin
	@GetMapping("/company")
	public Company getCompany() {

		final Company company = companyService.generateNextCompany();
		logger.info(String.format("getCompany(): company name[%s]", company.getName()));
		return company;
	}
}