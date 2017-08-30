package com.actitime.test;

import org.testng.annotations.Test;

import com.actitime.page.LoginPage;

import generic.BaseTest;
import generic.Excel;

public class InvalidLogin extends BaseTest{

	@Test(priority=2)
	public void testInvalidLogin(){

		int rc=Excel.getRowCount(XLPATH, "InvalidLogin");
		
			for(int i=1;i<=rc;i++)
			{
				String un=Excel.getCellValue(XLPATH, "InvalidLogin",i,0);
				String pw=Excel.getCellValue(XLPATH, "InvalidLogin",i,1);
	
				LoginPage l=new LoginPage(driver);
				l.enterUserName(un);
				l.enterPassword(pw);
				l.clickLogin();
				l.verifyErrMsgIsDisplayed();
			}
	 }
}


