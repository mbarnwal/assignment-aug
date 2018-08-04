package test.assignment.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AssignmentUtil {

	// TODO move this to properties file
	public static final String INPUT_FILES_LOCATION = "C:\\Work\\input";
	public static final String OUTPUT_MATCHED_FILE = "C:\\Work\\output\\Match.json";
	public static final String OUTPUT_MISMATCHED_FILE = "C:\\Work\\output\\Mismatch.json";

	public static List<File> listFilesForFolder() {

		List<File> listOfFiles = new ArrayList<File>();
		File folder = new File(INPUT_FILES_LOCATION);
		try {
			for (final File fileEntry : folder.listFiles()) {
				listOfFiles.add(fileEntry);
			}
		} catch (Exception io) {
			io.printStackTrace();
		}

		return listOfFiles;
	}

	public static String getOutputFileName(boolean isMatched) {
		String filePath = "";

		if (isMatched) {
			filePath = OUTPUT_MATCHED_FILE;
		} else {
			filePath = OUTPUT_MISMATCHED_FILE;
		}
		return filePath;
	}
}
