package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import basePackage.BaseClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTestcases extends BaseClass{
	PomLogin Log;
	
	public LoginTestcases() {
		super();
		}
	
	@BeforeMethod
	public void initsetup() {
		initiate();
		//screenshots("Login");
		 Log=new PomLogin();
	}
	
	@Test(priority=1)
	public void Title() {
	
		String actual = Log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual,"OrangeHRM");
	}
	
	
	  @DataProvider 
	  public Object[][] Details() {
	  Object result[][]=ExcelSheet.readdata("Sheet1");
	  return result;
	  }
	 
	  
	  @Test(priority=2, dataProvider="Details")
	  public void Login(String name,String password) { 
	   Log.typeusername(name); 
	   Log.typepassword(password); 
	  // Log.clickloginbutton();
	  }
	 
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
	
