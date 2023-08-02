package Com.Ecommerse.Testcases;

import org.testng.annotations.Test;

import Com.Ecommerse.Baseclass.Base_class;
import Com.Ecommerse.pageclasses.Register_page_class;
import Com.Ecommerse.Utilities.RetryAnalyzer;

public class register_test_class extends Base_class {

	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void start() throws InterruptedException {

		Register_page_class rc = new Register_page_class(driver);
		rc.register();
		logger.info("regester here");
		rc.male();
		logger.info("male user");
		rc.firstname("kiran");
		logger.info("enter name");
		rc.lastname("walke");
		logger.info("enter lastname");
		rc.day();
		logger.info("select day");
		rc.month();
		logger.info("select month");
		rc.year();
		logger.info("select year");
		rc.email();
		logger.info("enter email");
		Thread.sleep(3000);
		rc.javascripttocomponey();
		logger.info("scroll down till element");
		Thread.sleep(3000);
		rc.password("Rama@1234");
		logger.info("enter password");
		rc.confirmpass("Rama@1234");
		logger.info("confirm pass");
		rc.registorbutton();
		rc.successmsg();
		logger.info("done");
	}

}
