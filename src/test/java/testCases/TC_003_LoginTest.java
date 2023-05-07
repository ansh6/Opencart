package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import utilities.DataProviders;

public class TC_003_LoginTest extends BaseClass
{
    @Test(dataProvider = "LoginData" ,dataProviderClass = DataProviders.class)
    
	public void test_loginDDT (String email , String password ,String exp)
	
	{
		

    	logger.info("********** start TC_003_LoginTest *********");
    	
    	HomePage hp = new HomePage (driver) ;
		
		hp.clickMyAccount();
		
		logger.info("CLICKED ON MyACCOUNT LINK");
		
    	hp.clicklogin();
    	
    	logger.info("CLICKED ON login LINK");
    	
    	
    	LoginPage lp = new LoginPage (driver) ;
    	
    	lp.setEmail(email);
    	
    	logger.info("clicl on email");
    	
    	 lp.setPassword(password);
    	
    	logger.info("click on password");
    	
    	
    	lp.click();
    	
    	logger.info("click on login button");
		
		
    	MyAccount macc = new MyAccount (driver) ;
    	
        boolean target =	macc.isMyAccountPageExist() ;
		
		
		if(exp.equals("Valid"))
		{
			if(target==true)
			
			{
				macc.clickLogOut();
				Assert.assertTrue(true);
			}
			
			else
			
			{
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equals("Invalid"))
		{
			if(target==true)
			
			{
				macc.clickLogOut();
				Assert.assertTrue(false);
			}
			
			else
			
			{
				Assert.assertTrue(true);
			}
			
		}
		
		logger.info("********* Finished TC_002_LoginTest ********* ");
	}
		
	
}
