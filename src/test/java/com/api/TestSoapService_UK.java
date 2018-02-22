package com.api;

import org.testng.annotations.Test;

import com.orasi.utils.Constants;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.LocationSearchModule.UKLocation_Service.operations.GetUKLocationByCounty;
import com.LocationSearchModule.UKLocation_Service.operations.GetUKLocationByPostCode;
import com.LocationSearchModule.UKLocation_Service.operations.GetUKLocationByTown;
import com.LocationSearchModule.UKLocation_Service.operations.ValidateUKAddress;

public class TestSoapService_UK extends TestEnvironment{
	
	private String excelFileLocation = Constants.EXCEL_SHEETS + "/UKLocation";	//<-Excel File Location??
	@Test
	public void getUKLocationByCounty() {
		GetUKLocationByCounty getInfo = new GetUKLocationByCounty();
		getInfo.setCounty("Hampshire");
		getInfo.sendRequest();
		getInfo.fix();
		getInfo.fix();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetUKLocationByCounty/UKCounty.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void getUKLocationByPostCode() {
		GetUKLocationByPostCode getInfo = new GetUKLocationByPostCode();
		getInfo.setPostCode("SO21");
		getInfo.sendRequest();
		getInfo.fix();
		getInfo.fix();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetUKLocationByPostCode/UKPostCode.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void getUKLocationByTown() {
		GetUKLocationByTown getInfo = new GetUKLocationByTown();
		getInfo.setTown("Shawford");
		getInfo.sendRequest();
		getInfo.fix();
		getInfo.fix();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetUKLocationByTown/UKTown.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void validateUKAddress() {
		ValidateUKAddress getInfo = new ValidateUKAddress();
		getInfo.setTown("Shawford");
		getInfo.setCounty("Hampshire");
		getInfo.setPostCode("SO21");
		getInfo.sendRequest();
		getInfo.fix();
		getInfo.fix();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/ValidateUKAddress/UKValidate.xlsx", "Main"), "Validate Response");
	}			
}