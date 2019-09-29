import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Utils {

	@FindBy(linkText="Your trips") 
	WebElement yourTripsLink;
	
	@FindBy (id="SignIn")
	WebElement signInLink;
	
	@FindBy (id="signInButton")
	WebElement signInBtn;
	
	@FindBy (id="errors1")
	WebElement error;
	
	public String iframeId="modal_window";
	
	
}
