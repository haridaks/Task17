package Task17;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealLoginVerification {

	public static void main(String[] args) throws Exception {
		// Q.1 Task17
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.snapdeal.com/");
		
		driver.manage().window().fullscreen();
		
		Thread.sleep(3000);
		
		WebElement element1 = driver.findElement(By.xpath("//div[@class = 'accountInner']"));
		
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		
		Thread.sleep(3000);
		//mousehover
		act.moveToElement(element1).build().perform();
		
		Thread.sleep(3000);
		
		//click and hold on the webelement
		act.clickAndHold(element1).build().perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class = 'accountBtn btn rippleWhite']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id = 'loginIframe']")));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder ='Mobile Number/ Email']	")).sendKeys("akshayahari10@gmail.com");
		
		Thread.sleep(10000);
		//adding explicit wait so that it can fetch the specified webelement
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkUser")));
         
         element.click();
		//driver.findElement(By.id("checkUser")).click();
		
		Thread.sleep(15000);
		
		driver.findElement(By.id("loginUsingOtp")).click();
		
		Thread.sleep(5000);
		
		String ExpectedUsername = "Akshaya H";
		
		String username = driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[3]/div/span[1]")).getText();
		
		Thread.sleep(3000);
		
		System.out.println(username);
		
		String ActualUsername = username;
		
		if (ExpectedUsername.equals(ActualUsername)) {
			
			System.out.println("User logged in sucessfully");
		} else {
			
			System.out.println("User login was unsucessful");
		}
		
		driver.close();
		
		
	}

}
