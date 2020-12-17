package Code.Automation;

import java.io.IOException;


import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject.UrbaanLader;
import Resources.BaseUI;

public class TestCases {
	public WebDriver driver;

	UrbaanLader i = new UrbaanLader(driver);
	

	@BeforeTest
	public void InvokeBrowser() {

		//ExtentTest logger = report.createTest("Invoke Browser");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for Chrome \nEnter 2 for Firefox");
		int ch = sc.nextInt();
		sc.close();
		//logger.log(Status.INFO, "Initailising the browser");
		//log.info("Opening the browser");
		i.createDriver(ch);

	}
	@Test(priority = 1)
	public void Invalid() throws IOException {
		//ExtentTest logger = report.createTest("Checking if the website is accepting invalid characters");
		//logger.log(Status.INFO, "Checking if the website is accepting invalid characters");
		//log.info("Checking if the website is accepting invalid characters");
		i.popuping();
	
		
	}
	
	@Test(priority = 2)
	public void enter() throws IOException, InterruptedException {
		i.search();
	}
	
	@Test(priority = 3)
	public void price() throws IOException {
		i.selectPrice();
	}
	
	@Test(priority = 4)
	public void storage() throws IOException, InterruptedException {
		i.storage();
	}
	
	@Test(priority = 5)
	public void stock() throws IOException {
		i.stock();
	}
	
	@Test(priority = 6)
	public void output() throws IOException {
		i.print();
	}

	@Test(priority = 7)
	public void close() throws IOException {
		i.close();
	}
}
