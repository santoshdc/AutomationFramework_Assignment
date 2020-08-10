package com.tr.test;

import org.testng.annotations.Test;

import com.tr.pages.DashBoard;
import com.tr.utils.BaseTestObject;

public class DashBoardTest extends BaseTestObject {
	
	
	DashBoard objDashBoard;
	
	
	@Test
	public void verifyIsUserLogginFunction() throws Exception {
		try {
			
			objDashBoard = new DashBoard(uiDriver);
			objDashBoard.verifyuserLoggedName();
			objDashBoard.verifySearchPageTitle();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	@Test
	public void vrifyingSerchitemFunction() throws Exception {
		try {
			objDashBoard.itemToSearch();
			objDashBoard.verifySearchPageTitle();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void analysingtoFetchAllrelatedDataFunction() {
		try {
			objDashBoard.FetchAllTheProduct();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	
	public void VerifyingToAddingInCartAndLogOutFunction() {
		try {
			
			objDashBoard.selectAndaddInCart();
			objDashBoard.addIn_Cart();	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
