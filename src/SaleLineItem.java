

public class SaleLineItem {
	private ProductSpecification ps;
	SaleFactory saleFac = new SaleFactory();
	private int quantity;

	public SaleLineItem(String id,int quantity) {
		ps = saleFac.getProduct(id);
		//System.out.println(ps.getId());
		this.quantity = quantity;
	}
	
	public ProductSpecification getPs() {
		return ps;
	}

	public void setPs(ProductSpecification ps) {
		this.ps = ps;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getSubTotal(){
		//System.out.println(ps.getId());
		int price = Integer.parseInt(ps.getPrice());
		return price*quantity;
	}

}