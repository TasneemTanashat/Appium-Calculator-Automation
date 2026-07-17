package myPackage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorAppClass {

	AndroidDriver driver;
	DesiredCapabilities caps = new DesiredCapabilities();

	@BeforeTest
	public void mySetup() {

		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:deviceName", "HUAWEI 2019");

		File myapplication = new File("MyApp/calculator18.apk");

		caps.setCapability("appium:app", myapplication.getAbsolutePath());
		caps.setCapability("appium:noReset", false);
		caps.setCapability("appium:newCommandTimeout", 120);

	}

	@BeforeMethod
	public void beforeEachTest() throws MalformedURLException {

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

	}

	@AfterMethod
	public void afterEachTest() throws InterruptedException, IOException {

		Thread.sleep(2000);
		
		Date mydate = new Date();

		String filename = mydate.toString().replace(":", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("screenshots/" + filename + ".jpg"));

		if (driver != null) { 
			driver.quit();
		}
	}

	@Test(priority = 1, enabled = true)
	public void myfirstTest() {

		WebElement digit9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
		digit9.click();

		WebElement MultiplyFunction = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
		MultiplyFunction.click();

		WebElement digit5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		digit5.click();

		WebElement EqualSign = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		EqualSign.click();

		String Results = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

//		int ExpectedFinalResultAsNumber = 9 * 5;
//		Assert.assertEquals(Results, Integer.toString(ExpectedFinalResultAsNumber));

		int ResultsAsNumber = Integer.parseInt(Results);
		int ExpectedFinalResultAsNum = 9 * 5;

		AssertJUnit.assertEquals(ResultsAsNumber, ExpectedFinalResultAsNum);

	}

	@Test(priority = 2, enabled = true)
	public void ClickOnAllDigits() throws IOException {

		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < AllButtons.size(); i++) {

			// this is to click on all buttons
			// AllButtons.get(i).click();

			// this is to click only on digits( numbers only )
			if (AllButtons.get(i).getDomAttribute("resource-id").contains("digit")) {
				AllButtons.get(i).click();

			}
		}
	}

	@Test(priority = 2, enabled = true)
	public void ClickOnAllOddButtonsNumbers() throws IOException {

		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < AllButtons.size(); i++) {

			if (AllButtons.get(i).getDomAttribute("resource-id").contains("9")
					|| AllButtons.get(i).getDomAttribute("resource-id").contains("7")
					|| AllButtons.get(i).getDomAttribute("resource-id").contains("5")
					|| AllButtons.get(i).getDomAttribute("resource-id").contains("3")
					|| AllButtons.get(i).getDomAttribute("resource-id").contains("1")) {

				AllButtons.get(i).click();

				
			}

		}
	}

	@Test(priority = 3, enabled = true)
	public void testAddition() {

		driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

		String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

		Assert.assertEquals(result, "12");
	}

	@Test(priority = 4, enabled = true)
	public void testSubtraction() {

		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

		String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

		Assert.assertEquals(result, "5");
	}

	@Test(priority = 5, enabled = true)
	public void testMultiplication() {

		driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

		String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

		Assert.assertEquals(result, "48");
	}

	@Test(priority = 6, enabled = true)
	public void testDivision() {

		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

		String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

		Assert.assertEquals(result, "0.4");
	}

	@Test(priority = 7, enabled = true )
	public void testClearButton() {

		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();

		driver.findElement(By.id("com.google.android.calculator:id/clr")).click();

	
	}

	@Test(priority = 8, enabled = true)
	public void testDeleteButton() {

		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();

		driver.findElement(By.id("com.google.android.calculator:id/del")).click();

		String result = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();

		Assert.assertEquals(result, "9");
	}

	@Test(priority = 9, enabled = true)
	public void testDivisionByZero() {

		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

		String result = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();

		Assert.assertTrue(result.contains("Can't divide by 0") || result.contains("Infinity"));
	}

	@Test(priority = 10, enabled = true)
	public void testDecimalCalculation() {

		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/dec_point")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();

		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();

		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		driver.findElement(By.id("com.google.android.calculator:id/dec_point")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();

		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

		String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

		Assert.assertEquals(result, "8");
	}

}

