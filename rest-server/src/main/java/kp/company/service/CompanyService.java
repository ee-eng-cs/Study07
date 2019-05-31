package kp.company.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import kp.company.domain.Company;

/**
 * The company service.
 *
 */
@Service
public class CompanyService {

	private static final AtomicLong counter = new AtomicLong();

	/**
	 * Generates the next company in sequence.
	 * 
	 * @return the company
	 */
	public Company generateNextCompany() {

		final Company company = new Company(counter.incrementAndGet(),
				String.format("C-o-m-p-a-n-y-%02d", counter.get()));
		return company;
	}
}
