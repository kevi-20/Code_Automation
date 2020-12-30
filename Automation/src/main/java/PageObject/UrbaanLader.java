package PageObject;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Resources.BaseUI;
import Resources.FileIO;




public class UrbaanLader {
	public WebDriver driver;
	static Properties prop;
	static FileIO fileio;
	static By Close;
	static By search;
	static By enter;
	static By price;
	static By stock;
    static By storage;
	static By chairsearch;
	static By filter;
	static By productTitle;
    static By chairTitle;
	static By chairPrice;
	static By shelvesTitle;
    static By shelvesPrice;


	public UrbaanLader() {
		fileio = new FileIO();
		prop = fileio.inputSetup();
	}

	

 public UrbaanLader(WebDriver driver){
	  this.driver=driver;
	  
 }
	
	public void createDriver() throws IOException{
		driver =  BaseUI.getDriver();
		
	}
	public void popuping() {
		Close=By.linkText(prop.getProperty("Close"));
		try {

			Thread.sleep(2000);

			} catch (Exception e) {

	

			e.printStackTrace();

			}
		driver.findElement(By.xpath("//input[@class='email required input_authentication']")).sendKeys("tej");
		driver.findElement(By.xpath("//input[@class='required input_authentication']")).sendKeys("tej@123");
		driver.findElement(By.id("ul_site_login")).click();
		driver.findElement(Close).click();
	}

	
	public void search(){
		search=By.id(prop.getProperty("search"));
		driver.findElement(search).sendKeys(prop.getProperty("bookshelf"));
		try {

			Thread.sleep(2000);

			} catch (Exception e) {

	

			e.printStackTrace();

			}
		driver.findElement(By.xpath(prop.getProperty("enter"))).click();
		//log.info("searching the bookshelf");
		}
	
	public void selectPrice() {
		driver.findElement(By.xpath(prop.getProperty("price"))).click();
		WebElement upper=driver.findElement(By.xpath(prop.getProperty("upper")));
       int uwidth=upper.getSize().width;            
       Actions s=new Actions(driver);
       s.dragAndDropBy(upper,(int) (-uwidth* (11.9)), 0);
       s.build().perform();
     // log.info("Selecting the price range");
       
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
			System.out.print(shtitles.get(i).getText() + "  ");
			System.out.println(shprices.get(i).getText());
		FileIO.output0(name,price,size);	
   }
		
  
}
public void print1(){
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
		System.out.print(shtitles.get(i).getText() + "  ");
		System.out.println(shprices.get(i).getText());
	FileIO.output1(name,price,size);	
}
	

}
public void print2(){
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
		System.out.print(shtitles.get(i).getText() + "  ");
		System.out.println(shprices.get(i).getText());
	FileIO.output2(name,price,size);	
}
	

}



	public void Storage() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("storage"))).click();
		Thread.sleep(1000);
		WebElement check = driver.findElement(By.xpath(prop.getProperty("check")));
		check.click();
	}



	public void Stock() throws InterruptedException {
		 Thread.sleep(1000);
			driver.findElement(By.xpath(prop.getProperty("stock"))).click();
		
	}



	


	


	
	
}
