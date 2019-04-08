
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;

import com.galenframework.testng.GalenTestNgTestBase;

import Utils.ExcelUtils;


public class InternetExplorerTC extends GalenTestNgTestBase  {
	@Override
	 public WebDriver createDriver(Object[] args) {
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/resources/IEDriverServer.exe");
	        return new InternetExplorerDriver();
    }
	
	@Test(dataProvider="UrlAndResolution")
	    public void welcomePage_shouldLookGood_onDesktopDevice(String url,String width,String height,String specFile) throws IOException {
	        load(url, Integer.parseInt(width), Integer.parseInt(height));
	        checkLayout(System.getProperty("user.dir")+"/specs/"+specFile, null); }


	@DataProvider(name="UrlAndResolution")
	public  Object[][] loginData() throws IOException {
		Object[][] arrayObject = ExcelUtils.getExcelData(System.getProperty("user.dir")+"/resources/dataprovider.xlsx","Sheet1");
		return arrayObject;
	}
	

}


