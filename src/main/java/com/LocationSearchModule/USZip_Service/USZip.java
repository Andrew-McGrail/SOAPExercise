package com.LocationSearchModule.USZip_Service;

import com.orasi.api.soapServices.SoapService;

public class USZip extends SoapService {
	
	public USZip() {
		setServiceName("UsZipService");
		setServiceURL("http://www.webservicex.net/uszip.asmx?wsdl");
	}
}
