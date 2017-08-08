package com.actitime.test;

import org.testng.annotations.Test;

import com.actitime.page.EnterTimeTrackPage;
import com.actitime.page.LoginPage;

import generic.BaseTest;
import generic.Excel;

public class VerifyBuildVersion extends BaseTest{
	@Test(priority=3)
	public void testBuildVersion(){
		String version=Excel.getCellValue(XLPATH, "VerifyBuildVersion",1,0);
		String un=Excel.getCellValue(XLPATH, "VerifyBuildVersion",1,1);
		String pw=Excel.getCellValue(XLPATH, "VerifyBuildVersion",1,2);
		String buildNum=Excel.getCellValue(XLPATH, "VerifyBuildVersion",1,3);
		LoginPage l=new LoginPage(driver);
		l.verifyVersion(version);
		l.enterUserName(un);
		l.enterPassword(pw);
		l.clickLogin();
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickHelp();
		e.clickAboutActiTIME();
		e.verifyBuildNumber(buildNum);
		e.clickCloseButton();
		e.clickLogout();
	}
}

