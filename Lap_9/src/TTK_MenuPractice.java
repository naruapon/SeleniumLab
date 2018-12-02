
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

public class TTK_MenuPractice {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ÃÒªÀÑ®¹¤Ã»°Á/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
//		driver.get("https://www.yahoo.com/");
		driver.navigate().to("http://www.thaiticketmajor.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='lang-swap-link btn-enter-site']")).click();
		
		
		WebElement concertMenu = driver.findElement(By.xpath("//*[@id='menu-th']/li[3]/a"));
		WebElement childMenu = driver.findElement(By.xpath("//*[@id='menu-th']/li[3]/div/div[3]/a/img"));
		
		Actions act = new Actions(driver);
//		
//		act.moveToElement(mainMenu).perform();
//		Thread.sleep(2000);
//		
		act.moveToElement(concertMenu).perform();
		Thread.sleep(2000);
		
		act.moveToElement(childMenu).click().perform();
		Thread.sleep(200);
		
		
//		driver.navigate().back();
		Thread.sleep(2000);
		driver.close();
		System.out.println(" Finish !!!");
		
				
	}
	

}
