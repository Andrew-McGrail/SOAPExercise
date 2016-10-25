package com.webservicex.loadXmlWithXmlTemplate;

import org.testng.annotations.Test;

import com.orasi.utils.Randomness;
import com.orasi.utils.TestReporter;
import com.webservicex.genericBarCode.operations.GenerateBarCode;


public class TestSoapService {

    @Test
    public void makeBarGenericBarCode(){
	GenerateBarCode generate = new GenerateBarCode();
	generate.sendRequest();
	System.out.println(generate.getBarCodeBytes());
	TestReporter.logAPI(generate.getBarCodeBytes() != "", "Generated byte string for barcode", generate);
	generate.generateBarCodeImage();
    }
        
    @Test
    public void makeBarCode_FontSize(){
	GenerateBarCode generate = new GenerateBarCode();
	generate.setFontSize("14");
	generate.sendRequest();
	System.out.println(generate.getBarCodeBytes());
	TestReporter.logAPI(generate.getBarCodeBytes() != "", "Generated byte string for barcode", generate);
	generate.generateBarCodeImage();
    }

    @Test
    public void makeBarCode_DisplayText(){
	GenerateBarCode generate = new GenerateBarCode();
	generate.setBarCodeText(Randomness.randomNumber(12));
	generate.sendRequest();
	System.out.println(generate.getBarCodeBytes());
	TestReporter.logAPI(generate.getBarCodeBytes() != "", "Generated byte string for barcode", generate);
	generate.generateBarCodeImage();
    }

    @Test
    public void makeBarCode_DisplayPosition(){
	GenerateBarCode generate = new GenerateBarCode();
	generate.setShowTextPosition("TopCenter");
	generate.sendRequest();
	System.out.println(generate.getBarCodeBytes());
	TestReporter.logAPI(generate.getBarCodeBytes() != "", "Generated byte string for barcode", generate);
	generate.generateBarCodeImage();
    }
}
