package pages;

import org.openqa.selenium.support.PageFactory;
import static locators.HomePageLocators.*;
import locators.HomePageLocators;
import utils.SeleniumDriverUtil;

import static utils.SeleniumDriverUtil.*;

public class EggTimerHomePage {
	
	public EggTimerHomePage() {
		
		PageFactory.initElements(SeleniumDriverUtil.getDriver(), HomePageLocators.class);
		
	}
	
	public void enterTimer() {
		timerInput.sendKeys(config.getProperty("timer"));
	}
	
	public void startTimer() {
		timeSubmit.click();
	}
}
