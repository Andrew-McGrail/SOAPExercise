package com.LocationSearchModule.SampleWeb_Service.operations;

import java.io.File;

import com.LocationSearchModule.SampleWeb_Service.SampleWeb;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetCurrentTime extends SampleWeb{

	public GetCurrentTime() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/SampleWeb/getCurrentTime/getCurrentTime.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("GetCurrentTime");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetCurrentTime")));
		removeComments() ;
		removeWhiteSpace();
		}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("/Envelope/Body/GetCurrentTimeResponse/GetCurrentTimeResult");
		}
}
