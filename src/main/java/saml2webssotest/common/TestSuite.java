package saml2webssotest.common;

import org.w3c.dom.Document;

import saml2webssotest.common.TestStatus;

/**
 * This is the module containing the base interfaces for every test suite. This is extended by the IdP and SP test suites which in 
 * turn can be extended to create custom test suites to test either an IdP or an SP.
 * 
 * @author: Riaas Mokiem
 */
public interface TestSuite {
	/**
	 * Get the metadata that should be used in the mocked SAML entity for this test suite.
	 * 
	 * This allows you to use specific IdP or SP metadata for the mocked SAML entity in each test suite, which
	 * is defined in this method. 
	 * 
	 * @return: the metadata XML that should be used by the mocked SAML entity when running tests from this test suite
	 */
	public abstract String getMockedMetadata();

	/**
	 * The interface for all test cases. Defines the methods that are required for the test runner to correctly run
	 * the test case.
	 * 
	 * You can extend this TestCase to create specific types of test cases, as is done to create the MetadataTestCase. You 
	 * can then implement these specific types of test cases in order to specify a test case.
	 * 
	 * @author RiaasM
	 *
	 */
	public interface TestCase{

		/**
		 * Retrieve a description of the test case
		 * 
		 * @return a description of this test case
		 */
		String getDescription();
		
		/**
		 * Retrieve the message that should be reported when the test passes.
		 * 
		 * @return the message for when the test passes
		 */
		String getSuccessMessage();
		
		/**
		 * Retrieve the message that should be reported when the test fails.
		 * 
		 * @return the message for when the test fails
		 */
		String getFailedMessage();
	}
	
	/**
	 * The interface for a test case that is intended to test the XML metadata
	 * of a SAML entity. 
	 * 
	 * @author RiaasM
	 *
	 */
	public interface MetadataTestCase extends TestCase {
		
		/**
		 * Check the provided metadata.  
		 * 
		 * @return the status of the test
		 */
		TestStatus checkMetadata(Document metadata);
	}
}