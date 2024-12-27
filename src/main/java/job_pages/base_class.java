package job_pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base_class {

	public static Properties p;
	public static WebDriver driver;

// creating constructor of base class 
	public base_class() throws IOException {
		// Reading the properties file
		p = new Properties();
		FileInputStream s = new FileInputStream(
				"C:\\Users\\mittal.tannya\\eclipse-workspace1\\job\\src\\main\\java\\config\\config.properties");
		p.load(s);
	}

	public static void initialization() {
		String browserName = p.getProperty("Browser");
		System.out.println(browserName);
		if (browserName.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver.exe",
					"C:\\Users\\mittal.tannya\\eclipse-workspace1\\job\\src\\main\\java\\config\\config.properties");
			driver = new ChromeDriver();
			System.out.println("lanching the URL");
		}

		// System.out.println("lanching the URL");
		// driver.get(p.getProperty("URL"));
		System.out.println("URL IS LAUNCHED");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("URL"));

	}

}
