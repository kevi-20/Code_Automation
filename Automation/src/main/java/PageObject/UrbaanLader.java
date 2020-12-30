package PageObject;

import java.io.IOException;
import java.util.List;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	static By Close;
	static By Open;
	static By Price1;
	static By Search1;
	static By ChairSearch;
	static By Filter;
	static By ChairSearch1;
	static By Category;
	static By TableName;
	static By TablePrice;

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

	public void print0(){
		 try {

				Thread.sleep(1000);

				} catch (Exception e) {

		

				e.printStackTrace();

				}
		List<WebElement> shtitles = driver.findElements(By.className(prop.getProperty("shelvesTitle")));
		List<WebElement> shprices = driver.findElements(By.className(prop.getProperty("shelvesPrice")));
		int size=shtitles.size();
		String[] name = new String[size];
		String[] price = new String[size];
		for (int i = 0; i <size; i++) {
			name[i] = shtitles.get(i).getText();
			price[i] = shprices.get(i).getText();
			//System.out.print(shtitles.get(i).getText() + "  ");
			//System.out.println(shprices.get(i).getText());
		FileIO.output0(name,price,size);	
  }
		
 
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

	public void print(){
		ShelvesTitle = By.className(prop.getProperty("shelvesTitle"));
		ShelvesPrice = By.className(prop.getProperty("shelvesPrice"));
		 try {

				Thread.sleep(1000);

				} catch (Exception e) {

		

				e.printStackTrace();

				}
		List<WebElement> shtitles = driver.findElements(ShelvesTitle);
		List<WebElement> shprices = driver.findElements(ShelvesPrice);
		int size=shtitles.size();
		String[] name = new String[size];
		String[] price = new String[size];
		for (int i = 0; i <size; i++) {
			name[i] = shtitles.get(i).getText();
			price[i] = shprices.get(i).getText();
			//System.out.print(shtitles.get(i).getText() + "  ");
			//System.out.println(shprices.get(i).getText());
		FileIO.output1(name,price,size);	
	}
	

	}
	public void Chair() throws InterruptedException {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		ChairSearch = By.id(prop.getProperty("chairsearch"));
		driver.findElement(ChairSearch).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(1000);
		driver.findElement(ChairSearch).sendKeys(("Study Chair") + Keys.ENTER);
		//log.info("Searching for study chair");

	}

	// Getting the results from the site and printing in Excel file and Console
	public void StudyChairDetails() throws IOException {
		TableName = By.xpath(prop.getProperty("TableName"));
		TablePrice = By.xpath(prop.getProperty("TablePrice"));
		List<WebElement> Names = driver.findElements(TableName);
		List<WebElement> Price = driver.findElements(TablePrice);
		//System.out.println("  ");
		//System.out.println("The Study Chair Details are:");
		String[] names = new String[4];
		String[] price = new String[4];
		for (int i = 0; i < 4; i++) {
			names[i] = Names.get(i).getText();
			price[i] = Price.get(i).getText();
			//System.out.print(Names.get(i).getText() + "  ");
			//System.out.println(Price.get(i).getText());
			FileIO.chairDetails(names, price);
			//log.info("Printing The StudyChair Details");
		}
	}

	// Closing the Browser
	public void close() {
		driver.quit();
	}

}
