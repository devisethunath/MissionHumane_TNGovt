package temp;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CoreFunctions {


	static  {
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
	}
	static  WebDriver driver = new ChromeDriver();
	static {
		driver.get("https://cosmocode.io/automation-practice/");
	}


	public static void main(String[] args) {


		browserCapabilities();
		//waits();
		elementActions();


	}

	private static void browserCapabilities() {

		ChromeOptions chromeOptions = new ChromeOptions();

		// This will make Selenium WebDriver to wait for the entire page is loaded.
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		//This capability checks whether an expired (or) invalid TLS Certificate is used while navigating during a session
		chromeOptions.setAcceptInsecureCerts(true);

		//Specifies when to interrupt an executing script in a current browsing context. The default timeout 30,000 ms
		chromeOptions.setScriptTimeout(Duration.ofSeconds(20));

		//Specifies the time interval in which web page needs to be loaded in a current browsing context. The default timeout 300,000 ms
		chromeOptions.setPageLoadTimeout(Duration.ofSeconds(30));

		//This specifies the time to wait for the implicit element location strategy when locating elements. The default timeout 0 ms
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(10));

		//Adding chrome extensions with webdriver
		//chromeOptions.addExtensions(new F
		ile("/path/to/extension.crx"));

		chromeOptions.addArguments("start-maximized");
		//more capabilities at https://sites.google.com/a/chromium.org/chromedriver/capabilities

		WebDriver driver = new ChromeDriver();

		driver.get("https://cosmocode.io/automation-practice");

		System.out.println("Current title of the page : " + driver.getTitle());
		System.out.println("Current URL of the page : " + driver.getCurrentUrl());

		driver.navigate().to("https://selenium.dev");

		System.out.println("Current title of the page : " + driver.getTitle());
		System.out.println("Current URL of the page : " + driver.getCurrentUrl());

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		System.out.println("Current page source : " + driver.getPageSource());

		driver.manage().deleteAllCookies();

	}//browserCapabilities

	private static void elementActions() {


		List <WebElement> links = driver.findElements(By.linkText("vijayabharathi"));

		if (links.size()>=1) {
			WebElement link = driver.findElement(By.linkText("vijayabharathi"));
			link.click();

		}
		System.out.println("proceeding with next steps");



		WebElement link = driver.findElement(By.linkText("Click here to reload this page"));
		link.click();

		WebElement firstName =driver.findElement(By.id("firstname"));
		firstName.clear();
		firstName.sendKeys("vijayabharathi");

		WebElement LastName =driver.findElement(By.className("lastname"));
		LastName.sendKeys("Karuppasamy");

		String gender = "Still Exploring";

		//WebElement genderElement = driver.findElement(By.xpath("//input[@value='"+gender+"']"));
		//genderElement.click();

		switch (gender) {
		case "Female":
			WebElement Female = driver.findElement(By.xpath("//input[@value='"+gender+"']"));
			Female.click();
			break;
		case "Male":
			WebElement male = driver.findElement(By.xpath("//input[@value='"+gender+"']"));
			male.click();
			break;
		case "Still Exploring":
			WebElement stillExploring = driver.findElement(By.xpath("//input[@value='donotknow']"));
			stillExploring.click();
			break;
		default:
			break;
		}

		String languages = "Java # Python # Vbscript #c #chsarp";
		String [] language = languages.split("#");

		for (String l : language) {

			System.out.println(l.trim());

			if(l.trim().equalsIgnoreCase("java")) {

				WebElement java = driver.findElement(By.xpath("//input[@value='java']"));
				java.click();
			}
			else if (l.trim().equalsIgnoreCase("python")) {

				WebElement python = driver.findElement(By.xpath("//input[@value='python ']"));
				python.click();

			}
			else if (l.trim().equalsIgnoreCase("vbscript")) {

				WebElement vbscript = driver.findElement(By.xpath("//input[@value='vbscript']"));
				vbscript.click();

			}
			else if (l.trim().equalsIgnoreCase("c")) {
				WebElement c = driver.findElement(By.xpath("//input[@value='c']"));
				c.click();
			}
			else {
				WebElement cSharp = driver.findElement(By.xpath("//input[@value='c# ']"));
				cSharp.click();

			}

		}

		WebElement age = driver.findElement(By.name("age"));

		Select ageSelect = new Select(age);

		List <WebElement> selectValues = ageSelect.getOptions();

		for (WebElement s :selectValues ) {
			s.click();

		}

		WebElement submit = driver.findElement(By.id("submit_htmlform"));
		submit.click();	

	}//elementActions

	private static void waits() {

		driver.get("https://google.com/ncr");
		driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);

		// Initialize and wait till element(link) became clickable - timeout in 10 seconds
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		// Print the first result
		System.out.println(firstResult.getText());
		firstResult.click();


		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		WebElement test = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test")));
		WebElement test2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test2")));


	}//Waits






}



