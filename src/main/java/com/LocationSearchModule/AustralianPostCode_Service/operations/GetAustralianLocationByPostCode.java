package com.LocationSearchModule.AustralianPostCode_Service.operations;

import java.io.File;

import com.LocationSearchModule.AustralianPostCode_Service.AustralianPostCode;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetAustralianLocationByPostCode extends AustralianPostCode{
	public GetAustralianLocationByPostCode() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/AustralianPostCode/getAustralianLocationByPostCode/getAustralianLocationByPostCode.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("GetAustralianLocationByPostCode");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetAustralianLocationByPostCode")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setPostCode(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetAustralianLocationByPostCode/PostCode", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/NewDataSet/Table");		// <-- CDATA screws this up.
	}
	
	public void fix() {
		// David's wonder code
        String rawResponse = "";
        try {
            rawResponse = getResponseNodeValueByXPath("/Envelope/Body/GetAustralianLocationByPostCodeResponse/GetAustralianLocationByPostCodeResult");
        } catch (Exception e) {}
        
        if(!rawResponse.isEmpty())
            setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
	}
}