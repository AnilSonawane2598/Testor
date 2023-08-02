package Com.Ecommerse.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.Ecommerse.Baseclass.Base_class;
import Com.Ecommerse.pageclasses.broken_links;

public class brokenlinks extends Base_class {
	@Test
	public void printalllink() throws IOException {

		broken_links bl = new broken_links(driver);
		bl.links();

	}
}
