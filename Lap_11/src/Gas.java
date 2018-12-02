import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gas {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:/Users/NPRU/Desktop/Selenium 靡旬工没傲/Jar/BrowserDriver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String xrPath = "C:/Users/NPRU/Desktop/Selenium 靡旬工没傲/DDF/TestData/calculate-TestPlan.xlsx";
		String xwPath = "C:/Users/NPRU/Desktop/Selenium 靡旬工没傲/DDF/TestData/calculate-TestPlan_res.xlsx";
		
		driver.get("http://www.calculator.net/gas-mileage-calculator.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		ReadWriteExcel g = new ReadWriteExcel();
		g.xlRead(xrPath, 2);
		for(int i =1;i<g.xRows;i++) {
		driver.findElement(By.name("uscodreading")).clear();
		driver.findElement(By.name("uscodreading")).sendKeys(g.xData[i][0]);
		driver.findElement(By.name("uspodreading")).clear();
		driver.findElement(By.name("uspodreading")).sendKeys(g.xData[i][1]);
		driver.findElement(By.name("usgasputin")).clear();
		driver.findElement(By.name("usgasputin")).sendKeys(g.xData[i][2]);
		driver.findElement(By.name("usgasprice")).clear();
		driver.findElement(By.name("usgasprice")).sendKeys(g.xData[i][3]);

		driver.findElement(By.xpath("//*[@id='standard']/tbody/tr[5]/td[2]/input")).click();
		if(g.xData[i][4].trim().equals(driver.findElement(By.xpath("//*[@id='content']/font/b")).getText()))
		{
			g.xData[i][5] = "Pass";
		}
		else
			{
			g.xData[i][5] = "Fail";
			}
		}
		g.xlwrite(xwPath, g.xData);
//		Thread.sleep(2000);
		driver.close();
		System.out.println("Finish !!!");
	}

}
