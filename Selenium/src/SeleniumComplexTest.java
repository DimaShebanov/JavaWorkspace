import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumComplexTest 
{
	@Test
	public void test_all1()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Workspace/calc.html");
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn1")).click();
		String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		assertEquals("111111111", str);
		driver.quit();
	}
	@Test
	public void test_all2()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Workspace/calc.html");
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		assertEquals("2222222222", str);
		driver.quit();
	}
	@Test
	public void test_more2()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Workspace/calc.html");
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn2")).click();
		String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		assertEquals("2222222222222222222222222222222222222222", str);
		driver.quit();
	}
	@Test
	public void test_1to9andclear()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Workspace/calc.html");
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btn4")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btn7")).click();
		driver.findElement(By.id("btn8")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btnclear")).click();
		String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		assertEquals("", str);
		driver.quit();
	}
	
}
