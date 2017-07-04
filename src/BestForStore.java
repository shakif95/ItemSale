
public class BestForStore {
	
int getTotal(Sale sale){
		
		int lowestTotal = Integer.MAX_VALUE;
		//CompositePricingStrategy cps = new CompositePricingStrategy();
		int temp;
		for(int i=0;i<CompositePricingStrategy.list.size();i++){
			temp = CompositePricingStrategy.list.get(i).getTotal(sale);
			if(temp<lowestTotal){
				lowestTotal = temp;
			}
		}
		return lowestTotal;
	}
	
	
}
