package co.qa.test;


import java.io.IOException;


import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.base.TestBase;
import com.qa.pages.RegisterPage;

public class RegisterTest extends TestBase {

	RegisterPage registerPage;
	
	
	RegisterTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		registerPage=new RegisterPage();
		
	}
	
	@Test(dataProvider="domainNames")
	
	public void registerTest(String domainName, String language) throws InterruptedException {
		
		System.out.println("domainName===="+domainName);
		launchUrl(domainName);
		registerPage.register();
		Thread.sleep(3000);
		driver.quit();
	}
	
	@DataProvider(name="domainNames")
	public Object[][] passData() throws IOException, ParseException
	{
		return TestBase.getJSONdata("/Users/sachin/Desktop/Eclipse/PrashantWork/domain.json", "domains",2);
		
	}
	

}
