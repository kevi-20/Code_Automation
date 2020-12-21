package PageObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Resources.BaseUI;
import Resources.FileIO;

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
	public WebDriver driver;
	static Properties prop;
	static FileIO fileio;

	public UrbaanLader() {
		fileio = new FileIO();
		prop = fileio.inputSetup();
	}

	public WebDriver createDriver(int option) {

		return driver = BaseUI.getDriver(option);
	}

	public UrbaanLader(WebDriver driver) {

		this.driver = driver;
	}

	// Closing the Pop
	public void Popuping() {
		
		Close=By.linkText(prop.getProperty("Close"));
		driver.findElement(Close).click();

	}

	// Searching the BookShelf
	public void Search() throws InterruptedException {
		Search = By.id(prop.getProperty("Search"));
		driver.findElement(Search).sendKeys("bookshelf");
		Thread.sleep(1000);
		Enter = By.xpath(prop.getProperty("enter"));
		driver.findElement(Enter).click();

	}

	// Selecting the price
	public void SelectPrice() {
		Price = By.xpath(prop.getProperty("price"));
		driver.findElement(Price).click();	
		
		WebElement upper = driver.findElement(By.xpath(
				"//*[@id='filters-form']/div[1]/div/div/ul/li[2]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));
		int uwidth = upper.getSize().width;
		Actions s = new Actions(driver);
		s.dragAndDropBy(upper, (int) (-uwidth * (12.9)), 0);
		s.build().perform();

	}

	// Selecting the Storage Type as open
	public void Storage() throws InterruptedException {
		Storage = By.xpath(prop.getProperty("storage"));
		driver.findElement(Storage).click();
		Thread.sleep(1000);
		WebElement check = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/form/div[1]/div/div/ul/li[3]/div[2]/div/div/div/ul/li[1]/input"));
		check.click();

	}

	// Including Out of Stock
	public void Stock() throws InterruptedException {
		
	/** Including OutOfStock **/
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,+700)");
		
	}

	// Getting the results from the site and printing in Excel file and Console
	public void Print() throws IOException {

		 ShelvesTitle= By.className(prop.getProperty("shelvesTitle"));
		 ShelvesPrice= By.className(prop.getProperty("shelvesPrice"));
		
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
		}

	}

	public void CloseBrowser() {
		driver.quit();
	}
}
