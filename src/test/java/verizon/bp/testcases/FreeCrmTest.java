package verizon.bp.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import verizon.bp.util.TestUtil;

public class FreeCrmTest {

	static WebDriver driver;
	static JavascriptExecutor js;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/naveenkhunteta/Downloads/chromedriver");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.get("https://www.freecrm.com/index.html");
	}

	@Test
	public void freeCrmTitleTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println("title is: " + title);
		TestUtil.getRunTimeInfoMessage("info", title);

		if (title.equals("Free CRM software in the cloud powers sales and customer serviceQQQQ")) {
			TestUtil.getRunTimeInfoMessage("info", "title is correct!! YAY!!!");
			Assert.assertTrue(true);
		} else {
			TestUtil.getRunTimeInfoMessage("error", "title is not correct!! BUG BUG BUG!!!");
			TestUtil.takeScreenshot("freecrmloginpage");
			Assert.assertTrue(false);
		}

	}

	

}
