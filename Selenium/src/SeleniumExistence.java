import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExistence 
{
	@Test
	public void test_Existence()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn1"));
		  driver.findElement(By.id("btn2"));
		  driver.findElement(By.id("btn3"));
		  driver.findElement(By.id("btn4"));
		  driver.findElement(By.id("btn5"));
		  driver.findElement(By.id("btn6"));
		  driver.findElement(By.id("btn7"));
		  driver.findElement(By.id("btn8"));
		  driver.findElement(By.id("btn9"));
		  driver.findElement(By.id("btn0"));
		  driver.findElement(By.id("btnpl"));
		  driver.findElement(By.id("btnmin"));
		  driver.findElement(By.id("btnmult"));
		  driver.findElement(By.id("btneq"));
		  driver.findElement(By.id("btndiv"));
		  driver.findElement(By.id("txtvvod"));
		  driver.findElement(By.id("btnclear"));	
		  driver.quit();
	}

	/*
	@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Workspace/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("file:///C:/Workspace/calc.html");
		  driver.findElement(By.id("btn4")).click();
		  driver.findElement(By.id("btn5")).click();
		  driver.findElement(By.id("btnpl")).click();
		  driver.findElement(By.id("btn5")).click();
		  driver.findElement(By.id("btn0")).click();
		  driver.findElement(By.id("btneq")).click();
		  String str=driver.findElement(By.id("txtvvod")).getAttribute("value");
		  assertEquals("95", str);
		  driver.quit();
	}
*/

}
