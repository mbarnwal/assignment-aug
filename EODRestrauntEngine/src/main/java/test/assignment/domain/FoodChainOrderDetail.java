package test.assignment.domain;

public class FoodChainOrderDetail {

	private Cmfoodchain cmfoodchain;

	public Cmfoodchain getCmfoodchain() {
		return cmfoodchain;
	}

	public void setCmfoodchain(Cmfoodchain cmfoodchain) {
		this.cmfoodchain = cmfoodchain;
	}

	@Override
	public String toString() {
		return "FoodChainOrderDetail [cmfoodchain = " + cmfoodchain + "]";
	}

}
