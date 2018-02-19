package com.LocationSearchModule.USZip_Service.operations;

import java.io.File;

import com.LocationSearchModule.USZip_Service.USZip;

public class GetInfoByZIP extends USZip {
		public GetInfoByZipCode() {
			File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/usZipSoap/getInfoByZIP/getInfoByZip.xml").getPath());
		}
}
