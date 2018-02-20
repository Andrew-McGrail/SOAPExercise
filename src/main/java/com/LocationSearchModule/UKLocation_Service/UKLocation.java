package com.LocationSearchModule.UKLocation_Service;

import com.orasi.api.soapServices.SoapService;

public class UKLocation extends SoapService {
	
	public UKLocation() {
		setServiceName("UKLocationService");
		setServiceURL("http://www.webservicex.net/uklocation.asmx?WSDL");
	}
}
