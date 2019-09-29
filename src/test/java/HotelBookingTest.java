import com.sun.javafx.PlatformUtil;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HotelBookingTest extends Utils{

   

    @FindBy(xpath="//*[@title='Find hotels in destinations around the world']")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @BeforeTest
	 public void SetDriver() throws FileNotFoundException, IOException {
		setDriverPath();
	}

    
    
    @Test
    public void shouldBeAbleToSearchForHotels() throws AWTException, InterruptedException {
        try {
        HotelPage hotelPage=PageFactory.initElements(driver, HotelPage.class);
        
        WebDriverWait wait= new WebDriverWait(driver, 10);
        //Getting title of the parent page
        String parentTitle=getTitle();
        hotelPage.findHotels.click();
        hotelPage.whereTextBox.sendKeys("Indiranagar, Bangalore");
        //waiting until the auto complete list appears 
        wait.until(ExpectedConditions.visibilityOf(hotelPage.areaDrpdwn)).click();
        hotelPage.checkInDate.click();
        //selecting the autoselected dates fo checkin and checkout
	       Robot rob= new Robot();
	       rob.keyPress(KeyEvent.VK_ENTER);
	       rob.keyRelease(KeyEvent.VK_ENTER);
	       
	     hotelPage.checkOutDate.click();  
         rob.keyPress(KeyEvent.VK_ENTER);
         rob.keyRelease(KeyEvent.VK_ENTER);
        
        new Select(hotelPage.travellerDrpdwn).selectByIndex(1);;
        hotelPage.searchHotelBtn.click();
        Thread.sleep(7000);
        //Verifying the page titles differ after search
          Assert.assertTrue(!parentTitle.equals(getTitle()));
        }
        catch(Exception e) {
        	Assert.fail("Failed Test: shouldBeAbleToSearchForHotels"+e.getMessage()
        	
        			);
        }
    }
    
    @AfterTest
    public void shut() {
    	
    driver.quit();
    }
   
}
