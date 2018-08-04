package test.assignment.domain;

public class OutputOrderDetail {

	String location;
	String locationId;
	float totalCollection;
	float sumOfOrder;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public float getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(float totalCollection) {
		this.totalCollection = totalCollection;
	}

	public float getSumOfOrder() {
		return sumOfOrder;
	}

	public void setSumOfOrder(float sumOfOrder) {
		this.sumOfOrder = sumOfOrder;
	}

	@Override
	public String toString() {
		return "OutputOrderDetail [location=" + location + ", locationId=" + locationId + ", totalCollection="
				+ totalCollection + ", sumOfOrder=" + sumOfOrder + "]";
	}

}
