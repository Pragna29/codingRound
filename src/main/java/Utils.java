import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.javafx.PlatformUtil;

public class Utils {

	static WebDriver driver;
	public PropertyFileReader propFile;
	
	public void setDriverPath() throws FileNotFoundException, IOException {
		propFile= new PropertyFileReader();
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
        
        
        driver= new ChromeDriver();
        String url= propFile.ReadURL();
        driver.get(url);
        driver.manage().window().maximize();
    	driver.navigate().refresh();
	}
	
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    protected boolean isElementPresent(WebElement searchSummary) {
        try {
        	searchSummary.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTitle() {
    	String pageTitle= driver.getTitle();
    	return pageTitle;
    }
	
    public void switchFrame(String frameId) {
		driver.switchTo().frame(frameId);
	}
    
}
