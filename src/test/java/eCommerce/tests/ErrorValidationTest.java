package eCommerce.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;



import eCommerce.TestComponenets.BaseTest;
import eCommerce.TestComponenets.Retry;

public class ErrorValidationTest extends BaseTest{
	
	
	@Test(groups= {"Error Handling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{

    landingpage.loginApplication("aliv.august20@gmail.com", "Passwor@20");
	landingpage.geterrorMessage();
	Assert.assertEquals("Incorrect email or password", landingpage.geterrorMessage());
}
}