package com.actitime.test;

import org.testng.annotations.Test;

import com.actitime.page.EnterTimeTrackPage;
import com.actitime.page.LoginPage;

import generic.BaseTest;
import generic.Excel;

public class ValidLogin extends BaseTest
{
	@Test(priority=1)
	public void testValidLogin(){
		String un=Excel.getCellValue(XLPATH,"ValidLogin",1,0);
		String pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1);
		String HP=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
		
		LoginPage l=new LoginPage(driver);
		l.enterUserName(un);
		l.enterPassword(pw);
		l.clickLogin();
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(HP);
	}
}





