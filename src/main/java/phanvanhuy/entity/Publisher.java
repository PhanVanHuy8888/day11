package phanvanhuy.entity;

public class Publisher {
	private String publisherId;
	private String publisherName;
	private String phone;
	private String address;
	
	public Publisher() {
		
	}
	
	public Publisher(String publisherId, String publisherName, String phone, String address) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.phone = phone;
		this.address = address;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
