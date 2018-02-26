package com.LocationSearchModule.SampleWeb_Service.operations;

import java.io.File;

import com.LocationSearchModule.SampleWeb_Service.SampleWeb;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class HelloWorld extends SampleWeb{

	public HelloWorld() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/SampleWeb/helloWorld/helloWorld.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("HelloWorld");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("HelloWorld")));
		removeComments() ;
		removeWhiteSpace();
		}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("/Envelope/Body/HelloWorldResponse/HelloWorldResult");
		}
}
