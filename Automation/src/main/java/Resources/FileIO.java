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
		static FileOutputStream fos = null;
		 static XSSFWorkbook workbook = null;
		 static XSSFSheet sheet = null;
		static XSSFRow row = null;
		Properties prop = null;

		// Setting properties file for input
		public Properties inputSetup() {

			File file = new File(System.getProperty("user.dir") + "\\Resources\\config.properties");
			System.out.println(file.getAbsolutePath());

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
		
		public static  void output1(String[]name ,String[] price,int size) {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("output1");
			for (int i = 0; i <size; i++) {
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(name[i]);
				row.createCell(1).setCellValue(price[i]);
			}
		
			sheet.autoSizeColumn(0);
			//Writing the output to Excel file using FileOutputStream
			try {
				fos = new FileOutputStream("output1.xlsx");
				workbook.write(fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
