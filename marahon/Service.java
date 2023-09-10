package marahon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;


//import io.cucumber.messages.types.Duration;

public class Service {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		  driver.get("https://dev124621.service-now.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.id("user_name")).sendKeys("admin");
		  driver.findElement(By.id("user_password")).sendKeys("Ak^x88vhDMV=");
		  driver.findElement(By.id("sysverb_login")).click();
		  Shadow dom=new Shadow(driver);
		  dom.setImplicitWait(10);
		  dom.findElementByXPath("//div[text()='All']").click();
		  dom.findElementByXPath("//span[text()='Service Catalog']").click();
		  WebElement frame=dom.findElementByXPath("//iframe[@id='gsft_main']");
		  driver.switchTo().frame(frame);
		  driver.findElement(By.linkText("Mobiles")).click(); 
		  driver.findElement(By.linkText("Apple iPhone 13 pro")).click(); 
		  
		  WebElement yes=driver.findElement(By.xpath("//input[@class='cat_item_option radio']"));
		  driver.executeScript("arguments[0].click();", yes);
		  driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");
		  WebElement sel=driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));

		  Select select=new Select(sel);
		  select.selectByIndex(1);
		  WebElement color=driver.findElement(By.xpath("//label[text()='Sierra Blue']/preceding-sibling::input"));
		  driver.executeScript("arguments[0].click();", color);
		  WebElement storage=driver.findElement(By.xpath("//label[contains(text(),'512 GB')]/preceding-sibling::input"));
		  driver.executeScript("arguments[0].click();", storage);
		  
		  
		  driver.findElement(By.id("oi_order_now_button")).click();
		  System.out.println("Request id:"+driver.findElement(By.id("requesturl")).getText());
		  File source=driver.getScreenshotAs(OutputType.FILE);
		  File target=new File("./snap/ServiceOrder.png");
		  FileUtils.copyFile(source, target);
		   
		  driver.close();

	}

}
