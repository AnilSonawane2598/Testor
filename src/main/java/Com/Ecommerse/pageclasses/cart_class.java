package Com.Ecommerse.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class cart_class {
public WebDriver driver;
	public cart_class(WebDriver driver)	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
