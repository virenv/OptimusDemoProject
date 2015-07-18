package ToolsQA;

import java.io.IOException;
import java.util.HashMap;

import main.java.ToolsQA.TestBase.BaseTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class DemoQaLogin extends BaseTest {

	protected DemoQaLogin() throws IOException {
		super();
	}
	
	@Test(dataProvider = "genericDataProvider")
	public void simpleTest(HashMap<String, String> testData)
	{
		driver.get("http://store.demoqa.com");
		reporter.log(LogStatus.INFO, "Navigate to the store demoqa page sucecssfully");
		String ScreenShotHtml = reporter.addScreenCapture(takeScreenShot());
		reporter.log(LogStatus.FATAL, ScreenShotHtml, "This screenshot is just for the sake of it");
//		String screenShotPath = reporter.addScreenCapture(takeScreenShot());
//		System.out.println("The schrrechot html is " + screenShotPath);
		//reporter.log(LogStatus.FATAL, screenShotPath,  "Attaching Screenshot");
		driver.findElement(By.xpath("//*[@id='account']/a")).click();
		reporter.log(LogStatus.INFO, "Entering username " + testData.get("Username"));
		driver.findElement(By.id("log")).sendKeys(testData.get("Username"));
		reporter.log(LogStatus.INFO, "Entering password " + testData.get("Password"));
		driver.findElement(By.id("password")).sendKeys(testData.get("Password"));
	}

}
