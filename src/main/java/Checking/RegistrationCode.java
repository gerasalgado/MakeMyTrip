package Checking;

import org.openqa.selenium.By;

import com.hexaware.base.Base;

public class RegistrationCode extends Base{

	public  void NewUser(String user,String OTP, String newname, String newpass)  {

	web.findElement(By.xpath("//ul[@class='userSection pushRight']/li[3]")).click();
	//user
	web.findElement(By.xpath("//input[@name='username']")).sendKeys(properties.getProperty("username"));
	web.findElement(By.xpath("//button[@class='capText font16']")).click();
	
	//OTP
	web.findElement(By.xpath("//input[@placeholder='Enter OTP here']")).sendKeys(properties.getProperty("OTP"));
	web.findElement(By.xpath("//button[@data-cy='verifyAndCreate']")).click();
	
	//Fill the info
	web.findElement(By.xpath("//input[@id='firstName']")).sendKeys(properties.getProperty("Name"));
	web.findElement(By.xpath("//input[@id='password']")).sendKeys(properties.getProperty("new_password"));
	}
}
