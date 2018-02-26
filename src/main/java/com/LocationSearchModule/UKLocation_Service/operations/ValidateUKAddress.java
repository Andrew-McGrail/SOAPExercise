package com.LocationSearchModule.UKLocation_Service.operations;

import java.io.File;

import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class ValidateUKAddress extends UKLocation{
	public ValidateUKAddress() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/UKLocation/validateUKAddress/validateUKAddress.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("ValidateUKAddress");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("ValidateUKAddress")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setTown(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/ValidateUKAddress/Town", value);
	}
	
	public void setCounty(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/ValidateUKAddress/County", value);
	}
	
	public void setPostCode(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/ValidateUKAddress/PostCode", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/NewDataSet/Table");
	}
	
	public void fix() {
		// Recreate the XML after accessing the CDATA
        String rawResponse = "";
        try {
            rawResponse = getResponseNodeValueByXPath("/Envelope/Body/ValidateUKAddressResponse/ValidateUKAddressResult");
        } catch (Exception e) {}
        
        if(!rawResponse.isEmpty())
            setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
	}
}