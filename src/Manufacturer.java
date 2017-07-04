
public class Manufacturer implements IManufacturer{

	
	private String address;
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getAddress() {
		return address;
	}
	
	
}
