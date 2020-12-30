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
	public static Properties prop;

	public static WebDriver getDriver() throws IOException {
		FileIO fileio = new FileIO();
		URL = fileio.getURL();
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\Automation\\Resources\\Config.properties");
		prop.load(fis);
		URL = fileio.getURL();
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			String userdir = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", userdir + "\\Automation\\Drivers\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(chromeOptions);

		} else if (browserName.equals("firefox")) {

			String userdir = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", userdir + "\\Automation\\Drivers\\geckodriver.exe");
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
