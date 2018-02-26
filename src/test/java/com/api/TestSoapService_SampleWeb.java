package com.api;

import org.testng.annotations.Test;

import com.LocationSearchModule.SampleWeb_Service.operations.GetArray;
import com.LocationSearchModule.SampleWeb_Service.operations.GetCurrentTime;
import com.LocationSearchModule.SampleWeb_Service.operations.GetSampleObject;
import com.LocationSearchModule.SampleWeb_Service.operations.GetXmlData;
import com.LocationSearchModule.SampleWeb_Service.operations.HelloWorld;
import com.LocationSearchModule.SampleWeb_Service.operations.SetSampleObject;
import com.orasi.utils.Constants;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;

public class TestSoapService_SampleWeb extends TestEnvironment{
	
	private String excelFileLocation = Constants.EXCEL_SHEETS + "/SampleWeb";
	
	@Test
	public void getArray() {
		GetArray getInfo = new GetArray();
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetArray/GetArray.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void getCurrentTime() {
		GetCurrentTime getInfo = new GetCurrentTime();
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetCurrentTime/GetCurrentTime.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void getSampleObject() {
		GetSampleObject getInfo = new GetSampleObject();
		getInfo.setValue("9");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetSampleObject/GetSampleObject.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void getXmlData() {
		GetXmlData getInfo = new GetXmlData();
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetXmlData/GetXmlData.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void helloWorld() {
		HelloWorld getInfo = new HelloWorld();
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/HelloWorld/HelloWorld.xlsx", "Main"), "Validate Response");
	}
	
	@Test
	public void setSampleObject() {
		SetSampleObject getInfo = new SetSampleObject();
		getInfo.setXValue("5");
		getInfo.setYValue("4");
		getInfo.setName("Andrew");
		getInfo.setInt("1");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() !=0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/SetSampleObject/SetSampleObject.xlsx", "Main"), "Validate Response");
	}
}