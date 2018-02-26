package com.LocationSearchModule.UKLocation_Service.operations;

import java.io.File;

import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetUKLocationByTown extends UKLocation{
	public GetUKLocationByTown() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/UKLocation/getUKLocationByTown/getUKLocationByTown.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("GetUKLocationByTown");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetUKLocationByTown")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setTown(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByTown/Town", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/NewDataSet/Table");
	}
	
	public void fix() {
		// Recreate the XML after accessing the CDATA
        String rawResponse = "";
        try {
            rawResponse = getResponseNodeValueByXPath("/Envelope/Body/GetUKLocationByTownResponse/GetUKLocationByTownResult");
        } catch (Exception e) {}
        
        if(!rawResponse.isEmpty())
            setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
	}
}