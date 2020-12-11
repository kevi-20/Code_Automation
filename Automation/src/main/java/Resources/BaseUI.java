package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseUI {
	public static WebDriver driver;
	static String URL;
	static String location;

	public static WebDriver getDriver(int ch) {
		// TODO Auto-generated method stub

		FileIO fileio = new FileIO();
		URL = fileio.getURL();

		if (ch == 1) {

			String userdir = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", userdir + "\\Drivers\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");

			driver = new ChromeDriver(chromeOptions);
		} else if (ch == 2) {

			String userdir = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", userdir + "\\Drivers\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable-notifications");
			driver = new FirefoxDriver(firefoxOptions);
		}

		else {
			System.out.println("Not a valid option");
			System.exit(0);
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		return driver;
	}
}

