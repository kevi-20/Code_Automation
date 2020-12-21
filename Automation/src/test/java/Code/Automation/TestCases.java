package Code.Automation;


import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		UrbaanLader implementation = new UrbaanLader();
		System.out.println("Enter 1 for Chrome \nEnter 2 for FireFox"); //for selecting the browser
		int ch = sc.nextInt();  //input
		sc.close();
//		implementation.createDriver(ch);
		driver = BaseUI.getDriver(ch);
		
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
	@Test(priority = 4)
	public void storage() throws InterruptedException {
		
		 UrbaanLader implement = new UrbaanLader(driver);
		 implement.Storage();
		 

	}
	@Test(priority = 5)
	public void print1(){
		UrbaanLader implement = new UrbaanLader(driver);
		implement.print1();
	}
	@Test(priority = 6)
	public void Stock() throws InterruptedException {
		
		 UrbaanLader implement = new UrbaanLader(driver);
		 implement.Stock();
		 

	}
	
	@Test(priority = 7)
	public void print2(){
		UrbaanLader implement = new UrbaanLader(driver);
		implement.print2();
	}
  @AfterSuite
	public void closeBrowser() 
	{
	  

		driver.quit();
	}

}
