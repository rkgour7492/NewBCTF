
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galenframework.testng.GalenTestNgTestBase;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;

public class TestMethod extends GalenTestNgTestBase  {
	@Override
	 public WebDriver createDriver(Object[] args) {
		System.setProperty("webdriver.chrome.driver","C:/GITRepo/BCTF/resources/chromedriver.exe");
        return new ChromeDriver();
    }
	
	  @Test
	    public void welcomePage_shouldLookGood_onDesktopDevice() throws IOException {
	        load("https://eag.synechron.com/", 1024, 768);
	        checkLayout("C:/GITRepo/BCTF/specs/homepage.spec", new ArrayList<String>(){/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			{add("mobile");}}); }

/*	public static void main(String args[]) {
		Map<String, Map<String, String>> MapChrome = new HashMap<String, Map<String, String>>();
		Map<String, Map<String, String>> MapIE = new HashMap<String, Map<String, String>>();
		try {
			MapChrome = test1("chrome");
			MapIE = test1("ie");
			
			 * MapDifference<WebElement, Map<String, Integer>> diff =
			 * Maps.difference(MapChrome, MapIE); Map<WebElement,
			 * ValueDifference<Map<String, Integer>>> entriesDiffering =
			 * diff.entriesDiffering();
			 
			System.out.print("================" + MapChrome.equals(MapIE) + "======================");
			System.out.println("========Chrome========" + MapChrome.size() + "======================");
			System.out.println("======IE==========" + MapIE.size() + "======================");
			
			 * System.out.println("======IE==========" + entriesDiffering +
			 * "======================");
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public static Map<String, Map<String, String>> test1(String browser) {

		Map<String, Map<String, String>> finalmap = new HashMap<String, Map<String, String>>();
		List<WebElement> VisibleWebelements = new ArrayList<WebElement>();
		WebDriver driver = null;
		try {
			if (browser.equals("chrome")) {

				String driverpath = "C:/GITRepo/BCTF/resources/chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", driverpath);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://eag.synechron.com");
			} else {
				String driverpath = "C:/GITRepo/BCTF/resources/IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", driverpath);
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.get("https://eag.synechron.com");
			}

			List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
			List<WebElement> inputboxes = driver.findElements(By.xpath("//*[@type]"));
			// List<WebElement> images = driver.findElements(By.tagName("img"));
			List<WebElement> AllWebelements = combineMyLists(inputboxes, links);
			for (WebElement vElements : AllWebelements) {
				if (vElements.isDisplayed()) {
					VisibleWebelements.add(vElements);
				}
			}

			for (WebElement elements : VisibleWebelements) {

				try {
					if (elements.getAttribute("name") != null && !elements.getAttribute("name").isEmpty()) {
						finalmap.put(elements.getAttribute("name"), ElementDetails(elements));
					} else if ( elements.getAttribute("value") != null && !elements.getAttribute("value").isEmpty()) {
						finalmap.put(elements.getAttribute("value"), ElementDetails(elements));
					} else if (elements.getAttribute("title") != null && !elements.getAttribute("title").isEmpty()) {
						finalmap.put(elements.getAttribute("title"), ElementDetails(elements));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// jsonfile(finalmap);
			System.out.println(finalmap);
			System.out.println("***************" + finalmap.size() + "**************");
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalmap;
	}

	public static Map<String, String> ElementDetails(WebElement wb) {
		Map<String, String> eledetails = new HashMap<String, String>();
		Point point = wb.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
		int ht = wb.getSize().height;
		int wd = wb.getSize().width;
		eledetails.put("xcord", Integer.toString(xcord));
		eledetails.put("ycord", Integer.toString(ycord));
		eledetails.put("ht", Integer.toString(ht));
		eledetails.put("wd", Integer.toString(wd));
		return eledetails;
	}

	
	 * public static void jsonfile(Map<WebElement, Map<String, Integer>>
	 * finalmap) { ObjectMapper mapper = new ObjectMapper(); try {
	 * mapper.writeValue(new File("C://Users//ramkumar.gour//result.json"),
	 * finalmap); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 



	public static List<WebElement> combineMyLists(List<WebElement>... args) {
		List<WebElement> combinedList = new ArrayList<>();
		for (List<WebElement> list : args) {
			for (WebElement i : list) {
				combinedList.add(i);
			}
		}
		return combinedList;
	}

	
	 * @AfterTest public void teardown() { driver.close(); }
	 
*/}
