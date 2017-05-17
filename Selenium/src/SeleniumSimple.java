import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSimple 
{
	@Test
	public void test_1()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn1")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("1", str);
		  driver.quit();
	}
	@Test
	public void test_2()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn2")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("2", str);
		  driver.quit();
	}
	@Test
	public void test_3()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn3")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("3", str);
		  driver.quit();
	}
	@Test
	public void test_4()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn4")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("4", str);
		  driver.quit();
	}
	@Test
	public void test_5()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn5")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("5", str);
		  driver.quit();
	}
	@Test
	public void test_6()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn6")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("6", str);
		  driver.quit();
	}
	@Test
	public void test_7()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn7")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("7", str);
		  driver.quit();
	}
	@Test
	public void test_8()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn8")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("8", str);
		  driver.quit();
	}
	@Test
	public void test_9()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn9")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("9", str);
		  driver.quit();
	}
	@Test
	public void test_0()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn0")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("0", str);
		  driver.quit();
	}
	@Test
	public void test_plus()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btnpl")).click();
		  String str=driver.findElement(By.id("hidOp")).getAttribute("value");
		  assertEquals("+", str);
		  driver.quit();
	}
	@Test
	public void test_minus()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btnmin")).click();
		  String str=driver.findElement(By.id("hidOp")).getAttribute("value");
		  assertEquals("-", str);
		  driver.quit();
	}
	@Test
	public void test_multiply()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btnmult")).click();
		  String str=driver.findElement(By.id("hidOp")).getAttribute("value");
		  assertEquals("*", str);
		  driver.quit();
	}
	@Test
	public void test_divide()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btndiv")).click();
		  String str=driver.findElement(By.id("hidOp")).getAttribute("value");
		  assertEquals("/", str);
		  driver.quit();
	}
	@Test
	public void test_eq()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btneq")).click();
		  String str=driver.findElement(By.id("hidOp")).getAttribute("value");
		  assertEquals("0", str);
		  driver.quit();
	}
	@Test
	public void test_clear()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btnclear")).click();
		  String str=driver.findElement(By.id("hidclear")).getAttribute("value");
		  assertEquals("clear", str);
		  driver.quit();
	}
}
