package com.LocationSearchModule.SampleWeb_Service.operations;

import java.io.File;

import com.LocationSearchModule.SampleWeb_Service.SampleWeb;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetSampleObject extends SampleWeb{

	public GetSampleObject() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/SampleWeb/getSampleObject/getSampleObject.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("GetSampleObject");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetSampleObject")));
		removeComments() ;
		removeWhiteSpace();
		}
	
	public void setValue(String value){
		setRequestNodeValueByXPath("/Envelope/Body/GetSampleObject/no", value);
		}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("/Envelope/Body/GetSampleObjectResponse/GetSampleObjectResult");
		}
}
