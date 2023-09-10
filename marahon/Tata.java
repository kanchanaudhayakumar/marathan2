package marahon;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
//import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Tata {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(opt);

		//ChromeDriver driver =new ChromeDriver();

		driver.get("https://www.tatacliq.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement findElement = driver.findElement(By.xpath("//div[@class='DesktopHeader__categoryAndBrand'][2]"));
		Actions act1 =new Actions(driver);
		act1.moveToElement(findElement).perform();
		WebElement findElement2 = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		Actions act2 =new Actions(driver);
		act1.moveToElement(findElement2).perform();
		driver.findElement(By.xpath("//div[text()='Casio']")).click();
		driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']")).click();
		driver.findElement(By.xpath("//option[text()='New Arrivals']")).click();
		driver.findElement(By.xpath("(//div[@class='Accordion__filtHeadLine'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='FilterDesktop__newFilCheckboxBlock'][1]")).click();
		List<Integer> sortPrice = new ArrayList<Integer>();
		List<WebElement> cprice = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));
		
		System.out.println(cprice.size());
		for(int i=0; i<cprice.size();i++)
		{
			String price  = cprice.get(i).getText();
			System.out.println(price);
			
		}
		
		driver.findElement(By.xpath("(//div[@class='ProductModule__base'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		String price2 = driver.findElement(By.xpath("(//div[@class='ProductDescription__priceHolder'])[2]")).getText().replaceAll("[^0-9]","");
		System.out.println("second price"+price2);
		//if(price1.equalsI)
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		Thread.sleep(5000);
		System.out.println("items cart"+driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText());
		
		driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
		Thread.sleep(5000);
		File source=driver.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./screenshot/photo.png");
		FileUtils.copyFile(source, Dest);
		
		driver.close();
				
		
		
		
		

	}

}
