package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{

	@Test(groups= {"regression","master"})
	public void test_account_registration() throws IOException
	{
		logger.info("Starting TC_001_AccountRegistration");
		try
		{
		logger.info("Launching application");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		logger.info("Clicking on MyInfo-->Registration link");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		logger.info("Providing customer details");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("John");
		logger.info("Provided customer first name");
		
		regpage.setLastName("Canedy");
		logger.info("Provided customer last name");
		
		regpage.setEmail(randomestring()+"@gmail.com");
		logger.info("Provided email");
		
		regpage.setTelephone("123456789");
		logger.info("Provided tel number");
		
		regpage.setPassword("abcxyz");
		regpage.setConfirmPassword("abcxyz");
		logger.info("Provided password & confirmed password");
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Click on continue button");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Provided password & confirmed password");
		
		logger.info("Validation started....");
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Registration test passed....");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"test_account_registration");
			logger.error("Registration test failed....");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
		
			logger.fatal("Registration test failed....");
			Assert.fail();
		}
	}
	
}
