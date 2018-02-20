package com.LocationSearchModule.USZip_Service.operations;

import java.io.File;

import com.LocationSearchModule.USZip_Service.USZip;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetInfoByCity extends USZip{
		public GetInfoByCity() {
			File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/usZipPersonal/getInfoByCity/getInfoByCity.xml").getPath());
			setRequestDocument(XMLTools.makeXMLDocument(xml));
			
			//Generate a request from a project xml file
			setOperationName("GetInfoByCity");
			//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetInfoByCity")));
			removeComments();
			removeWhiteSpace();
		}
		
		public void setState(String value) {
			setRequestNodeValueByXPath("/Envelope/Body/GetInfoByCity/USCity", value);
		}
		
		public int getNumberOfResults() {
			return getNumberOfResponseNodesByXPath("/Envelope/Body/GetInfoByCityResponse/GetInfoByCityResult/NewDataSet/Table");
		}
}