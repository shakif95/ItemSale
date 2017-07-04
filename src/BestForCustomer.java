
public class BestForCustomer {
	
	
	int getTotal(Sale sale){
		int maximumTotal = 0;
		CompositePricingStrategy cps =(CompositePricingStrategy) sale.disStrategy;
		int temp;
		for(int i=0;i<CompositePricingStrategy.list.size();i++){
			temp = CompositePricingStrategy.list.get(i).getTotal(sale);
			if(temp>maximumTotal){
				maximumTotal = temp;
			}
		}
		return maximumTotal;
	}
	
	
}
