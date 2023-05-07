package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.* ;


public class BaseClass 
{
        public static WebDriver driver ; 
        
        public  Logger logger ;
	
        public ResourceBundle rb ;
        
        @BeforeClass(groups= {"Master" , "Regression" , "Sanity"})
        
        @Parameters("Browser")
        
        void setup (String br)
	   
        { 
            rb = ResourceBundle.getBundle("config") ;
        	
        	logger = LogManager.getLogger(this.getClass()) ;
        	
        	//WebDriverManager.chromedriver().setup();
        
        	if(br.equals("Chrome"))
        	{	
        	  driver = new ChromeDriver () ;
        	}
        	
        	else if(br.equals("edge"))
        	{	
        	    driver = new EdgeDriver() ;
        		
        	}	
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        	
        	driver.get(rb.getString("appUrl"));
        	
        	// driver.get("https://demo.opencart.com/index.php?route=common/home&language=en-gb");
        	
        	driver.manage().window().maximize();
        	
        }
	
     public String randomString()   
        
     {
    	 String generatedString = RandomStringUtils.randomAlphabetic(5) ;
    	 
    	 return generatedString ;
    	 
     } 
        
	public String randomNumber ()
     
	{
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		
		return generatedString2 ;
	}
	
   public String CaptureScreen (String tname) throws IOException
	
   {
	   String timestamp = new SimpleDateFormat("yyMMddhhmmss").format(new Date()) ;
	   
	   TakesScreenshot takeScreenShot = (TakesScreenshot) driver ;
	   
	   File source = takeScreenShot.getScreenshotAs(OutputType.FILE) ;
	   
	   String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "-" + timestamp + ".png" ;
	  
	   try
	   {
	   FileUtils.copyFile(source,new File (destination));
	   }
	   
	   catch (Exception e)
	   
	   {
		   e.getMessage() ;
	   }
	   
	   
	   return destination ;
	   
   }
		
	
}
