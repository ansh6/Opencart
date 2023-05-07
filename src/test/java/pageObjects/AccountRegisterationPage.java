package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends  BasePage
{
    public AccountRegisterationPage(WebDriver driver)
	
    {
    	
    	super (driver);
    	
    }
	
	
        //Element   
    
        @FindBy(name = "firstname")  
    
        WebElement txtfirstname ; 
    
   
        @FindBy(name = "lastname")  
  
        WebElement txtlastname ;
  
  
         @FindBy(name = "email")  
  
         WebElement txtEmail ;
  
         @FindBy(name = "password")  
  
         WebElement txtPassword ;	
  
  
         @FindBy (xpath = "//input[@name='agree']")
  
         WebElement Chkdpolicy ; 
         
         @FindBy(xpath = "//button[@type='submit']")
         
         WebElement Chkdcontinue ;
         
         
         @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") 
         
          WebElement Msgconfirmation ;
         
    //Actions 
         
       public void setFristName (String fname)  
         
       {
    	   txtfirstname.sendKeys(fname);
    	      
       } 
         
         
       public void setLastName (String lname)  
       
       {
    	   txtlastname.sendKeys(lname);
    	      
       }    
         
      public void setPassword (String pwd)  
       
       {
    	  txtPassword.sendKeys(pwd);
    	      
       }  
      
      public void setEmail (String eml)  
      
      {
    	  txtEmail.sendKeys(eml);
   	      
      }  
      
            
      public void setPrivacyPolice()
      
      {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  
    	  js.executeScript("arguments[0].click() ;", Chkdpolicy) ;
    	  
    	  
    	 // Chkdpolicy.click();
    	  
      }
      
     public void clickContiue () 
     
     {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 
    	 js.executeScript("arguments[0].click() ; ", Chkdcontinue) ;
    	 
    	 //Chkdcontinue.click();
    	 
    	 
     }
      
      
     public String getConfirmationMsg()
     
     { 
    	 try 
    	 {
    	 return Msgconfirmation.getText() ;
    	 }
    	 
    	 catch (Exception e)
    	 {
    		
    		 return e.getMessage();
    		 
    	 }
     }
     
}
