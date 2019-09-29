import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightPage extends Utils {

	@FindBy(id="OneWay") 
	WebElement oneWayRadioBtn;
	
	@FindBy (id="FromTag")
	WebElement fromPlace;
	
	@FindBy (id="ToTag")
	WebElement ToPlace;
	
	@FindBy (id="DepartDate")
	WebElement departDate;
	
	@FindBy (id="SearchBtn")
	WebElement searchBtn;
	
	@FindBy (className="searchSummary")
	WebElement searchSummary;
	
	
	
	public String fromPlaceLocator="(//*[@class='list' and @role='presentation'])[1]";
	public String toPlaceLocator="(//*[@class='list' and @role='presentation'])[2]";
}
