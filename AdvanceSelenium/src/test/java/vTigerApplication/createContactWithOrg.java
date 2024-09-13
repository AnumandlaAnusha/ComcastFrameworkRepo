package vTigerApplication;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createContactWithOrg {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\CommonDataVtiger.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("username");
		String PW = pro.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		
        driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("A01");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9988002211");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	//navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
	//click on create contact button	
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	//enter all the details and create new contact
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();
	//switch to child window
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> it = allWin.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			driver.switchTo().window(winId);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts"))
			{
				break;
			}
		}
		
		
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	//switch back to parent window
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> it1 = allWin.iterator();
		while(it1.hasNext())
		{
			String winId1 = it1.next();
			driver.switchTo().window(winId1);
			String actUrl1 = driver.getCurrentUrl();
			if(actUrl1.contains("module=Accounts"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='save [Alt+S]']")).click();

		
		

		
		
		

	}

}

		

