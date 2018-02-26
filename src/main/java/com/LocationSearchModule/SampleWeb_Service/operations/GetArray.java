package com.LocationSearchModule.SampleWeb_Service.operations;

import java.io.File;

import com.LocationSearchModule.SampleWeb_Service.SampleWeb;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetArray extends SampleWeb{

	public GetArray() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/SampleWeb/getArray/getArray.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("GetArray");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetInfoByAreaCode")));
		removeComments() ;
		removeWhiteSpace();
		}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("/Envelope/Body/GetArrayResponse/GetArrayResult");
		}
}
