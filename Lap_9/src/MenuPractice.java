
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuPractice {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ÃÒªÀÑ®¹¤Ã»°Á/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
//		driver.get("https://www.yahoo.com/");
		driver.navigate().to("https://www.noupe.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement mainMenu = driver.findElement(By.xpath("//*[@id='menu-item-90372']/a"));
		WebElement subMenu = driver.findElement(By.xpath("//*[@id='menu-item-90374']/a"));
		WebElement childMenu = driver.findElement(By.xpath("//*[@id='menu-item-90377']/a"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(mainMenu).perform();
		Thread.sleep(2000);
		
		act.moveToElement(subMenu).perform();
		Thread.sleep(2000);
		
		act.moveToElement(childMenu).click().perform();
		Thread.sleep(200);
		
		
		driver.navigate().back();
		Thread.sleep(2000);
		driver.close();
		System.out.println(" Finish !!!");
		
				
	}
	

}
