package test.assignment.service.read;

import java.io.File;
import java.io.FileNotFoundException;

import test.assignment.domain.FoodChainOrderDetail;

public interface IReadInputFile {

	public FoodChainOrderDetail readFile(File file) throws FileNotFoundException;
}
