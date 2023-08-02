package Com.Ecommerse.Baseclass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.Ecommerse.configuration.*;

@SuppressWarnings("unused")
public class Base_class {
	public static WebDriver driver;
	public static Logger logger;

	readconfiguration rc = new readconfiguration();
	public String eurl = rc.geturl();
	public String eusername = rc.getusername();
	public String epassword = rc.getpassword();

	@SuppressWarnings({ "static-access", "deprecation" })
	@BeforeMethod
	@Parameters("bdriver")
	public void openbrowser(String bdriver) {
		if(bdriver.equals("chrome")) {
		System.setProperty("WebDriver.chrome.driver", rc.getdriver());
		driver = new ChromeDriver();
	}
	else if(bdriver.equals("edge")){
		System.setProperty("WebDriver.chrome.driver", rc.getdriveredge());
		driver=new EdgeDriver();
	}
		
		driver.manage().window().maximize();

		logger = logger.getLogger("open url");
		PropertyConfigurator.configure("C:\\Users\\DELL\\eclipse-workspace\\Maven_project_Main\\src\\test\\resources\\configure\\log4j.properties");
		logger.info("open page");

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(rc.geturl());
		logger.info("open ecomerse app");
		

	}

	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(6000);
		logger.info("close browser");
		driver.quit();
	}
}
