package Code.Automation;

public class TestCases {
  	public WebDriver driver;

	Implementation i = new Implementation(driver);
	
	@BeforeTest
	public void InvokeBrowser() {

		//ExtentTest logger = report.createTest("Invoke Browser");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for Chrome \nEnter 2 for Firefox");
		int ch = sc.nextInt();
		sc.close();
		//logger.log(Status.INFO, "Initailising the browser");
		//log.info("Opening the browser");
		i.createDriver(ch);

	}
	
	@Test(priority = 1)
	public void Invalid() throws IOException {
		//ExtentTest logger = report.createTest("Checking if the website is accepting invalid characters");
		//logger.log(Status.INFO, "Checking if the website is accepting invalid characters");
		//log.info("Checking if the website is accepting invalid characters");
		i.popuping();
		i.navigate1();
		
	}
	
	@Test(priority = 2)
	public void enter() throws IOException {
		i.search();
	}
	
	@Test(priority = 3)
	public void price() throws IOException {
		i.selectPrice();
	}
	
	@Test(priority = 4)
	public void Storage() throws IOException {
		i.storage();
	}
	
	@Test(priority = 5)
	public void Stock() throws IOException {
		i.stock();
	}
	
	@Test(priority = 6)
	public void output() throws IOException {
		i.print();
	}

}
