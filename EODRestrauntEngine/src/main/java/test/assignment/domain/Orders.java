package test.assignment.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {

	private List<OrderDetail> orderdetail = new ArrayList<OrderDetail>();

	public List<OrderDetail> getOrderDetail() {
		return orderdetail;
	}

	public void setOrderDetail(List<OrderDetail> orderdetail) {
		this.orderdetail = orderdetail;
	}

	@Override
	public String toString() {
		return "Orders [orderdetail = " + orderdetail + "]";
	}
}
