package Com.Ecommerse.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Ecommerse.Baseclass.Base_class;
import Com.Ecommerse.Utilities.RetryAnalyzer;
import Com.Ecommerse.Utilities.exceldatautil;
import Com.Ecommerse.pageclasses.login_page_class;

public class login_test_class extends Base_class {
	@Test(dataProvider = "Logindata", retryAnalyzer = RetryAnalyzer.class)

	public void log(String usr, String pwd, String expected) throws InterruptedException {
		login_page_class lc = new login_page_class(driver);
		lc.login();
		logger.info("open login");
		lc.email(usr);
		Thread.sleep(5000);
		logger.info("enter username");
		lc.pass(pwd);
		Thread.sleep(5000);
		logger.info("enter password");
		lc.loginbutton();
		logger.info("click on loginbutton");

		String title = driver.getTitle();
		System.out.println("the page title is-->" + title);
		logger.info("show page title");
		if (expected.equals("valid")) {
			if (title.equals("nopCommerce demo store")) {
				System.out.println("correct title");
				AssertJUnit.assertTrue(true);
				logger.info("test case pass");
			} else {
				System.out.println("wrong title");
				Assert.assertTrue(false);
				logger.info("test case fail");
			}
		} else if (expected.equals("invalid")) {
			if (title.equals("nopCommerce demo store")) {
				System.out.println("correct title");
				AssertJUnit.assertTrue(false);
				logger.info("test case pass");
			} else {
				System.out.println("wrong title");
				Assert.assertTrue(true);
				logger.info("test case fail");
			}
		}
	}

	@DataProvider(name = "Logindata")
	public String[][] getdata() throws IOException {
		String path = "C:\\Users\\DELL\\eclipse-workspace\\Maven_project_Main\\src\\main\\java\\Com\\Ecommerse\\testdata\\multipletestdata.xlsx";
		int rownum = exceldatautil.getrowcount(path, "Sheet1");
		int colnum = exceldatautil.getcellcount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = exceldatautil.getcelldata(path, "Sheet1", i, j);
			}
		}
		return logindata;

	}
}
