public class ProductSpecification {
	private String id;
	private String name;
	private String description;
	private String price;
	public IManufacturer manufacturer;
	
	
	/*public IManufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(IManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getManufacturerAddress(){
		return manufacturer.getAddress();
	}*/
	public IManufacturer getManufacturer() {
		//ManufacturerProxy manufacturer = new ManufacturerProxy();
		return manufacturer;
	}
	public void setManufacturer(String manu_id) {
		manufacturer = new ManufacturerProxy(manu_id);
		//this.manufacturer = manufacturer;
	}
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
