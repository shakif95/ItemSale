import java.io.FileNotFoundException;
import java.io.IOException;




public class ProcessSaleController {
	Sale sale = new Sale();
	
	
	public ProductSpecification getProduct(String id) {
		SaleFactory sf = new SaleFactory();
		return sf.getProduct(id);
	}
	public void makeNewSale(){
		if(!sale.getList().isEmpty()){
			sale.getList().clear();
		}
	}
	
	public SaleLineItem addProduct(String id,int quantity){
		//System.out.println(sale.addSaleLineItem(id, quantity).getPs().getId()+" from controller");
		return sale.addSaleLineItem(id,quantity);
	}
	
	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public int getTotal(){
		return sale.getTotal();
	}
	public int getGrandTotal() throws InstantiationException, IllegalAccessException, ClassNotFoundException, FileNotFoundException, IOException{
		return sale.getGrandTotal();
	}
}
