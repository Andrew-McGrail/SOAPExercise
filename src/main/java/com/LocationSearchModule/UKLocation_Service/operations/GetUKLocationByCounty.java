package com.LocationSearchModule.UKLocation_Service.operations;

import java.io.File;

import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetUKLocationByCounty extends UKLocation{
	public GetUKLocationByCounty() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/UKLocation/getUKLocationByCounty/getUKLocationByCounty.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("GetUKLocationByCounty");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetUKLocationByCounty")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setCounty(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByCounty/County", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/NewDataSet/Table");				// <-- CDATA screwed this up.
	}
	
	public void fix() {
		// Recreate the XML after accessing the CDATA
        String rawResponse = "";
        try {
            rawResponse = getResponseNodeValueByXPath("/Envelope/Body/GetUKLocationByCountyResponse/GetUKLocationByCountyResult");
        } catch (Exception e) {}
        
        if(!rawResponse.isEmpty())
            setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
	}
}