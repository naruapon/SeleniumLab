
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JQuerySlider_Practice {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ÃÒªÀÑ®¹¤Ã»°Á/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://jqueryui.com/slider/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));

		Point from = slider.getLocation();
		System.out.println("Form Co-ordinate x : "+from.getX());
		System.out.println("Form Co-ordinate y : "+from.getY());
		
		Actions act = new Actions(driver);
		
		act.dragAndDropBy(slider, 200, 4).build().perform();
		
		Point to = slider.getLocation();
		System.out.println("To Co-ordinate x : "+to.getX());
		System.out.println("To Co-ordinate y : "+to.getY());
		
		
		Thread.sleep(5000);
		driver.close();
		System.out.println(" Finish !!!");
				
	}
	

}
