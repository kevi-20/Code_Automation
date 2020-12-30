package Resources;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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
		public static Properties prop;
		
		public static WebDriver getDriver() throws IOException {

			FileIO fileio = new FileIO();
			prop= new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\Automation\\Resources\\Config.properties");

			 

			prop.load(fis);
			URL = fileio.getURL();
			String browserName=prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome"))
			{
			   location = fileio.getChromeDriverLocation();
				System.setProperty("webdriver.chrome.driver", location);
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");
	            driver = new ChromeDriver(chromeOptions);
			}
			else if (browserName.equalsIgnoreCase("firefox"))
			{
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

