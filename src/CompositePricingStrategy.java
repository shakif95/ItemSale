import java.util.LinkedList;

public class CompositePricingStrategy implements IsalePricingStrategy{

	static enum choice {BestForStore,BestForCustomer}
	
	boolean flag = true;  
	
	
	
	public void add(IsalePricingStrategy ips){
		list.add(ips);
	}
	
	public void remove(IsalePricingStrategy ips){
		list.remove(ips);
	}
	
	public boolean isEmpty(){
		return list.size()==0;
	}
	
	public void setChoice(choice ch){
		if(ch.equals(choice.BestForStore)){
			flag = true;
		}
		if(ch.equals(choice.BestForCustomer)){
			flag = false;
		}
		
	}
	
	@Override
	public int getTotal(Sale sale) {
		BestForStore store;
		BestForCustomer customer;
		
		if(flag){
			store = new BestForStore();
			return store.getTotal(sale);
		}
		else{
			customer = new BestForCustomer();
			return customer.getTotal(sale);
		}
		
		
	}
	
}
