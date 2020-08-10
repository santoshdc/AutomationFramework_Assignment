package com.tr.pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tr.utils.BasePageObject;

public class Flipkart_Login extends BasePageObject {
	
	
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;

	public Flipkart_Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By site_Logo =By.xpath(" //img[@class='_1e_EAo']");
	By sign_InBtn =By.xpath("//a[@class='_3Ep39l']");
	By logo_mouse_hover= By.xpath("//img[@class='_1e_EAo']");
	By mobile_Email_TextBox= By.xpath("//input[@class='_2zrpKA _1dBPDZ']");
	By enter_Password_TextBox= By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']");
	By login_Button=By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");
	By login_popContent = By.xpath("//span[contains(text(),'Get access to your Orders, Wishlist and Recommenda')]");
    
	boolean flag=false;
	String pageTitle = null;
	String parentWindo= null;
    String actualResult= null;
    String ExpectedResult = null;
   
    
    public boolean verify_SiteLogo() throws Exception {
    	
    	try {
    		flag =isElementPresent(site_Logo);
    		Assert.assertTrue(flag,"The flipkart site logo is missing");
			
		} catch (Exception e ) {
			// TODO: handle exception
				throw new Exception("Faled to verify the site logo" + "\n verify_SiteLogo " +e.getLocalizedMessage());
		}
		return flag;
    	 	
    }
    
    public void verifyHomePageTitle() throws Exception {
    	try {
    		
    		pageTitle =uiDriver.getTitle().trim();
			Assert.assertEquals(pageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new Exception("Faled to verify the page title" + "\n verifyHomePageTitle " +e.getLocalizedMessage());
		}
    }
    
    public boolean verifySignIn_Button() throws Exception {
    	
    	try {
    		
    		verifySignIn_Button();
    		flag= isElementPresent(sign_InBtn);
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new Exception("FAILED WHILE Verifying the Sign_in Btn FOR USER" +"\n clickOnSignInBtn" +e.getLocalizedMessage());
		};
		return flag;
    	
    }
    
    public void clickOnLoginBtn() {
    	
    	try {
			uiDriver.findElement(login_Button).isDisplayed();
			uiDriver.findElement(login_Button).click();		
		} catch (Exception e) {
			// TODO: handle exception
}
    	  	
    	
    }
    
    public void verifyloginTextConent() {
    	
    	String bodyText = uiDriver.findElement(login_popContent).getText();
    	Assert.assertTrue(bodyText.contains("Get access to your Orders, Wishlist and Recommendations"));
    }
    
    public boolean verifyEmail_MobileTextBox() {
    	try {
    		
    		flag=isElementPresent(mobile_Email_TextBox);
    		Assert.assertTrue(flag,"Email/Mobile text box is missing");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;	
    }
    
    public boolean verifyPasswordTextbox() {
    	
    	try {
			flag= isElementPresent(enter_Password_TextBox);
			Assert.assertTrue(flag,"passwrd text box is missing");
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
    	
    }
    
    public boolean verifySignIn_Btn() {
    	try {
    		
    		flag=isElementChecked(sign_InBtn);
    		Assert.assertTrue(flag,"Sign in clickbale button is missing");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return flag;
    	
    }
    
    public void sendingCredentialForSignIn() { 	
    try {
    	
    	File src=new File("G:\\Automation_Framwork\\AutmationFramwork\\src\\test\\resources\\TestData\\testDataSheet.xlsx");   
   	 // Load the file.
   	 FileInputStream fis = new FileInputStream(src);
   	 workbook = new XSSFWorkbook(fis);
   	 // Load the sheet in which data is stored.
   	 sheet= workbook.getSheetAt(0);
   	 
   	 for(int i=1; i<=sheet.getLastRowNum(); i++){
   		 /*I have added test data in the cell A2 as "email and B2 as "password"
   		 Cell A2 = row 1 and column 0. It reads first row as 0, second row as 1 and so on 
   		 and first column (A) as 0 and second column (B) as 1 and so on*/ 
   		 
   		 // Import data for Email.
   		 cell = sheet.getRow(i).getCell(0);
   		 cell.setCellType(Cell.CELL_TYPE_STRING);
   		 uiDriver.findElement(mobile_Email_TextBox).clear();
   		 uiDriver.findElement(mobile_Email_TextBox).sendKeys(cell.getStringCellValue());
   		 
   		 cell = sheet.getRow(i).getCell(1);
   		 cell.setCellType(Cell.CELL_TYPE_STRING);
   		 uiDriver.findElement(enter_Password_TextBox).clear();
   		 uiDriver.findElement(enter_Password_TextBox).sendKeys(cell.getStringCellValue());
    		
   	 }
    	
	} catch (Exception e) {
		// TODO: handle exception
}
    	
    }
    
    public DashBoard clickSignIn() {
    	uiDriver.findElement(login_Button).isEnabled();
    	uiDriver.findElement(login_Button).click();
		return null;
    }
    
}

