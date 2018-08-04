package test.assignment.service.write;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.assignment.domain.OutputOrderDetail;
import test.assignment.util.AssignmentUtil;

public class WriteJSONOutputFile {

	private final static Logger LOGGER = Logger.getLogger(WriteJSONOutputFile.class.getName());

	public static void writeFile(List<OutputOrderDetail> matchedOrders, boolean isMatched) {
		String fileName = getFileName(isMatched);
		if (matchedOrders != null && !matchedOrders.isEmpty()) {
			final ObjectMapper mapper = new ObjectMapper();
			try {
				mapper.writeValue(new File(fileName), matchedOrders);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			File file = new File(fileName);
			boolean fileCreated = false;
			try {
				fileCreated = file.createNewFile();
			} catch (IOException ioe) {
				LOGGER.log(Level.WARNING, "Error while creating a new empty file :" + ioe);
			}
		}
	}

	private static String getFileName(boolean isMatched) {
		return AssignmentUtil.getOutputFileName(isMatched);
	}

}
