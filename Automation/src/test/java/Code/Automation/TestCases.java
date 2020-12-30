package Code.Automation;

import java.io.IOException;


import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import PageObject.UrbaanLader;
import Resources.BaseUI;
import Resources.ExtentReportManager;

public class TestCases {
	public WebDriver driver;
	ExtentReports report = ExtentReportManager.getReportInstance();
	ExtentTest logger;
	UrbaanLader i = new UrbaanLader(driver);
	

	@BeforeTest
	public void InvokeBrowser() {

		ExtentTest logger = report.createTest("Invoke Browser");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for Chrome \nEnter 2 for Firefox");
		int ch = sc.nextInt();
		sc.close();
		logger.log(Status.INFO, "Initailising the browser");
		//log.info("Opening the browser");
		i.createDriver(ch);

	}
	@Test(priority = 1)
	public void Invalid() throws IOException {
		ExtentTest logger = report.createTest("Closing the pop-up");
		logger.log(Status.INFO, "Checking if the website is closing the pop-up");
		//log.info("Checking if the website is accepting invalid characters");
		i.popuping();
	
		
	}
	
	@Test(priority = 2)
	public void enter() throws IOException, InterruptedException {
		ExtentTest logger = report.createTest("Searching for bookshelves");
		logger.log(Status.INFO, "Searching for bookshelves");
		i.search();
	}
	
	@Test(priority = 3)
	public void price() throws IOException {
		ExtentTest logger = report.createTest("Selecting the price");
		logger.log(Status.INFO, "Selecting the price");
		i.selectPrice();
	}
	
	@Test(priority = 4)
	public void storage() throws IOException, InterruptedException {
		ExtentTest logger = report.createTest("Selecting the storage type to be open");
		logger.log(Status.INFO, "Selecting the storage type to be open");
		i.storage();
	}
	@Test(priority = 5)
	public void print() throws IOException, InterruptedException {
		ExtentTest logger = report.createTest("printing the name and price of the bookshelves");
		logger.log(Status.INFO, "printing the name and price of the bookshelves");
		i.print0();

	}

	@Test(priority = 6)
	public void stock() throws IOException {
		ExtentTest logger = report.createTest("Excluding the out of stock");
		logger.log(Status.INFO, "Excluding the out of stock");
		i.stock();
	}
	
	@Test(priority =7)
	public void output() throws IOException {
		ExtentTest logger = report.createTest("printing the name and price of the bookshelves that are in stock");
		logger.log(Status.INFO, "printing the name and price of the bookshelves that are in stock");
		i.print();
	}

	@Test(priority = 8)
	public void chair() throws InterruptedException {
		ExtentTest logger = report.createTest("Searching for studychair");
		logger.log(Status.INFO, "Searching for studychair");
		i.Chair();
	}

	@Test(priority = 9)
	public void Studychairprint() throws IOException {
		ExtentTest logger = report.createTest("printing the name and price of first three study-chair");
		logger.log(Status.INFO, "printing the name and price of first three study-chair");
		i.StudyChairDetails();
	}

	@Test(priority = 10)
	public void close() throws IOException, InterruptedException {
		ExtentTest logger = report.createTest("closing the browser");
		logger.log(Status.INFO, "Searching for browser");
		i.close();
	}
	@AfterTest
	public void endReport() {
		report.flush();
	}
	
}
