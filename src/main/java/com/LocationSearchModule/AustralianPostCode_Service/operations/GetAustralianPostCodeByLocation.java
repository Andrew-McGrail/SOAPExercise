package com.LocationSearchModule.AustralianPostCode_Service.operations;

import java.io.File;

import com.LocationSearchModule.AustralianPostCode_Service.AustralianPostCode;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetAustralianPostCodeByLocation extends AustralianPostCode{
	public GetAustralianPostCodeByLocation() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/AustralianPostCode/getAustralianPostCodeByLocation/getAustralianPostCodeByLocation.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("GetAustralianPostCodeByLocation");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetAustralianPostCodeByLocation")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setLocation(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetAustralianPostCodeByLocation/Location", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/NewDataSet/Table");		// <-- CDATA screwed this up.
	}
	
	public void fix() {
		// Recreate the XML after accessing the CDATA
        String rawResponse = "";
        try {
            rawResponse = getResponseNodeValueByXPath("/Envelope/Body/GetAustralianPostCodeByLocationResponse/GetAustralianPostCodeByLocationResult");
        } catch (Exception e) {}
        
        if(!rawResponse.isEmpty())
            setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
	}
}