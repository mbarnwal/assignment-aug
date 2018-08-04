package test.assignment.domain;

public class OrderDetail {

	private float billamount;

	private String orderid;

	public float getBillamount() {
		return billamount;
	}

	public void setBillamount(float billamount) {
		this.billamount = billamount;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	@Override
	public String toString() {
		return "OrderDetail [billamount = " + billamount + ", orderid = " + orderid + "]";
	}

}
