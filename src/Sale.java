
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.LinkedList;



public class Sale {
	private LinkedList<SaleLineItem> list = new LinkedList<>();
	public LinkedList<PropertyListener> propertyList = new LinkedList<>();
	public IsalePricingStrategy disStrategy = new CompositePricingStrategy();
	
	public LinkedList<SaleLineItem> getList() {
		return list;
	}

	public void setList(LinkedList<SaleLineItem> list) {
		this.list = list;
	}
	
	public SaleLineItem addSaleLineItem(String id,int quantity){
		SaleLineItem sl = new SaleLineItem(id, quantity);
		list.add(sl);
		
		PersistenceFacade.getInstance().put(String.valueOf(sl.getPs().getId()), sl);
		
		return sl;
	}
	
	public int getActualTotal(){
		int total = 0;
        for(int i=0;i<list.size();i++){
        	total += list.get(i).getSubTotal();
        }
        //System.out.println("actual total:"+total);
        return total;
	}
	
	public int getTotal(){
		//CompositePricingStrategy cps = new CompositePricingStrategy();
		
		if(((CompositePricingStrategy) disStrategy).isEmpty()){
			return getActualTotal();
		}
		int x=disStrategy.getTotal(this);
		//System.out.println("after dis total:"+x);
		return x;
	}
	
	public int getGrandTotal() throws InstantiationException, IllegalAccessException, ClassNotFoundException, FileNotFoundException, IOException{
		
        return this.getTotal()+this.getVatAmount();
	}

	private int getVatAmount() throws InstantiationException, IllegalAccessException, ClassNotFoundException, FileNotFoundException, IOException {
		IVATCalculator ivac = SaleFactory.getInstance().getvatCalculator();
		return ivac.getVatAmount(this.getTotal());
	}
	
	public void addProperty(PropertyListener property){
		propertyList.add(property);
	}
	
	public void publish() throws Exception{
		for(int i=0;i<propertyList.size();i++){
			propertyList.get(i).publish();
		}
	}
}
