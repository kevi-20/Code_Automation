
package Code.Automation;

import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.UrbaanLader;

public class TestCases extends UrbaanLader {
	@BeforeClass
	public void initailize() {
		Scanner sc = new Scanner(System.in);
		// for selecting the browser
		System.out.println(" Enter 1 for Chrome \n Enter 2 for Firefox ");
		System.out.println(" ENTER YOUR CHOICE");
		int ch = sc.nextInt(); // input
		sc.close();
		driver = createDriver(ch);

	}

	@Test(priority = 0)
	public void popup() {

		Popuping();

	}

	@Test(priority = 1)
	public void search() throws InterruptedException {

		Search();

	}

	@Test(priority = 2)
	public void selectPrice() {

		SelectPrice();

	}

	@Test(priority = 3)
	public void storage() throws InterruptedException {

		Storage();
	}

	@Test(priority = 4)
	public void stock() throws InterruptedException {

		Stock();
	}

	@Test(priority = 5)
	public void print() throws IOException, InterruptedException {

		Print();

	}

	@AfterClass
	public void closeBrowser() {

		driver.quit();
	}

}
