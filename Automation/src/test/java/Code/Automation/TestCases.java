package Code.Automation;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import Resources.ExtentReportManager;
import PageObject.UrbaanLader;

public class TestCases extends UrbaanLader {
	ExtentReports report = ExtentReportManager.getReportInstance();
	ExtentTest logger;

	@BeforeClass
	public void initailize() throws IOException {
		ExtentTest logger = report.createTest("Invoke Browser");
		logger.log(Status.INFO, "Initailising the browser");
		driver = createDriver();
		logger.pass("Passed");
	}

	@Test(priority = 0)
	public void popup() {
		ExtentTest logger = report.createTest("Closing the pop-up");
		logger.log(Status.INFO, "Checking if the website is closing the pop-up");
		logger.info("This will close the popup window");
		Popuping();
		logger.pass("Passed");
	}

	@Test(priority = 1)
	public void search() throws InterruptedException {
		ExtentTest logger = report.createTest("Searching for bookshelves");
		logger.log(Status.INFO, "Searching for bookshelves");
		logger.info("This test will give the list of BookShelfs");
		Search();
		logger.pass("Passed");
	}

	@Test(priority = 2)
	public void selectPrice() {
		ExtentTest logger = report.createTest("Selecting the price");
		logger.log(Status.INFO, "Selecting the price");
		logger.info("This test will display the bookshelf with the selected price range");
		SelectPrice();
		logger.pass("Passed");
	}

	@Test(priority = 3)
	public void storage() throws InterruptedException {
		ExtentTest logger = report.createTest("Selecting the storage type to be open");
		logger.log(Status.INFO, "Selecting the storage type to be open");
		logger.info("This test will display the bookshelf with the storage type as open");
		Storage();
		logger.pass("Passed");
	}

	@Test(priority = 4)
	public void stock() throws InterruptedException {
		ExtentTest logger = report.createTest("Including the out of stock");
		logger.log(Status.INFO, "Including the out of stock");
		logger.info("This test will display the bookshelf  Inculed out of stock");
		Stock();
		logger.pass("Passed");
	}

	@Test(priority = 5)
	public void print() throws IOException, InterruptedException {
		ExtentTest logger = report.createTest("printing the name and price of the bookshelves");
		logger.log(Status.INFO, "printing the name and price of the bookshelves");
		logger.info("This test will Stores the name and price of bookshelf and prints in excel");
		Print();
		logger.pass("Passed");
		logger.log(Status.PASS,(Markup)logger.addScreenCaptureFromPath("user path"));
	}

	@Test(priority = 6)
	public void chair() throws InterruptedException {
		ExtentTest logger = report.createTest("Searching for studychair");
		logger.log(Status.INFO, "Searching for studychair");
		Chair();
		logger.pass("Passed");
	}

	@Test(priority = 7)
	public void Studychairprint() throws IOException {
		ExtentTest logger = report.createTest("printing the name and price of first three study-chair");
		logger.log(Status.INFO, "printing the name and price of first three study-chair");
		StudyChairDetails();
		logger.pass("Passed");
	}

	@Test(priority = 8)
	public void Account() throws IOException {
		ExtentTest logger = report.createTest("Checking the Login with Invalid input");
		logger.log(Status.INFO, "Checking the Invalid Login");
		CheckAccount();
		logger.pass("Passed");
		logger.log(Status.PASS,(Markup)logger.addScreenCaptureFromPath("user path"));
	}

	@Test(priority = 9)
	public void Sales() throws IOException {
		ExtentTest logger = report.createTest("Printing the title of Sale with product 30% OFF");
		logger.log(Status.INFO, "Printing the title of Sale with product 30% OFF");
		CheckingOff();
		logger.pass("Passed");
		logger.log(Status.PASS,(Markup)logger.addScreenCaptureFromPath("user path"));
	}

	@Test(priority = 10)
	public void Cart() throws IOException {
		ExtentTest logger = report.createTest("Printing the title of Chart  ");
		logger.log(Status.INFO, "Printing the title of Chart");
		CheckCart();
		logger.pass("Passed");
		logger.log(Status.PASS,(Markup)logger.addScreenCaptureFromPath("user path"));
	}

	@Test(priority = 11)
	public void closeBrowser() {
		ExtentTest logger = report.createTest("closing the browser");
		logger.log(Status.INFO, "Closing thebrowser");
		CloseBrowser();
		logger.pass("Passed");
	}

	@AfterClass
	public void endReport() {
		report.flush();
	}

}
