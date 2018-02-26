package com.LocationSearchModule.SampleWeb_Service.operations;

import java.io.File;

import com.LocationSearchModule.SampleWeb_Service.SampleWeb;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetXmlData extends SampleWeb{

	public GetXmlData() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/SampleWeb/getXmlData/getXmlData.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		//Generate a request from a project xml file
		setOperationName("GetXmlData");
		//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetXmlData")));
		removeComments() ;
		removeWhiteSpace();
		}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("/Envelope/Body/GetXmlDataResponse/GetXmlDataResult/books");		// Might be x:books instead of books; or it could be books/book
		}
}
