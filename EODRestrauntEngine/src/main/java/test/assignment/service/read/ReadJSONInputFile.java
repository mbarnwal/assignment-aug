package test.assignment.service.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;

import test.assignment.domain.FoodChainOrderDetail;

public class ReadJSONInputFile implements IReadInputFile {

	private String END_OF_FILE_DELIMITER = "\\Z";

	@Override
	public FoodChainOrderDetail readFile(File file) throws FileNotFoundException {

		Gson gson = new Gson();
		Scanner myScanner = new Scanner(file);
		String contents = myScanner.useDelimiter(END_OF_FILE_DELIMITER).next();
		FoodChainOrderDetail response = gson.fromJson(contents, FoodChainOrderDetail.class);
		return response;
	}

}
