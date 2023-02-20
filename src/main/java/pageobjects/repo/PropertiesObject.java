package pageobjects.repo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesObject {
	public static void main(String[] args) throws IOException {

		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "pageobjects/repo/Object_Repo.properties");
		obj.load(objfile);

	}
}
