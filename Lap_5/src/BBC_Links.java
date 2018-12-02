import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BBC_Links {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ÃÒªÀÑ®¹¤Ã»°Á/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("http://www.bbc.com/");
		
		WebElement table = driver.findElement(By.xpath("//*[@id='page']/section[3]/div/div/section[2]"));
		
		List<WebElement> list = table.findElements(By.tagName("h3"));
		
		System.out.println(list.size());
		for(WebElement lst: list) {
			System.out.print(lst.getText()+"\t\n");
			
			
		}
	
		List<WebElement> detail = table.findElements(By.className("media__summary"));
		
		for(WebElement dt: detail) {
			
			System.out.print("\t\t"+dt.getText());
		}
		System.out.println("");
		
		Thread.sleep(500);
		driver.close();
		System.out.println(" Finish !!!");
		
				
	}
	

}
