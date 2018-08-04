package test.assignment.service.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;

import test.assignment.domain.FoodChainOrderDetail;

public class ReadXMLInputFile implements IReadInputFile {

	private String END_OF_FILE_DELIMITER = "\\Z";

	@Override
	public FoodChainOrderDetail readFile(File file) throws FileNotFoundException {

		Gson gson = new Gson();
		Scanner myScanner = new Scanner(file);
		String contents = myScanner.useDelimiter(END_OF_FILE_DELIMITER).next();
		JSONObject xmlJSONObj = XML.toJSONObject(contents);
		String jsonPrettyPrintString = xmlJSONObj.toString();
		FoodChainOrderDetail response = gson.fromJson(jsonPrettyPrintString, FoodChainOrderDetail.class);

		return response;
	}

}
