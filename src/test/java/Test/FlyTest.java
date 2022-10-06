package Test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hexaware.base.Base;

import Checking.FlyCode;

public class FlyTest extends Base {
	
	FlyCode fly;
	
	@BeforeMethod
	public void browserSetUp() {
		setUp();	
		fly = new FlyCode();
		}

	@Test(priority = 2)
	public void Calendar() {
		fly.Calendar();
		
	}
	@Test(priority = 2)
	public void TypeToFlyTest() {
		fly.TypeToFly();
		
	}
	
	@Test(priority = 1)
	public void PersonTest() {
		fly.Persons();
		
	}
	
	@Test(priority = 1)
	public void StepsTest() {
		fly.Calendar();
		fly.TypeToFly();
		fly.Fly();
		fly.Persons();
		fly.TypeToPassenger();
		fly.ButtonSubmit();
		logger.info("Choose a complete a Fly!");
	}
	
	@Test
	public void AllStepsTest() {
		fly.Calendar();
		fly.TypeToFly();
		fly.Fly();
		fly.Persons();
		fly.TypeToPassenger();
		fly.ButtonSubmit();
		fly.ButtonToFly();
		fly.ButtonToContinue();
		logger.info("Book a Fly done");
	}
	
	@AfterMethod
	public void Close() {
		CloseWebPage();
		
	}
	
}