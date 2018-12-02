
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQuery_Practice {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/NPRU/Desktop/Selenium ราชภัฎนครปฐม/Jar/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		//^^^^^^^^^^^^									//
		//เลือกเฟรม  (Select Frame) 	 ถ้าไม่มีเฟรมอื่รใส่ค่าในเฟรมเป็น 0 ได้เลย		driver.switchTo().frame(0);						//
		driver.findElement(By.id("datepicker")).click();
		WebElement table = driver.findElement(By.className("ui-datepicker-calendar"));

		List<WebElement> tdlist = table.findElements(By.tagName("a"));
		System.out.println("Total number of days : "+tdlist.size());
		int today =getCurrentDate();
		System.out.println("Today is : "+today);
		
		for(int i = today;i<tdlist.size();i++) {
			String date = tdlist.get(i).getText();
			if(date.equalsIgnoreCase("26")) {
			System.out.print("Selected is : "+date);	
			tdlist.get(i).click();
			break ;
			}
		}
//
		System.out.println("");
		
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
