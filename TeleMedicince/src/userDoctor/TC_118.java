package userDoctor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_118 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://preprod3.tcura.com");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement Signin = driver.findElement(By.xpath(".//*[@id='home']/div/div/div[3]/div[1]/ul/li[3]/a"));
		Signin.click();
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("gloheal10@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.id("doctor_med_dia")).click();
	//	driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/div[3]/a")).click();
		//driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div[2]/div[3]/div[3]/a[1]"));
		//driver.switchTo().alert();
	/*	int total =0;
		List<WebElement> totalDivs = driver.findElements(By.className("appointments-list bookmarks-list notopmargin"));
		
		for(WebElement we : totalDivs){
		    total += Integer.parseInt(we.getText());
		}
		System.out.println(total);
		*/
	//	driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div[2]/div[4]"));
		
		WebElement EditValue = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div[2]/div[2]/div[3]/a[1]"));
		EditValue.click();
		driver.switchTo().activeElement();
		driver.findElement(By.id("favorite_name")).clear();
		driver.findElement(By.id("favorite_name")).sendKeys("Edit Dolo 650");
		driver.findElement(By.xpath(".//*[@id='addmed']/div/div/div[2]/div/div/form/button")).click();
		String ActMsg = "Medicine / Diagnostics updated successfully";
		//String ExpMsg = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/div[1]")).getText();
		String ExpMsg = "Medicine / Diagnostics updated successfully";
		System.out.println(ExpMsg);
		if(ActMsg.contentEquals(ExpMsg))
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}
		
		Thread.sleep(10000);
		
		Actions actions = new Actions(driver);
		WebElement logout = driver.findElement(By.linkText("Logout"));
		actions.moveToElement(logout);
		actions.click().build().perform();
		
		Thread.sleep(10000);
		
	}

}
