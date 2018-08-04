package test.assignment.EODRestrauntEngine;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import test.assignment.domain.FoodChainOrderDetail;
import test.assignment.service.read.ReadJSONInputFile;
import test.assignment.service.read.ReadXMLInputFile;

public class ProcessInputFilesTest {

	@Test
	public void testJSONReader() {
		ReadJSONInputFile jsonReader = new ReadJSONInputFile();
		File jsonFile = new File("src/test/java/resources/BOM-123-555.json");
		try {
			FoodChainOrderDetail obj = jsonReader.readFile(jsonFile);
			String location = "\"Mumbai\"";
			assertEquals(location, obj.getCmfoodchain().getBranch().getLocation());
			assertEquals(new Float("124.0"), (Float) obj.getCmfoodchain().getBranch().getTotalcollection());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testXMLReader() {
		ReadXMLInputFile xmlReader = new ReadXMLInputFile();
		File jsonFile = new File("src/test/java/resources/BOM-234-88.xml");
		try {
			FoodChainOrderDetail obj = xmlReader.readFile(jsonFile);
			String location = "\"Pune\"";
			assertEquals(location, obj.getCmfoodchain().getBranch().getLocation());
			assertEquals(new Float("111.00"), (Float) obj.getCmfoodchain().getBranch().getTotalcollection());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
