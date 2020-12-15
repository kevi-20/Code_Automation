package PageObject;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Resources.BaseUI;
import Resources.FileIO;


public class UrbaanLader {
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
	public void search(){
		
		driver.findElement(search).sendKeys("bookshelf");
		try {

			Thread.sleep(2000);

			} catch (Exception e) {

	

			e.printStackTrace();

			}
		driver.findElement(enter).click();
		log.info("searching the bookshelf");
		}

	public void selectPrice() {
		driver.findElement(price).click();
		WebElement upper=driver.findElement(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[2]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));
       int uwidth=upper.getSize().width;            
       Actions s=new Actions(driver);
       s.dragAndDropBy(upper,(int) (-uwidth* (11.9)), 0);
       s.build().perform();
      log.info("Selecting the price range");
       
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
			ExcelUtils.output0(name,price,size);	
   }
  
}
}
