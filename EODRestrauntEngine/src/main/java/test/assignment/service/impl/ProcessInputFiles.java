package test.assignment.service.impl;

import java.util.ArrayList;
import java.util.List;

import test.assignment.domain.Branch;
import test.assignment.domain.FoodChainOrderDetail;
import test.assignment.domain.OrderDetail;
import test.assignment.domain.OutputOrderDetail;
import test.assignment.service.write.WriteJSONOutputFile;

public class ProcessInputFiles {

	public static void processOrders() {

		ReadInputFiles rif = new ReadInputFiles();
		List<OutputOrderDetail> outputOrders = new ArrayList<OutputOrderDetail>();

		List<FoodChainOrderDetail> inputOrders = rif.readInputFiles();
		outputOrders = transformInputToOutput(inputOrders);
		generateOutputFiles(outputOrders);
	}

	private static List<OutputOrderDetail> transformInputToOutput(List<FoodChainOrderDetail> inputOrders) {
		List<OutputOrderDetail> outputOrders = new ArrayList<OutputOrderDetail>();
		for (FoodChainOrderDetail foodChainOrderDetail : inputOrders) {
			float totalCollection = 0;
			for (OrderDetail o : foodChainOrderDetail.getCmfoodchain().getOrders().getOrderDetail()) {
				totalCollection = o.getBillamount() + totalCollection;
			}
			outputOrders
					.add(createOutputOrderDetail(foodChainOrderDetail.getCmfoodchain().getBranch(), totalCollection));
		}
		return outputOrders;
	}

	private static void generateOutputFiles(List<OutputOrderDetail> outputOrders) {
		List<OutputOrderDetail> matchedOrders = new ArrayList<OutputOrderDetail>();
		List<OutputOrderDetail> unmatchedOrders = new ArrayList<OutputOrderDetail>();
		for (OutputOrderDetail order : outputOrders) {

			if (Float.compare(order.getSumOfOrder(), order.getTotalCollection()) == 0) {
				matchedOrders.add(order);
			} else {
				unmatchedOrders.add(order);
			}

		}

		generateOutputFile(matchedOrders, true);
		generateOutputFile(unmatchedOrders, false);

	}

	private static void generateOutputFile(List<OutputOrderDetail> matchedOrders, boolean isMatched) {
		WriteJSONOutputFile.writeFile(matchedOrders, isMatched);
	}

	private static OutputOrderDetail createOutputOrderDetail(Branch branch, float totalCollection) {
		OutputOrderDetail outputOrder = new OutputOrderDetail();
		outputOrder.setLocation(branch.getLocation());
		outputOrder.setLocationId(branch.getLocationid());
		outputOrder.setTotalCollection(branch.getTotalcollection());
		outputOrder.setSumOfOrder(totalCollection);
		return outputOrder;
	}

}
