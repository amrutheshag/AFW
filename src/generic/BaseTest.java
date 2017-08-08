package generic;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

 public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	
		@BeforeSuite
		public void initDriver(){
			System.setProperty(CHROME_KEY,CHROME_VALUE);
			System.setProperty(GECKO_KEY, GECKO_VALUE);
		}
	
		@Parameters({"node","browser"})
		@BeforeMethod
		public void openApplication(String node,String browser) throws Exception{
			URL whichSystem=new URL(node);
			DesiredCapabilities whichBrowser=new DesiredCapabilities();
			whichBrowser.setBrowserName(browser);
			driver=new RemoteWebDriver(whichSystem,whichBrowser);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("http://localhost/login.do");
		}
		//--------------------------------------------------------------------
		@AfterMethod
		public void closeApplication(){
			driver.quit();
		}
}







