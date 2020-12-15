package PageObject;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

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

	public WebDriver createDriver(int option) {

		return driver = BaseUI.getDriver(option);
	}

	public UrbaanLader(WebDriver driver) {

		this.driver = driver;
	}
	public void popuping() {
		//log.info("Closing the pop-up");
		driver.findElement(By.linkText("Close")).click();
		
	}
	public void navigate1(){
		driver.navigate().to("https://www.urbanladder.com/");	
		//log.info("Navigating to the home page");
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
       s.dragAndDropBy(upper,(int) (-uwidth* (12.2)), 0);
       s.build().perform();
      //log.info("Selecting the price range");
       
	}
 
	public void storage(){
		
		 driver.findElement(storage).click();
		 try {

				Thread.sleep(1000);

				} catch (Exception e) {

		

				e.printStackTrace();

				}
		 WebElement check=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/form/div[1]/div/div/ul/li[3]/div[2]/div/div/div/ul/li[1]/input"));
		 check.click();
	   // log.info("Selecting the Storage Type");
	   
		
		
	}


	public void stock()  {
		 try {

				Thread.sleep(1000);

				} catch (Exception e) {

		

				e.printStackTrace();

				}
		driver.findElement(stock).click();
		//log.info("Selecting Stock type");
} 

	public void print(){
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
			System.out.print(shtitles.get(i).getText() + "  ");
			System.out.println(shprices.get(i).getText());
			FileIO.output1(name,price);	
    }
   
}
  
}
}
