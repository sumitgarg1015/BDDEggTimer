package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CountDownTimerPage;
import pages.EggTimerHomePage;
import utils.SeleniumDriverUtil;

public class CountDownTimerSteps{
	
	EggTimerHomePage eggTimerHomePage = new EggTimerHomePage();
	CountDownTimerPage countDowntimerPage = new CountDownTimerPage();
	
	@Given("Application is launched")
	public void application_is_launched() {
		SeleniumDriverUtil.launchApplication();
	}

	@When("User specify the time period")
	public void user_specify_the_time_period() {
		eggTimerHomePage.enterTimer();
	}

	@When("User Clicks on the Start button")
	public void user_clicks_on_the_start_button() {
		eggTimerHomePage.startTimer();
	}

	@Then("Verify the timer Count down for every second")
	public void verify_the_timer_count_down_for_every_second() {
		countDowntimerPage.verifyCountDownTimer();
			
	}

}
