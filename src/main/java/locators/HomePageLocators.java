package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageLocators {
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'time-input')]")
	public static WebElement timerInput;
	
	@FindBy(how=How.CSS, using="button.validTime")
	public static WebElement timeSubmit;
	

}
