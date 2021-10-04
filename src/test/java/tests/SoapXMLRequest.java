package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;

public class SoapXMLRequest {

	@Test
	public void validateSopXML() throws IOException {
		
		File file = new File("C:\\Users\\alami\\eclipse-workspace\\RESTAssuredAutomation\\soapRequest\\Add.xml.rtf");
		
		if (file.exists())
			System.out.println("  >> File Exists");
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		baseURI = "http://www.dneonline.com";
		given()
		.contentType("text/xml")
		.accept(ContentType.XML)
		.body(requestBody).
		when().
		post("calculator.asmx").
		then().
		statusCode(200).log().all();
	}
}
