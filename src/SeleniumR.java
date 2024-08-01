import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumR {

	public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
		//UnBroken URL
		String UnBrokenUrl = Driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		
		HttpURLConnection Connection = (HttpURLConnection) new URI(UnBrokenUrl).toURL().openConnection();
		Connection.setRequestMethod("HEAD");
		
		Connection.connect();
		int ResponseCode = Connection.getResponseCode();
		System.out.println(ResponseCode);

		
		//Broken URL
		
		String BrokenUrl = Driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		HttpURLConnection BrokenConnection = (HttpURLConnection) new URI(BrokenUrl).toURL().openConnection();
		BrokenConnection.setRequestMethod("HEAD");
		BrokenConnection.connect();
		int BrokenResponseCode = BrokenConnection.getResponseCode();
		
		System.out.println(BrokenResponseCode);
		
	}

}
