package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class TC_002_LoginTest extends BaseClass
{
    @Test(groups= {"Sanity" , "Master"})
	
	public void test_login ()
	{
    	try
    	{
    	
    	logger.info("********** start TC_002_LoginTest *********");
    	
    	HomePage hp = new HomePage (driver) ;
		
		hp.clickMyAccount();
		
		logger.info("CLICKED ON MyACCOUNT LINK");
		
    	hp.clicklogin();
    	
    	logger.info("CLICKED ON login LINK");
    	
    	
    	LoginPage lp = new LoginPage (driver) ;
    	
    	lp.setEmail("shashi1@gmail.com");
    	
    	logger.info("clicl on email");
    	
    	 lp.setPassword("asdf");
    	
    	logger.info("click on password");
    	
    	
    	lp.click();
    	
    	logger.info("click on login button");
    	
    	
    	MyAccount macc = new MyAccount (driver) ;
    	
       boolean target =	macc.isMyAccountPageExist() ;
    	
    	Assert.assertEquals(target, true , "login failed");
    	
    	}
    	
    	catch(Exception e)
    	
    	{
    		Assert.fail();
    		
    	}
    	
    	logger.info("********* Finished TC_002_LoginTest ********* ");
    	
	}
	
}
