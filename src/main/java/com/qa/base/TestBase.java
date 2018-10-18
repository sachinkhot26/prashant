package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		try{
			prop=new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver");
			driver=new ChromeDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		
		
	}
	public static void launchUrl(String url){
		String finalUrl="http://"+url;
		driver.get(finalUrl);
	}
	
	public static Object[][] getJSONdata(String JSON_path, String JSON_data ,int JSON_attributes) throws FileNotFoundException, IOException, ParseException
	{
/**		
 * JSON_attributes => like Column in Excel, total column hence total attributes need to provide
 * this is using json simple jar file
 */
		
		Object obj = new JSONParser().parse(new FileReader(JSON_path));
		JSONObject jo = (JSONObject)obj;
		JSONArray js = (JSONArray)jo.get(JSON_data);
		
		Object [][] arr = new String[js.size()][JSON_attributes]; 
		for (int i = 0; i < js.size(); i++) 
		{ 
			JSONObject obj1 = (JSONObject)js.get(i);
			arr[i][0] = String.valueOf(obj1.get("domain"));
			arr[i][1] = String.valueOf(obj1.get("language"));
			//arr[i][2] = String.valueOf(obj1.get("ConPassword"));
		}
		return arr;
	}

}
