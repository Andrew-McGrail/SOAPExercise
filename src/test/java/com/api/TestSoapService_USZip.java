package com.api;						// TestNG java file

import org.testng.annotations.Test;

import com.orasi.utils.Constants;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.webservicex.locationSearch.usZip.operations.GetInfoByAreaCode;
import com.webservicex.locationSearch.usZip.operations.GetInfoByCity;
import com.webservicex.locationSearch.usZip.operations.GetInfoByState;
import com.webservicex.locationSearch.usZip.operations.GetInfoByZip;

public class TestSoapService_USZip extends TestEnvironment{
	
	private String excelFileLocation = Constants.EXCEL_SHEETS + "/usZip";	//<-Excel File Location??
	@Test
	public void getInfoByAreaCode() {
		GetInfoByAreaCode getInfo = new GetInfoByAreaCode();
		getInfo.setAreaCode("704");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetInfoByAreaCode/USAreaCode.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void getInfoByCity() {
		GetInfoByCity getInfo = new GetInfoByCity();
		getInfo.setCity("Mooresville");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetInfoByCity/USCity.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void getInfoByState() {
		GetInfoByState getInfo = new GetInfoByState();
		getInfo.setState("NC");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetInfoByState/USState.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void getInfoByZip() {
		GetInfoByZip getInfo = new GetInfoByZip();
		getInfo.setZip("28117");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetInfoByZip/USZip.xlsx", "Main"), "Validate Response");
	}
}
