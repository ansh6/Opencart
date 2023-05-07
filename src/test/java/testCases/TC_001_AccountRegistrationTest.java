package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;

import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass
{

	@Test(groups = {"Regression" , "Master"})
	 void test_account_Registration ()
	
	{ 
		logger.info(" ******* starting TC_001_AccountRegistrationTest " );
		
		try
		
		{
		HomePage hp = new HomePage (driver) ;
			
		hp.clickMyAccount();
		
		logger.info("CLICKED ON ACCOUNT LINK");
		
		hp.clickRegister();
		
		logger.info("CLICKED ON REGISTER");
		
		AccountRegisterationPage repage = new AccountRegisterationPage (driver) ;
		
		logger.info("PROVIDING CUSTOMER DETAILS ");
		
		repage.setFristName("shhashkk");
		
		repage.setLastName("kaaniy");
		
		repage.setEmail(randomString() + "@gmail.com" );
		
		repage.setPassword("hh@346ytlyyb");
		
		repage.setPrivacyPolice();
		
		logger.info("CLICKED PRIVACY POLICE");
		
		repage.clickContiue(); 
		
		logger.info("CLICKED CONTUNE ");
		
	    String confmsg =	repage.getConfirmationMsg();
	
	    logger.info("VALIDATE EXPECTED MSG ");
	    
	 Assert.assertEquals(confmsg , "Your Account Has Been Created!" , " TEST failed");
		
		}
		
	catch (Exception e)	
		
		{
		   logger.info("test failed");
		   Assert.fail();
		}
		
		
	}
		
}
