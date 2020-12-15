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
	By search=By.id("search");
	By enter=By.xpath("//*[@id='search_button']/span");
	By price=By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[2]/div[1]");
	By stock=By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/form/div[2]/div/input");
    By storage=By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[3]/div[1]");
	By chairsearch=By.id("search");
	By filter=By.id("filters_primary_category_Study_Chair");
	By productTitle= By.xpath("//a[contains(text(),'Being At Home')]/parent::*/following-sibling::ul/li");
    By chairTitle=By.className("product-title-sofa-mattresses");
	By chairPrice=By.className("price-number");
	By shelvesTitle=By.className("product-title-sofa-mattresses");
    By shelvesPrice=By.className("price-number");
   

	public UrbaanLader() {
		fileio = new FileIO();
		prop = fileio.inputSetup();
	}

	

 public UrbaanLader(WebDriver driver){
	  this.driver=driver;
	  
 }
	
	public void createDriver(){
		driver=BaseUI.getDriver();
		
	}
	public void popuping() {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("Close")).click();
	}

	
	public void search(){
		
		driver.findElement(search).sendKeys("bookshelf");
		try {

			Thread.sleep(2000);

			} catch (Exception e) {

	

			e.printStackTrace();

			}
		driver.findElement(enter).click();
		//log.info("searching the bookshelf");
		}
	
	public void selectPrice() {
		driver.findElement(price).click();
		WebElement upper=driver.findElement(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[2]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));
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
		List<WebElement> shtitles = driver.findElements(shelvesTitle);
		List<WebElement> shprices = driver.findElements(shelvesPrice);
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



	
	
}
