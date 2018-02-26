package com.LocationSearchModule.SampleWeb_Service.operations;

import java.io.File;

import com.LocationSearchModule.SampleWeb_Service.SampleWeb;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class SetSampleObject extends SampleWeb{

	public SetSampleObject() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/SampleWeb/setSampleObject/setSampleObject.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("SetSampleObject");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("SetSampleObject")));
		removeComments() ;
		removeWhiteSpace();
		}
	
	public void setXValue(String value){
		setRequestNodeValueByXPath("/Envelope/Body/SetSampleObject/obj/X", value);
		}
	
	public void setYValue(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/SetSampleObject/obj/Y", value);
	}
	
	public void setName(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/SetSampleObject/obj/Name", value);
	}
	
	public void setInt(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/SetSampleObject/obj/IntArray/int", value);
	}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("/Envelope/Body/SetSampleObjectResponse/SetSampleObjectResult");
		}
}
