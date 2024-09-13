package POMImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sampleTestWithoutPOM {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
	    WebElement ele1 = driver.findElement(By.name("user_name"));
		WebElement ele2 = driver.findElement(By.name("user_password"));
		WebElement ele3 = driver.findElement(By.id("submitButton"));
// enter username and password		
		ele1.sendKeys("admin");
		ele2.sendKeys("root");
//refreshing the page		
		driver.navigate().refresh();
// Re-enter username and password
		ele1.sendKeys("admin");
		ele2.sendKeys("root");
// stale elmnt ref exception becoz the address of the elements become old		
		ele3.click();
		
	}

}
