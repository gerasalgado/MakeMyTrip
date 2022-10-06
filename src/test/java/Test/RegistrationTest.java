package Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hexaware.base.Base;

import Checking.RegistrationCode;


public class RegistrationTest extends Base {

	
	RegistrationCode registration;
	
	@BeforeMethod
	public void browserSetUp() {
		setUp();	
		registration = new RegistrationCode();
		}
	
	@Test
	public void loginTest() {
		registration.NewUser(properties.getProperty("new_user"), properties.getProperty("OTP"), properties.getProperty("name"), properties.getProperty("new_password"));
	}
	
	@AfterMethod
	public void Close() {
		CloseWebPage();
	}
	
}