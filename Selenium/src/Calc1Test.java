import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calc1Test 
{

	@Test
	public void test_exist_txt1()
	{
		System.setProperty("webdriver.chrome.driver", "D:/temp/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/temp/calcv1.html");
		WebElement e=driver.findElement(By.id("txt1"));
		assertTrue(e != null);
		driver.quit();
	}
	@Test
	public void test_exist_txt2()
	{
		System.setProperty("webdriver.chrome.driver", "D:/temp/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/temp/calcv1.html");
		WebElement e=driver.findElement(By.id("txt2"));
		assertTrue(e != null);
		driver.quit();
	}
	@Test
	public void test_exist_res()
	{
		System.setProperty("webdriver.chrome.driver", "D:/temp/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/temp/calcv1.html");
		WebElement e=driver.findElement(By.id("res"));
		assertTrue(e != null);
		driver.quit();
	}
	@Test
	public void test_exist_resbut()
	{
		System.setProperty("webdriver.chrome.driver", "D:/temp/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/temp/calcv1.html");
		WebElement e=driver.findElement(By.id("resbut"));
		assertTrue(e != null);
		driver.quit();
	}
	@Test
	public void test_exist_op()
	{
		System.setProperty("webdriver.chrome.driver", "D:/temp/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/temp/calcv1.html");
		WebElement e=driver.findElement(By.id("op"));
		assertTrue(e != null);
		driver.quit();
	}
//==================================================================
	@Test
	public void test_min()
	{
		System.setProperty("webdriver.chrome.driver", "D:/temp/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/temp/calcv1.html");
		driver.findElement(By.id("txt1")).sendKeys("225");
		driver.findElement(By.id("op")).sendKeys("-");
		driver.findElement(By.id("txt2")).sendKeys("2");
		driver.findElement(By.id("resbut")).click();
		String str=driver.findElement(By.id("res")).getAttribute("value");
		assertEquals("223", str);
		driver.quit();
	}
	@Test
	public void test_div()
	{
		System.setProperty("webdriver.chrome.driver", "D:/temp/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/temp/calcv1.html");
		driver.findElement(By.id("txt1")).sendKeys("121");
		driver.findElement(By.id("op")).sendKeys("/");
		driver.findElement(By.id("txt2")).sendKeys("11");
		driver.findElement(By.id("resbut")).click();
		String str=driver.findElement(By.id("res")).getAttribute("value");
		assertEquals("11", str);
		driver.quit();
	}
	@Test
	public void test_mult()
	{
		System.setProperty("webdriver.chrome.driver", "D:/temp/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/temp/calcv1.html");
		driver.findElement(By.id("txt1")).sendKeys("5");
		driver.findElement(By.id("op")).sendKeys("*");
		driver.findElement(By.id("txt2")).sendKeys("15");
		driver.findElement(By.id("resbut")).click();
		String str=driver.findElement(By.id("res")).getAttribute("value");
		assertEquals("75", str);
		driver.quit();
	}
	@Test
	public void test_plus()
	{
		System.setProperty("webdriver.chrome.driver", "D:/temp/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/temp/calcv1.html");
		driver.findElement(By.id("txt1")).sendKeys("22");
		driver.findElement(By.id("op")).sendKeys("+");
		driver.findElement(By.id("txt2")).sendKeys("2");
		driver.findElement(By.id("resbut")).click();
		String str=driver.findElement(By.id("res")).getAttribute("value");
		assertEquals("24", str);
		driver.quit();
	}
	
//==================================================================

}