package com.LocationSearchModule.UKLocation_Service.operations;

import java.io.File;

import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetUKLocationByPostCode extends UKLocation{
	public GetUKLocationByPostCode() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/UKLocation/getUKLocationByPostCode/getUKLocationByPostCode.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("GetUKLocationByPostCode");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetUKLocationByPostCode")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setPostCode(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByPostCode/PostCode", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/NewDataSet/Table");
	}
	
	public void fix() {
		// Recreate the XML after accessing the CDATA
        String rawResponse = "";
        try {
            rawResponse = getResponseNodeValueByXPath("/Envelope/Body/GetUKLocationByPostCodeResponse/GetUKLocationByPostCodeResult");
        } catch (Exception e) {}
        
        if(!rawResponse.isEmpty())
            setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
	}
}