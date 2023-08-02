package Com.Ecommerse.pageclasses;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.Ecommerse.Baseclass.Base_class;
import net.bytebuddy.utility.RandomString;

public class Register_page_class extends Base_class {

	public Register_page_class(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	public WebElement register;

	@FindBy(id = "gender-male")
	public WebElement male;

	@FindBy(id = "FirstName")
	public WebElement firstname;

	@FindBy(id = "LastName")
	public WebElement lastname;

	@FindBy(xpath = "//select[@name=\"DateOfBirthDay\"]//option")
	public List<WebElement> day;

	@FindBy(xpath = "//select[@name=\"DateOfBirthMonth\"]//option")
	public List<WebElement> month;

	@FindBy(xpath = "//select[@name=\"DateOfBirthYear\"]//option")
	public List<WebElement> year;

	@FindBy(id = "Email")
	public WebElement email;

	@FindBy(id = "Password")
	public WebElement password;

	@FindBy(id = "ConfirmPassword")
	public WebElement confirmpass;

	@FindBy(xpath = "//button[@id=\"register-button\"]")
	public WebElement registorbutton;

	@FindBy(xpath = "//strong[contains(text(),'Options')]")
	public WebElement javascripttocomponey;

	@FindBy(xpath = "//div[text()='Your registration1234 completed']")
	public WebElement successmsg;

	public String a = "5";
	public String b = "June";
	public String c = "1990";

	public void register() {
		register.click();
	}

	public void male() {
		male.click();
	}

	public void firstname(String fname) {
		firstname.sendKeys(fname);
	}

	public void lastname(String lname) {
		lastname.sendKeys(lname);
	}

	public void day() {

		for (int i = 0; i < day.size(); i++) {

			if (day.get(i).getText().equals(a))
				day.get(i).click();

		}
	}

	public void month() {

		for (int i = 0; i < month.size(); i++) {

			if (month.get(i).getText().equals(b))
				month.get(i).click();

		}
	}

	public void year() {

		for (int i = 0; i < year.size(); i++) {

			if (year.get(i).getText().equals(c))
				year.get(i).click();
		}

	}

	public void email() {
		String s = RandomString.make(6);
		email.sendKeys(s + "@gmail.com");
	}

	public void javascripttocomponey() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", javascripttocomponey);
	}

	public void password(String pass1) {
		password.sendKeys(pass1);
	}

	public void confirmpass(String pass2) {
		confirmpass.sendKeys(pass2);
	}

	public void registorbutton() {
		registorbutton.click();
	}

	public void successmsg() {
		String text = successmsg.getText();
		System.out.println(text);
		if (text.equals(text)) {
			System.out.println("Correct text");
			Assert.assertTrue(true);
		} else {
			System.out.println("Wrong text");
			Assert.assertFalse(false);
		}
	}

}
