package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import tech.grasshopper.pdf.section.scenario.ScenarioStepDetails;
import utils.SeleniumDriverUtil;

public class SetUpAndTearDown {

	@Before
	public void setUpBrowser() {

		SeleniumDriverUtil.setUpDriver();

	}

	@After
	public void tearDown(Scenario scenario) {

		WebDriver driver = SeleniumDriverUtil.getDriver();
		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes, "image/png", "screenshot");

		}
		SeleniumDriverUtil.tearDown();

	}
	
	
	@BeforeStep
	public void performBeforeStep(Scenario scenario) {
		
		//not implemented
		
	}
	
	@AfterStep
	public void performAfterStep(Scenario scenario) {
		
		//not implemented
	}

}
