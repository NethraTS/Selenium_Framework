package utils.ProjectSpecific;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Generic.GetData;

public class CreateDriver {

	public static WebDriver getDriver() {
		WebDriver driver = null;
		String browserName = GetData.FromExcel("./Test_Data/Data.xlsx", "Browser_Config", 0, 0);
		//System.out.println(browserName);
		String url = GetData.FromExcel("./Test_Data/Data.xlsx", "Browser_Config", 0, 1);
		if (browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.firefox.marionette", "./Browser_Servers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("gc")) {
			System.setProperty("webdriver.chrome.driver", "./Browser_Servers/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid Browser !!");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}
}
