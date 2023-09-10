package marahon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Makemytrip {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(opt);

		//ChromeDriver driver =new ChromeDriver();

		driver.get(" https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(5000);
		Actions act =new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")));
		driver.findElement(By.xpath("//a[@class='close']")).click();
		driver.switchTo().defaultContent();
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
		driver.executeScript("arguments[0].click()", logo);
		driver.findElement(By.xpath("(//span[@class='chNavText darkGreyText'])[4]")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//div[text()='Goa']")).click();
		
		
		// driver.findElement(By.xpath("//span[@class='appendBottom5 field-label blue-font up-arrow ']")).click();
	        driver.findElement(By.xpath("(//div[@class='DayPicker-Day'])[1]")).click();
		
		driver.findElement(By.xpath("(//div[@class='pointer plus-sign-wrapper'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		
		
		WebElement drag = driver.findElement(By.xpath("//div[@class='rc-slider-track rc-slider-track-1']"));
		act.dragAndDropBy(drag,20, 0).build().perform();
		WebElement drop = driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-2']"));
		act.dragAndDropBy(drop,200, 0).build().perform();
		driver.findElement(By.xpath("//button[@class='action']")).click();
		driver.findElement(By.id("search_button")).click();
		
		
		driver.findElement(By.xpath("//button[text()='SKIP']")).click();
		driver.findElement(By.xpath("//span[@class='close closeIcon']")).click();
		
		 
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.xpath("//div[@class='slideItem relative']"));
		  javascript.executeScript("arguments[0].scrollIntoView();", element1);
		  File source = element1.getScreenshotAs(OutputType.FILE);
		  File target = new File("./snap/makemytrip.png");
		  FileUtils.copyFile(source, target);

		  System.out.println("Page Title:" + driver.getTitle());
		 		
		
		
       
		

	}

}
