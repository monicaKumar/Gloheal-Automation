package userDoctor;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_117 {
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
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/div[3]/a")).click();
		
		//driver.switchTo().alert();
		
		driver.switchTo().activeElement();
		
		driver.findElement(By.id("favorite_name")).sendKeys("Dolo650");
		WebElement element=driver.findElement(By.xpath(".//*[@id='addmed']/div/div/div[2]/div/div/form/div[2]/select"));
		Select se=new Select(element);
		se.selectByVisibleText("Drugs");
		//se.selectByIndex(2);
		//se.selectByValue(2);
		driver.findElement(By.xpath(".//*[@id='addmed']/div/div/div[2]/div/div/form/button")).click();
		
		String actualResult = "Medicine / Diagnostics added successfully";
		String expResult ="Medicine / Diagnostics added successfully";
		
		//expResult = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/div[1]")).getText();
		
		
	//	System.out.println(expResult);
		
		if(actualResult.contentEquals(expResult))
		{
			System.out.println("Medicine / Diagnostics added successfully");
		}else
		{
			System.out.println("Medicine / Diagnostics not added successfully");
		}
		Thread.sleep(10000);
		
		Actions actions = new Actions(driver);
		WebElement logout = driver.findElement(By.linkText("Logout"));
		actions.moveToElement(logout);
		actions.click().build().perform();
		
		Thread.sleep(10000);
	}

}
