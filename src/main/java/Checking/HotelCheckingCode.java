package Checking;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hexaware.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelCheckingCode extends Base {

	public void Calendar(String start, String end) {
		//calendario
		
		String xpath1 = "//div[@class='DayPicker-Day'][contains(@aria-label, '"+start+"')]";
		String xpath2 = "//div[@class='DayPicker-Day'][contains(@aria-label, '"+end+"')]";
		
		web.findElement(By.xpath("//div[@class='hsw_inputBox dates  ']/label")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		web.findElement(By.xpath(xpath1)).click();
		web.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		web.findElement(By.xpath(xpath2)).click();
		web.findElement(By.xpath("//html")).click();	
		logger.info("Calendar selected!");
		screenShot("Hotel/Calendar Checked");
	}
	
	public void Price (String price) {
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String xpath = "//ul[@data-test='Property-list']/li["+price+"]";
		web.findElement(By.xpath(xpath)).click();
		logger.info("Price selected!");
		screenShot("Hotel/Price Checked");
	}
	
	public void HotelButton() {
		web.findElement(By.xpath("//a[@class='makeFlex hrtlCenter column']")).click();
		logger.info("Button to Redirect to Hotel clicked!");
	}
	
	public void Room(String value) {
		// check the rooms
		String xpath = "//ul[@data-cy='adultCount']/li["+value+"]";
				web.findElement(By.xpath("//div[@class='hsw_inputBox roomGuests  ']/label")).click();
				web.findElement(By.xpath(xpath)).click();
				// web.findElement(By.xpath("//ul[@class='guestCounter font12
				// darkText'][2]/li[0]")).click();
				web.findElement(By.xpath("//button[@data-cy='submitGuest']")).click();
				logger.info("Room selected!");
				screenShot("Hotel/Room Checked");
	}
	
	public void CityHotel(String city) {
		// check the hotel
				web.findElement(By.xpath("//div[@class='hsw_inputBox selectHtlCity  ']/label")).click();
				web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				web.findElement(By.xpath("//div[@class='hsw_autocomplePopup locus autoSuggestPlugin ']/div/input"))
						.sendKeys(city);
				web.findElement(By.xpath("//div[@class='spaceBetween makeFlex hrtlCenter']/div/p")).click();
				logger.info("City selected!");
				screenShot("Hotel/Hotel Checked");
	}
	
	public void CityHotelAndCalendar(String city,String start, String end) {
		// check the hotel
				web.findElement(By.xpath("//div[@class='hsw_inputBox selectHtlCity  ']/label")).click();
				web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				web.findElement(By.xpath("//div[@class='hsw_autocomplePopup locus autoSuggestPlugin ']/div/input"))
						.sendKeys(city);
				logger.info("City selected!");
				screenShot("Hotel/Hotel Checked");
				web.findElement(By.xpath("//div[@class='spaceBetween makeFlex hrtlCenter']/div/p")).click();
				String xpath1 = "//div[@class='DayPicker-Day'][contains(@aria-label, '"+start+"')]";
				String xpath2 = "//div[@class='DayPicker-Day'][contains(@aria-label, '"+end+"')]";
				web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				web.findElement(By.xpath(xpath1)).click();
				web.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				web.findElement(By.xpath(xpath2)).click();
				web.findElement(By.xpath("//html")).click();
				logger.info("Calendar selected!");
				screenShot("Hotel/Calendar Checked");
	}
	
}
