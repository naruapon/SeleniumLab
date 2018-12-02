import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCheack {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ÃÒªÀÑ®¹¤Ã»°Á/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		
		driver.get("http://www.google.co.th");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		
		for(int i=0; i<list.size();i++) {
			if(!list.get(i).getText().equals(""))
			System.out.println(" "+list.get(i).getText());
		}
		
		Thread.sleep(500);
		driver.close();
		System.out.println("Finish !!!");
		
	}
	

}
