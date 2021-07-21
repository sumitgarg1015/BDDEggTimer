package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import locators.TimeCounterPageLocators;
import static locators.TimeCounterPageLocators.*;
import utils.SeleniumDriverUtil;

public class CountDownTimerPage {

	private static String timer;
	private static int maxCount;

	public CountDownTimerPage() {
		PageFactory.initElements(SeleniumDriverUtil.getDriver(), TimeCounterPageLocators.class);
	}

	public static int getCounter() {
		timer = countDown.getText().split(" ")[0];
		return Integer.parseInt(timer);
	}

	public void verifyCountDownTimer() {

		try {
			maxCount = SeleniumDriverUtil.getTimer();

			// Make Thread wait for specified amount of time even though it is discouraged.
			// But TimerTask is thread safe hence could not be implemented. 
			// Secondly Thread.wait is being used for verifying the functionality
			// not to make the code work
			// Please refer the commented code for TimerTask in method startTimer()

			Thread.sleep(maxCount * 1000);

			if (getCounter() == 0) {
				System.out.println("Timer is working correctly");
			} else {
			// If timing based on existing seconds are spent and timing pulled from the Web are not
			// the same, system will fail the test
				ExtentCucumberAdapter.getCurrentStep().fail("Message: Timer is not working correctly");
			}
			SeleniumDriverUtil.wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {

		} finally {
			manageAlert();
		}

	}

	/*
	 * public static void startTimer(int count) { Timer timer = new Timer();
	 * 
	 * timer.scheduleAtFixedRate(new TimerTask() { int i = 0;
	 * 
	 * public void run() { i++; System.out.println(i); if (i == count) {
	 * timer.cancel(); } } }, 0, 1000); }
	 */

	public static void manageAlert() {

		if (isAlertPresent()) {
			Alert alt = SeleniumDriverUtil.getDriver().switchTo().alert();
//			System.out.println(alt.getText());
			alt.accept();
			SeleniumDriverUtil.getDriver().switchTo().defaultContent();
		}

	}

	// Checking if Alert is present
	public static boolean isAlertPresent() {

		try {
			SeleniumDriverUtil.getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

}
