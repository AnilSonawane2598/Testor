package Com.Ecommerse.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readconfiguration {
	Properties pro;

	public readconfiguration() {

		String s = "C:\\Users\\DELL\\eclipse-workspace\\Maven_project_Main\\src\\test\\resources\\configure\\configure.properties";
		File src = new File(s);
		pro = new Properties();
		try {
			FileInputStream file = new FileInputStream(src);

			try {
				pro.load(file);
			} catch (IOException i) {
				i.printStackTrace();
			}
		} catch (FileNotFoundException f) {
			System.out.println(f.getMessage());
			f.printStackTrace();

		}
	}

	public String geturl() {
		return pro.getProperty("baseurl");

	}

	public String getusername() {
		return pro.getProperty("username");
	}

	public String getpassword() {
		return pro.getProperty("password");

	}

	public String getdriver() {
		return pro.getProperty("browserdriver");

	}

	public String getdriveredge() {
		return pro.getProperty("edgedriver");

	}

}
