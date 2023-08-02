package Com.Ecommerse.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page_class {
public static WebDriver driver;
	public login_page_class(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Log in']")
	WebElement login;

	@FindBy(xpath = "(//input[@type=\"email\"])[1]")
	WebElement email;

	@FindBy(xpath = "(//input[@id=\"Password\"])")
	WebElement pass;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginbutton;

	public void login() {
		login.click();
	}

	public void email(String email1) {
		email.sendKeys(email1);
	}

	public void pass(String pass3) {
		pass.sendKeys(pass3);
	}

	public void loginbutton() {
		loginbutton.click();
	}

}
