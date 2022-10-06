package Checking;

import org.openqa.selenium.By;
import com.hexaware.base.Base;

public class LoginCode extends Base {

	public void Login(String user, String pass) {

		web.findElement(By.xpath("//ul[@class='userSection pushRight']/li[3]")).click();
		// user
		web.findElement(By.xpath("//input[@name='username']")).sendKeys(user);
		web.findElement(By.xpath("//button[@class='capText font16']")).click();

		// password
		web.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		web.findElement(By.xpath("//button[@data-cy='login']")).click();
	}

	public void WrongUser(String user) {

		web.findElement(By.xpath("//ul[@class='userSection pushRight']/li[3]")).click();
		// user
		web.findElement(By.xpath("//input[@name='username']")).sendKeys(user);
		web.findElement(By.xpath("//section[@class='modalMain tcnFooter ']")).click();
		
	}
}
