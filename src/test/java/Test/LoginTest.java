package Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hexaware.base.Base;

import Checking.LoginCode;

public class LoginTest  extends Base {

	
	LoginCode login;
	
	@BeforeMethod
	public void browserSetUp() {
		setUp();	
		login = new LoginCode();
		}
	
	@Test
	public void loginTest() {
		login.Login(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	@Test
	public void WrongUsernameTest() {
		login.WrongUser(properties.getProperty("wuser"));
		Assert.assertEquals("Please enter a valid Email Id or Mobile Number.", web.findElement(By.xpath("//p[@data-cy='error']")).getText());
	}
	
	@AfterMethod
	public void Close() {
		CloseWebPage();
	}
	
}