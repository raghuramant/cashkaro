package org.task.cashkaro;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {
	static WebDriver driver;

	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void registration() {
		driver.get("https://cashkaro.iamsavings.co.uk/join-free-now");
		driver.findElement(By.id("firstname")).sendKeys("myfirstname");
		driver.findElement(By.id("email")).sendKeys("myemail@gmail.com");
		driver.findElement(By.id("con_email")).sendKeys("myemail@gmail.com");
		// driver.findElement(By.id("pwd-txt")).sendKeys("mypassword");

		Actions act = new Actions(driver);
		act.click(driver.findElement(By.id("pwd-txt"))).sendKeys("mypassword").build().perform();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the input value : ");
		int result = scan.nextInt();
		scan.close();
		driver.findElement(By.id("to_be_check")).sendKeys(String.valueOf(result));
		driver.findElement(By.id("join_free_submit")).click();
		driver.quit();

	}

	public static void signin() {
		driver.get("https://cashkaro.iamsavings.co.uk/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("uname")).sendKeys("myemail@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("mypassword");
		driver.findElement(By.id("btnLayoutSignIn")).click();
		driver.quit();
	}

	public static void forgotpassword() throws InterruptedException {
		driver.get("https://cashkaro.iamsavings.co.uk/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("lnkLayoutForgotPassword")).click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.name("from_email")).sendKeys("myemail@gmail.com");
		driver.findElement(By.id("submit_req")).click();
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {

		// browserLaunch();
		// registration();
		// browserLaunch();
		// signin();
		browserLaunch();
		forgotpassword();

	}
}
