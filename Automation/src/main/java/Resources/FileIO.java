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
	static FileInputStream fis = null;
	static FileOutputStream fos = null;
	Properties prop = null;
	static XSSFWorkbook workbook = null;
	static XSSFSheet sheet = null;
	static XSSFRow row = null;
	

		// Setting properties file for input
		public Properties inputSetup() {

			File file = new File("C:\\Users\\Ks4u\\git\\Code_Automation1\\Automation\\Resources\\Config.properties");
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

		//to return the ChromeDriver location from properties file
		public String getChromeDriverLocation() {
			inputSetup();
			String location = prop.getProperty("chrome");
			return location;
		}

		//to return the GeckoDriver location from properties file
		public String getGeckoDriverLocation() {
			inputSetup();
			String location = prop.getProperty("firefox");
			return location;
		}
	public static  void output0(String[]name ,String[]price,int size) {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("output0.xlsx");
			for (int i = 0; i < size; i++) {
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(name[i]);
				row.createCell(1).setCellValue(price[i]);
			}
		
			sheet.autoSizeColumn(0);
			//Writing the output to Excel file using FileOutputStream
			try {
				fos = new FileOutputStream("output0.xlsx");
				workbook.write(fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public static  void output1(String[]name ,String[]price,int size) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output1.xlsx");
		for (int i = 0; i < size; i++) {
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
	public static  void output2(String[]name ,String[]price,int size) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output2.xlsx");
		for (int i = 0; i < size; i++) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(name[i]);
			row.createCell(1).setCellValue(price[i]);
		}
	
		sheet.autoSizeColumn(0);
		//Writing the output to Excel file using FileOutputStream
		try {
			fos = new FileOutputStream("output2.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
