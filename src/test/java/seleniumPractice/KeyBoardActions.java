package seleniumPractice;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class KeyBoardActions {

	static WebDriver driver = null;


	static {
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://google.com");
		//driver.get("http://demo.guru99.com/test/guru99home/");

	}


	public static void main(String[] args) {

		try {

			//robot ();
			//actionsExample();
			clicks();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	public static void actionsExample()
	{
		driver.findElement(By.name("q")).sendKeys("hello world"+Keys.ENTER);


		Actions action = new Actions(driver);

		WebElement search = driver.findElement(By.name("q"));
		search.clear();

		action.keyDown(Keys.SHIFT).sendKeys(search,"selenium").keyUp(Keys.SHIFT).sendKeys(" classes").perform(); 

		Action keydown = action.keyDown(Keys.CONTROL).sendKeys("a").build();
		keydown.perform();

	}


	public static void robot() throws InterruptedException, AWTException {


		driver.get("https://www.edureka.co");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Courses")).click();

		//Thread.sleep(10000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_KP_DOWN);
		Thread.sleep(6000);
		robot.mouseMove(30,100);


	}

	public static void clicks() {

		WebElement searchBtn = driver.findElement(By.linkText("Sign in"));

		Actions action = new Actions(driver);

		action.clickAndHold(searchBtn).build().perform();

		//Java Script Executor 
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", searchBtn);

	}

}
