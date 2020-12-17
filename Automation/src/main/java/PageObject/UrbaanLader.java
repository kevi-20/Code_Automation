package PageObject;

import java.util.List;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Resources.BaseUI;
import Resources.FileIO;

public class UrbaanLader {
	public WebDriver driver;
	static Properties prop;
	static FileIO fileio;
	static By Search;
	static By ProductTitle;
	static By Enter;
	static By Price;
	static By Stock;
	static By Storage;
	static By ShelvesTitle;
	static By ShelvesPrice;
	static By Collection;
	By shelvesTitle = By.className("product-title-sofa-mattresses");
	By shelvesPrice = By.className("price-number");

	public UrbaanLader(WebDriver driver) {
		this.driver = driver;
		fileio = new FileIO();
		prop = fileio.inputSetup();
	}

	/*****************************************
	 * Initialising the browser
	 ******************************/

	public void createDriver(int option) {
		driver = BaseUI.getDriver(option);

	}

	public void popuping() {

		driver.findElement(By.linkText("Close")).click();

	}

	// Searching the BookShelf
	public void search() throws InterruptedException {
		Search = By.id(prop.getProperty("search"));
		driver.findElement(Search).sendKeys("bookshelf");
		Thread.sleep(1000);
		Enter = By.xpath(prop.getProperty("enter"));
		driver.findElement(Enter).click();

	}

	public void selectPrice() {
		Price = By.xpath(prop.getProperty("price"));
		driver.findElement(Price).click();
		WebElement upper = driver.findElement(By.xpath(
				"//*[@id='filters-form']/div[1]/div/div/ul/li[2]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));
		int uwidth = upper.getSize().width;
		Actions s = new Actions(driver);
		s.dragAndDropBy(upper, (int) (-uwidth * (12.9)), 0);
		s.build().perform();

	}

	public void storage() throws InterruptedException {
		Storage = By.xpath(prop.getProperty("storage"));
		driver.findElement(Storage).click();
		Thread.sleep(1000);
		WebElement check = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/form/div[1]/div/div/ul/li[3]/div[2]/div/div/div/ul/li[1]/input"));
		check.click();

	}

	public void stock() {
		try {

			Thread.sleep(1000);

		} catch (Exception e) {

			e.printStackTrace();

		}
		Stock = By.xpath(prop.getProperty("stock"));
		driver.findElement(Stock).click();

		// log.info("Selecting Stock type");
	}

	public void print() {
		try {

			Thread.sleep(1000);

		} catch (Exception e) {

			e.printStackTrace();

		}
		List<WebElement> shtitles = driver.findElements(shelvesTitle);
		List<WebElement> shprices = driver.findElements(shelvesPrice);

		String[] name = new String[6];
		String[] price = new String[6];

		for (int i = 0; i < 6; i++) {
			name[i] = shtitles.get(i).getText();
			price[i] = shprices.get(i).getText();
			// System.out.print(shtitles.get(i).getText() + " ");
			// System.out.println(shprices.get(i).getText());
			FileIO.output1(name, price);
		}

	}

	public void close() {
		driver.quit();
	}

}
