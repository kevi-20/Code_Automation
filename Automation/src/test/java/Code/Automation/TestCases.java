package Code.Automation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import Drivers.BaseUI;
import PageObject.UrbanLadder;

public class TestCases {
  public static WebDriver driver;

	@BeforeSuite
	public void setup() {

		driver = Base.getDriver();
		
	}
  @Test(priority = 0)
	public void popup() {
		 
		 UrbanLadder implement = new UrbanLadder(driver);
		 
		 implement.popuping();
		

	}
   @Test(priority = 1)
	public void search() {
		 UrbanLadder implement = new UrbanLadder(driver);
		 implement.search();
		 
		 
		 
	}

	@Test(priority = 2)
	public void selectPrice() {
		
		 UrbanLadder implement = new UrbanLadder(driver);
		 implement.selectPrice();
		 Test6.pass("Passed");

	}
	@Test(priority = 3)
	public void print0(){
		UrbanLadder implement = new UrbanLadder(driver);
		implement.print0();
	}
  @AfterSuite
	public void closeBrowser() 
	{
	    extent.flush();

		driver.quit();
	}

}
