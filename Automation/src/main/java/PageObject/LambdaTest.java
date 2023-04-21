package PageObject;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Resources.BaseUI;
import Resources.FileIO;


public class LambdaTest {
	public WebDriver driver;
	static Properties prop;
	static FileIO fileio;

	public LambdaTest() {
		fileio = new FileIO();
		prop = fileio.inputSetup();
	}

	public WebDriver createDriver(int option) {

		return driver = BaseUI.getDriver(option);
	}

	public LambdaTest(WebDriver driver) {

		this.driver = driver;
	}
}
