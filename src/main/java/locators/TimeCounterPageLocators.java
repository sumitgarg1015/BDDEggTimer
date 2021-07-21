package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TimeCounterPageLocators {
	
	
	@FindBy(how=How.XPATH, using="//span")
	public static WebElement countDown;

}
