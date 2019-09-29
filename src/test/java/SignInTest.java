import com.sun.javafx.PlatformUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest extends Utils{

   
    @BeforeTest
	 public void SetDriver() throws FileNotFoundException, IOException {
		setDriverPath();
	}
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
try {
		SignInPage signPage=PageFactory.initElements(driver, SignInPage.class);
		signPage.yourTripsLink.click();
		signPage.signInLink.click();
		//Switching to frame
		switchFrame(signPage.iframeId);
		signPage.signInBtn.click();
        //Verifying the frame has error which doesn't allow signin without filling the fields
        String errors1 = signPage.error.getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }
       catch(Exception e) {
    	   Assert.fail("Failed Test: shouldThrowAnErrorIfSignInDetailsAreMissing"+e.getMessage());
    	     
    }
    } 
    
    @AfterTest
    public void shut() {
    
    driver.quit();
    
    }

   

   


}
