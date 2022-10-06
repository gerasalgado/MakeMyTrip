package Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hexaware.base.Base;

import Checking.HotelCheckingCode;

public class HotelCheckingTest extends Base {

	
	HotelCheckingCode hotel;
	
	@BeforeMethod
	public void browserSetUp() {
		setUp();	
		hotel = new HotelCheckingCode();
		hotel.HotelButton();
		}
	
	@Test(priority = 2)
	public void RoomTest() {
		hotel.Room(properties.getProperty("Room"));
	}
	
	@Test(priority = 2)
	public void PriceTest() {
		hotel.Price(properties.getProperty("Price"));
	}
	
	@Test(priority = 2)
	public void CalendarTest() {
		hotel.Calendar(properties.getProperty("Start_date"), properties.getProperty("End_date"));
	}
	
	@Test(priority = 1)
	public void CityTest() {
		hotel.CityHotel(properties.getProperty("City_Hotel"));
	}
	
	@Test
	public void AllTest() {
		hotel.CityHotelAndCalendar(properties.getProperty("City_Hotel"),properties.getProperty("Start_date"), properties.getProperty("End_date"));
		hotel.Price(properties.getProperty("Price"));
		hotel.Room(properties.getProperty("Room"));
		web.findElement(By.xpath("//button[@id='hsw_search_button']")).click();
	}

	@AfterMethod
	public void Close() {
		CloseWebPage();
	}
	
}
