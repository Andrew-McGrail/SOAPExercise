package com.LocationSearchModule.USZip_Service.operations;

import java.io.File;

import com.LocationSearchModule.USZip_Service.USZip;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetInfoByZipCode extends USZip {
		public GetInfoByZipCode() {
			File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/usZipSoap/getInfoByZIP/getInfoByZip.xml").getPath());
			setRequestDocument(XMLTools.makeXMLDocument(xml));
			
			//Generate a request from a project xml file
			setOperationName("GetInfoByZIP");
			//setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetInfoByZIP")));
			removeComments();
			removeWhiteSpace();
		}
		
		public void setZip(String value) {
			setRequestNodeValueByXPath("/Envelope/Body/GetInfoByZIP/USZip", value);
		}
		
		public int getNumberOfResults() {
			return getNumberOfResponseNodesByXPath("/Envelope/Body/GetInfoByZIPReponse/GetInfoByZIPResult/NewDataSet/Table");
		}
}
