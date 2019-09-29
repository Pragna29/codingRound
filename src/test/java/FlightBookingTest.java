import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightBookingTest extends Utils{
	
	 
	//Creating driver instance
	@BeforeTest
	 public void SetDriver() throws FileNotFoundException, IOException {
		setDriverPath();
	}
	
	@Test
    public void testThatResultsAppearForAOneWayJourney() throws AWTException {
		try {
		
		FlightPage FlightPage=PageFactory.initElements(driver, FlightPage.class);
		
	    //Creating WebDriver for explicit wait   
		WebDriverWait wait= new WebDriverWait(driver, 10);
	    
		//Entering the details for flight 
	   	FlightPage.oneWayRadioBtn.click();
        FlightPage.fromPlace.clear();
        FlightPage.fromPlace.sendKeys("Bangalore");

        //wait for the auto complete options to appear for the origin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FlightPage.fromPlaceLocator)));
        
        //select the first item from the origin auto complete list
        List<WebElement> originOptions = driver.findElements(By.xpath(FlightPage.fromPlaceLocator));
        
        for(int i=0; i<originOptions.size();i++) {
        if(originOptions.get(i).getText().contains("Bangalore"))
        {
        originOptions.get(i).click();
        break;
        }
        else {
        	System.out.println("No such source airport");
        }
        }
        
        FlightPage.ToPlace.clear();
        FlightPage.ToPlace.sendKeys("Delhi");

        //wait for the auto complete options to appear for the destination

        
        //select the first item from the destination auto complete list
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FlightPage.toPlaceLocator)));
        
        List<WebElement> destinationOptions = driver.findElements(By.xpath(FlightPage.toPlaceLocator));
        
        for(int i=0; i<destinationOptions.size();i++) {
        if(destinationOptions.get(i).getText().contains("Delhi"))
        {
        	destinationOptions.get(i).click();
        break;
        }
        else {
        	System.out.println("No such destination airport");
        }
        }
        FlightPage.departDate.click();
        
        //Selecting the autoselected dates
        Robot rob= new Robot();
        rob.keyPress(KeyEvent.VK_ENTER);
        rob.keyRelease(KeyEvent.VK_ENTER);
        
        //all fields filled in. Now click on search
        FlightPage.searchBtn.click();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(FlightPage.searchSummary));
		}
		catch(Exception e) {
        	Assert.fail("Failed Test: testThatResultsAppearForAOneWayJourney"+e.getMessage());
        }
    }
	@AfterTest
    public void shut() {
	
    driver.quit();
    }

	
}
