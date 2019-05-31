package kp.company;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import kp.company.client.side.CompanyClientSideTests;
import kp.company.mvc.CompanyMvcTests;

/**
 * The test suite for the REST.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CompanyClientSideTests.class, CompanyMvcTests.class })
public class TestSuite {
}