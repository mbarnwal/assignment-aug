package test.assignment.service.read;

import java.io.File;
import java.io.IOException;

import test.assignment.domain.FoodChainOrderDetail;

public class ReadFileStrategy {

	private IReadInputFile readInputFile;

	public ReadFileStrategy(IReadInputFile readInputFile) {
		this.readInputFile = readInputFile;
	}

	public FoodChainOrderDetail readStrategy(File file) throws IOException {
		return readInputFile.readFile(file);
	}

}
