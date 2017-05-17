import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRealJob 
{

	@Test
	public void test_div()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Workspace/calc.html");
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn8")).click();
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btndiv")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btneq")).click();
		String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		assertEquals("5.6", str);
		driver.quit();
	}
	@Test
	public void test_mult()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Workspace/calc.html");
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn8")).click();
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btnmult")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btneq")).click();
		String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		assertEquals("14000", str);
		driver.quit();
	}
	@Test
	public void test_plus()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Workspace/calc.html");
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn8")).click();
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btnpl")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btneq")).click();
		String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		assertEquals("330", str);
		driver.quit();
	}
	@Test
	public void test_minus()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Workspace/calc.html");
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn8")).click();
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btnmin")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btneq")).click();
		String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		assertEquals("230", str);
		driver.quit();
	}
}
