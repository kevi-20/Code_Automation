package Resources;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
 

public class BaseUI {

		static String URL;
		static String location;
		static WebDriver driver;
		public static WebDriver getDriver(int ch) {

			FileIO fileio = new FileIO();
			URL = fileio.getURL();
			if (ch==1) {
				location = fileio.getChromeDriverLocation();
				System.setProperty("webdriver.chrome.driver", location);
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");
	            driver = new ChromeDriver(chromeOptions);
			} else if (ch==2) {
				location = fileio.getGeckoDriverLocation();
				System.setProperty("webdriver.gecko.driver", location);

				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--disable-notifications");
	            driver = new FirefoxDriver(firefoxOptions);
			} else {
				System.out.println("Not a valid driver");
				System.exit(0);
			}

			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
		}


	}

