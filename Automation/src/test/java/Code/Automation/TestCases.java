package Code.Automation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import Resources.BaseUI;
import PageObject.UrbaanLader;

public class TestCases {
  public static WebDriver driver;

	@BeforeSuite
	public void setup() {

		driver = BaseUI.getDriver();
		
	}
  @Test(priority = 0)
	public void popup() {
		 
		 UrbaanLader implement = new UrbaanLader(driver);
		 
		 implement.popuping();
		

	}
   @Test(priority = 1)
	public void search() {
		 UrbaanLader implement = new UrbaanLader(driver);
		 implement.search();
		 
		 
		 
	}

	@Test(priority = 2)
	public void selectPrice() {
		
		 UrbaanLader implement = new UrbaanLader(driver);
		 implement.selectPrice();
		 

	}
	@Test(priority = 3)
	public void print0(){
		UrbaanLader implement = new UrbaanLader(driver);
		implement.print0();
	}
  @AfterSuite
	public void closeBrowser() 
	{
	  

		driver.quit();
	}

}
