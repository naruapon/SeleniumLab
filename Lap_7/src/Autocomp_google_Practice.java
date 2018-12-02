
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocomp_google_Practice {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ÃÒªÀÑ®¹¤Ã»°Á/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.google.co.th/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("selenium");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//*[starts-with(@id,'sbse')]"));
		
		for(WebElement detail:list) {
			System.out.println(" - "+detail.getText());	
			}
		
		for(int i = 0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase("selenium IDE")) {
		
				list.get(i).click();
				break ;	
			}
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
