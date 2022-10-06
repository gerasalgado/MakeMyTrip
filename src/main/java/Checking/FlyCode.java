package Checking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hexaware.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlyCode extends Base {

	public void TypeToFly() {
		web.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		logger.info("Type to Fly selected!");
		screenShot("Fly/Typetofly");
	}

	public void TypeToPassenger() {
		// Choose the type
		web.findElement(By.xpath("//ul[@class='specialFareNew']/li[1]")).click();
		logger.info("Type to Passenger selected!");
		screenShot("Fly/Passenger");
	}

	public void Calendar() {
		// calendario
		List<WebElement> calendar = web.findElements(By.cssSelector("span[class='lbl_input latoBold appendBottom10']"));
		calendar.get(0).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		web.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Oct 10 2022')]")).click();
		calendar.get(1).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		web.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Oct 20 2022')]")).click();
		logger.info("Calendar selected!");
		screenShot("Fly/CalendarFly");
	}

	public void Persons() {
		web.findElement(By.xpath("//div[@class='fsw_inputBox flightTravllers inactiveWidget ']/label")).click();
		web.findElement(By.xpath("//div[@class='travellers gbTravellers']/div/ul/li[2]")).click();
		web.findElement(By.xpath("//div[@class='makeFlex appendBottom25']/div/ul/li[1]")).click();
		web.findElement(By.xpath("//div[@class='makeFlex appendBottom25']/div[2]/ul/li[2]")).click();
		web.findElement(By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/li[2]")).click();
		// button to aply
		logger.info("Travelers selected!");
		web.findElement(By.xpath("//button[@type='button']")).click();
		screenShot("Fly/NoToPeople");
	}

	public void Fly() {
		// from
		web.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']/label")).click();
		web.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/div/input"))
				.sendKeys(properties.getProperty("City"));
		List<WebElement> list = web.findElements(By.xpath("//div[@class='calc60']/p"));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			//System.out.println("Text is " + text);
			if (text.contains(properties.getProperty("City"))) {
				list.get(i).click();
				break;
			}
		}

		// to
		web.findElement(By.xpath("//div[@class='fsw_inputBox searchToCity inactiveWidget ']/label")).click();
		web.findElement(By.xpath(
				"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin makeFlex column spaceBetween\"]/div/input"))
				.sendKeys(properties.getProperty("City_from"));
		List<WebElement> list2 = web.findElements(By.xpath("//div[@class='calc60']/p"));
		for (int i = 0; i < list2.size(); i++) {
			String text = list2.get(i).getText();
			//System.out.println("Text is " + text);
			if (text.contains(properties.getProperty("City_from"))) {
				list2.get(i).click();
				break;
			}
		}
		logger.info("Choose a Fly!");
		screenShot("Fly/Flychoose");
	}

	public void ButtonSubmit() {
		// button to submit
		web.findElement(By.xpath("//p[@data-cy='submit']")).click();
		logger.info("Button Selected Clicked!");
		screenShot("Fly/Submit");
	}
	
	public void ButtonToFly() {
		web.findElement(By.xpath("//button[@class=\"splitFooterButton button buttonPrimary buttonBig appendBottom8 \"]")).click();
		logger.info("Button To Check Fly Clicked!");
		screenShot("Fly/Clicked");
	}
	
	public void ButtonToContinue() {
		web.findElement(By.xpath("//button[@class=\"buttonPrimary buttonBig  lato-black button\"]")).click();
		logger.info("Button To Continue Clicked!");
		screenShot("Fly/Continue");
	}
}
