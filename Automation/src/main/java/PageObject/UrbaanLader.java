package PageObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Resources.BaseUI;
import Resources.FileIO;

/************* @author 873477 MEGHA *****************/

public class UrbaanLader {
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
	static By Sale;
	static By ProductOff;
	static By Cart;
	static By CartTitle;
	static By CheckAcc;
	static By CheckUser;
	static By UserName;
	static By Password;
	public WebDriver driver;
	static Properties prop;
	static FileIO fileio;

	public static Logger log = LogManager.getLogger(UrbaanLader.class);

	public UrbaanLader() {
		fileio = new FileIO();
		prop = fileio.inputSetup();
	}

	public WebDriver createDriver(int option) throws IOException {
		 return driver = BaseUI.getDriver(option);
	}

	public UrbaanLader(WebDriver driver) {
		this.driver = driver;
	}

	/************* @author 873221 TEJA **************/
	// Closing the Pop
	public void Popuping() {
		Close = By.linkText(prop.getProperty("Close"));
		driver.findElement(Close).click();
		log.info("Closing the pop-up");
	}

	// Searching the BookShelf
	public void Search() throws InterruptedException {
		Search = By.id(prop.getProperty("Search"));
		driver.findElement(Search).sendKeys(prop.getProperty("Search1"));
		Thread.sleep(1000);
		Enter = By.xpath(prop.getProperty("enter"));
		driver.findElement(Enter).click();
		log.info("searching the bookshelf");
	}

	// Selecting the price
	public void SelectPrice() {
		Price = By.xpath(prop.getProperty("price"));
		driver.findElement(Price).click();
		Price1 = By.xpath(prop.getProperty("price1"));
		WebElement upper = driver.findElement(Price1);
		int uwidth = upper.getSize().width;
		Actions s = new Actions(driver);
		s.dragAndDropBy(upper, (int) (-uwidth * (12.9)), 0);
		s.build().perform();
		log.info("Selecting the price range");
	}

	/*********** @author 873477 MEGHA **************/
	// Selecting the Storage Type as open
	public void Storage() throws InterruptedException {
		Storage = By.xpath(prop.getProperty("storage"));
		driver.findElement(Storage).click();
		Thread.sleep(1000);
		Open = By.xpath(prop.getProperty("open"));
		WebElement check = driver.findElement(Open);
		check.click();
		log.info("Selecting the Storage Type");
	}

	/************* @author 873201 KAVITHA ****************/
	// Including Out of Stock
	public void Stock() throws InterruptedException {
		/** Including OutOfStock **/
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,+700)");
		log.info("Including Out Of Stock");

	}

	/**************** @author 873221 TEJA ******************/
	// Getting the results from the site and printing in Excel file and Console
	public void Print() throws IOException, InterruptedException {
		ShelvesTitle = By.className(prop.getProperty("shelvesTitle"));
		ShelvesPrice = By.className(prop.getProperty("shelvesPrice"));
		Thread.sleep(1000);
		// screen shot
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcfile = tss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("ScreenShots\\BookShelf.png"));
		List<WebElement> shtitles = driver.findElements(ShelvesTitle);
		List<WebElement> shprices = driver.findElements(ShelvesPrice);
		System.out.println("BookShelves Below 15000 :");
		int size = shtitles.size();
		String[] name = new String[size];
		String[] price = new String[size];
		for (int i = 0; i < size; i++) {
			name[i] = shtitles.get(i).getText();
			price[i] = shprices.get(i).getText();
			System.out.print(shtitles.get(i).getText() + "  ");
			System.out.println(shprices.get(i).getText());
			FileIO.output1(name, price, size);
			log.info("Printing The BookShelf Details");
		}

	}

	/**************** @author 873115 KRISHNA *******************/
	// Searching chair
	public void Chair() throws InterruptedException {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(100);
		ChairSearch = By.id(prop.getProperty("chairsearch"));
		driver.findElement(ChairSearch).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(1000);
		driver.findElement(ChairSearch).sendKeys(prop.getProperty("chairsearch1") + Keys.ENTER);
		log.info("Searching for study chair");

	}

	// Getting the results from the site and printing in Excel file and Console
	public void StudyChairDetails() throws IOException {
		TableName = By.xpath(prop.getProperty("TableName"));
		TablePrice = By.xpath(prop.getProperty("TablePrice"));
		List<WebElement> Names = driver.findElements(TableName);
		List<WebElement> Price = driver.findElements(TablePrice);
		System.out.println("  ");
		System.out.println("The Study Chair Details are:");
		String[] names = new String[4];
		String[] price = new String[4];
		for (int i = 0; i < 4; i++) {
			names[i] = Names.get(i).getText();
			price[i] = Price.get(i).getText();
			System.out.print(Names.get(i).getText() + "  ");
			System.out.println(Price.get(i).getText());
			FileIO.chairDetails(names, price);
			log.info("Printing The StudyChair Details");
		}
	}
	
	/**************** @author 873466 KEVIN *******************/
	//Checking the title of Sale with Product 30% OFF 
	public void CheckingOff() throws IOException {
		Sale=By.xpath(prop.getProperty("sale"));
		driver.findElement(Sale).click();
		ProductOff=By.xpath(prop.getProperty("productOff"));
		driver.findElement(ProductOff).click();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle =driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println(" ");
		System.out.println(ActualTitle);
		//Screen Shot
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcfile = tss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("ScreenShots\\Screen.png"));
		System.out.println("the Screenshot is taken");
		log.info("Checking Sale For Product 30% OFF");
		
	}

	//Checking the Cart 
	public void CheckCart() throws IOException {
		Cart=By.xpath(prop.getProperty("cart"));
		driver.findElement(Cart).click();
		CartTitle=By.xpath(prop.getProperty("cartTitle"));
		String ch = driver.findElement(CartTitle).getText();
		System.out.println(" ");
		System.out.println(ch);
		//Screen Shot
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcfile = tss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("ScreenShots\\Screen1.png"));
		System.out.println("the Screenshot is taken");
		log.info("Checking the cart Title");
	}

	//Checking the Invalid Login 
	public void CheckAccount() throws IOException{
		CheckAcc=By.xpath(prop.getProperty("checkAcc"));
		driver.findElement(CheckAcc).click();
		//Entering invalid UserName
		CheckUser=By.xpath(prop.getProperty("checkUser"));
		driver.findElement(CheckUser).sendKeys(prop.getProperty("username")+Keys.TAB+prop.getProperty("password")+Keys.TAB+Keys.TAB+Keys.ENTER);
		//Screen Shot
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcfile = tss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("ScreenShots\\Negative.png"));
		System.out.println("the Screenshot is taken");
		log.info("Checking Invalid Login");
	}

	// Closing the Browser
	public void CloseBrowser() {
		driver.quit();
	}
}
