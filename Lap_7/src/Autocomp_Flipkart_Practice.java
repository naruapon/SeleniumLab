
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocomp_Flipkart_Practice {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ÃÒªÀÑ®¹¤Ã»°Á/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if(driver.findElement(By.xpath("//*[@class='_32LSmx']")).isDisplayed())
			driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();
		
		driver.findElement(By.className("LM6RPg")).click();
		driver.findElement(By.className("LM6RPg")).sendKeys("Iphone x");
		
		List<WebElement> list = driver.findElements(By.className("_1va75j"));
		
		for(int i = 0;i<list.size();i++) {
			System.out.println(" - "+list.get(i).getText());	
			}
		
//		Thread.sleep(500);
//		driver.close();
		System.out.println(" Finish !!!");
		
				
	}
	
	public static int getCurrentDate() {
		Calendar now = Calendar.getInstance();
		int today = now.get(Calendar.DAY_OF_MONTH);
		return today ;
	}
	

}
