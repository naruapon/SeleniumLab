import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindJob_practice {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ÃÒªÀÑ®¹¤Ã»°Á/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://th.indeed.com");
		driver.findElement(By.id("text-input-what")).click();
		driver.findElement(By.id("text-input-what")).sendKeys("Selenium");
		driver.findElement(By.id("text-input-where")).click();
		driver.findElement(By.id("text-input-where")).clear();
		driver.findElement(By.id("text-input-where")).sendKeys("Bangkok");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		String result = driver.findElement(By.id("searchCount")).getText();
		
		if(result.equalsIgnoreCase("Jobs 1 to 10 of 27")) 
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		
		Thread.sleep(4000);
		driver.close();
		System.out.println("Finish !!!");
		
		
	}

}
