package test.assignment.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import test.assignment.domain.FoodChainOrderDetail;
import test.assignment.service.read.ReadFileStrategy;
import test.assignment.service.read.ReadJSONInputFile;
import test.assignment.service.read.ReadXMLInputFile;
import test.assignment.util.AssignmentUtil;

public class ReadInputFiles {

	private final static Logger LOGGER = Logger.getLogger(ReadInputFiles.class.getName());
	private static final String JSON_FILE_EXTENSION = "json";
	private static final String XML_FILE_EXTENSION = "xml";

	public List<FoodChainOrderDetail> readInputFiles() {
		List<File> listOfFiles = AssignmentUtil.listFilesForFolder();
		List<FoodChainOrderDetail> orderDetails = new ArrayList<FoodChainOrderDetail>();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				if (getFileExtension(file).equals(JSON_FILE_EXTENSION)) {
					ReadFileStrategy read = new ReadFileStrategy(new ReadJSONInputFile());
					try {
						orderDetails.add(read.readStrategy(file));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (getFileExtension(file).equals(XML_FILE_EXTENSION)) {
					ReadFileStrategy read = new ReadFileStrategy(new ReadXMLInputFile());
					try {
						orderDetails.add(read.readStrategy(file));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					LOGGER.log(Level.WARNING, "Unkown File Type");
				}
			}
		}
		return orderDetails;
	}

	private String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}
}
