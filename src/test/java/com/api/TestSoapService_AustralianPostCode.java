package com.api;

import org.testng.annotations.Test;

import com.orasi.utils.Constants;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.LocationSearchModule.AustralianPostCode_Service.operations.GetAustralianLocationByPostCode;
import com.LocationSearchModule.AustralianPostCode_Service.operations.GetAustralianPostCodeByLocation;

public class TestSoapService_AustralianPostCode extends TestEnvironment{
	
	private String excelFileLocation = Constants.EXCEL_SHEETS + "/AustralianPostCode";	//<-Excel File Location??
	@Test
	public void GetAustralianLocationByPostCode() {
		GetAustralianLocationByPostCode getInfo = new GetAustralianLocationByPostCode();
		getInfo.setPostCode("NSW");
		getInfo.sendRequest();
		getInfo.fix();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetAustralianLocationByPostCode/AustralianLocationByPostCode.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void GetAustralianPostCodeByLocation() {
		GetAustralianPostCodeByLocation getInfo = new GetAustralianPostCodeByLocation();
		getInfo.setLocation("Ravenswood");
		getInfo.sendRequest();
		getInfo.fix();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetAustralianPostCodeByLocation/AustralianPostCodeByLocation.xlsx", "Main"), "Validate Response");
	}
}
