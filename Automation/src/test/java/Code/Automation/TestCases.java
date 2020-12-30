
package Code.Automation;

import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.UrbaanLader;
import Resources.BaseUI;

public class TestCases extends UrbaanLader {
	@BeforeClass
	public void initailize() throws IOException {
		driver = BaseUI.getDriver();

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
	@Test(priority = 6)
	public void chair() throws InterruptedException {
		Chair();
	}

	@Test(priority = 7)
	public void Studychairprint() throws IOException {
		StudyChairDetails();
	}

	@Test(priority = 8)
	public void Sales() throws IOException {
		CheckingOff();
	}

	@Test(priority = 9)
	public void Cart() throws IOException {
		CheckCart();
	}

	@Test(priority = 10)
	public void Account() throws IOException {
		CheckAccount();
	}

	@AfterClass
	public void closeBrowser() {

		driver.quit();
	}

}
