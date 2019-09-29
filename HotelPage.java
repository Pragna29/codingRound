import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelPage extends Utils {

	@FindBy(xpath="//*[@title='Find hotels in destinations around the world']") 
	WebElement findHotels;
	
	@FindBy (id="Tags")
	WebElement whereTextBox;
	
	@FindBy (id="ui-id-1")
	WebElement areaDrpdwn;
	
	@FindBy (id="CheckInDate")
	WebElement checkInDate;
	
	@FindBy (id= "CheckOutDate") 
	WebElement checkOutDate;
	
	@FindBy (id="travellersOnhome")
	WebElement travellerDrpdwn;
	
	@FindBy (id="SearchHotelsButton")
	WebElement searchHotelBtn;
	
	
}
