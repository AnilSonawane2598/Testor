package Com.Ecommerse.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class serch_page_class {
public static WebDriver driver;

	public serch_page_class() {
		
		PageFactory.initElements(driver, this);
	}
}
