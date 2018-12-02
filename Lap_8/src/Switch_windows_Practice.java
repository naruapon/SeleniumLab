
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switch_windows_Practice {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ÃÒªÀÑ®¹¤Ã»°Á/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='uh-search-box']")).sendKeys("Bnk48");
		
		List<WebElement> list = driver.findElements(By.className("yui3-aclist-item"));
		Thread.sleep(4000);

		for(int i = 0;i<list.size();i++) {
			String date = list.get(i).getText();
			if(date.equalsIgnoreCase("bnk48")) {	
			list.get(i).click();
			break ;
			}
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='web']/ol/li[1]/div/div[1]/h3/a")).click();
		
		Set <String> winId = driver.getWindowHandles(); 
		List <String> winlis = new ArrayList<String>(winId); 
		for (int i = 0; i < winlis.size(); i++){
			System.out.println(" "+winlis.get(i).toString()); 
			} 
		Thread.sleep(2000);
		driver.switchTo().window(winlis.get(1).toString()); 
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(winlis.get(0).toString()); 
		driver.close();

//		
////		Thread.sleep(500);
////		driver.close();
//		System.out.println(" Finish !!!");
//		
				
	}
	

}
