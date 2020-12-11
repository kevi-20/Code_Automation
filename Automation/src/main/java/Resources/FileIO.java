package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileIO {
	// variables declaration
		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
		Properties prop = null;

		// Setting properties file for input
		public Properties inputSetup() {

			File file = new File("resource\\config.properties");

			try {
				fis = new FileInputStream(file);
				prop = new Properties();
				prop.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
		}

		// to return the URL from properties file
		public String getURL() {
			inputSetup();
			String URL = prop.getProperty("url");
			return URL;
		}

		// to return the ChromeDriver location from properties file
		public String getChromeDriverLocation() {
			inputSetup();
			String location = prop.getProperty("chrome");
			return location;
		}

		// to return the GeckoDriver location from properties file
		public String getGeckoDriverLocation() {
			inputSetup();
			String location = prop.getProperty("firefox");
			return location;
		}
}
