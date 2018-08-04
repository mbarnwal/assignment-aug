package test.assignment.domain;

public class Branch {

	private String locationid;

	private String location;

	private float totalcollection;

	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getTotalcollection() {
		return totalcollection;
	}

	public void setTotalcollection(float totalcollection) {
		this.totalcollection = totalcollection;
	}

	@Override
	public String toString() {
		return "Branch [locationid = " + locationid + ", location = " + location + ", totalcollection = "
				+ totalcollection + "]";
	}
}
