package com.LocationSearchModule.SampleWeb_Service;

import com.orasi.api.soapServices.SoapService;

public class SampleWeb extends SoapService {
	
	public SampleWeb() {
		setServiceName("SampleWebService");
		setServiceURL("http://secure.smartbearsoftware.com/samples/testcomplete12/webservices/Service.asmx?wsdl");
	}
}
