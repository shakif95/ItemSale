
public class AbsoluteDiscountOverThresholdPricingStrategy implements IsalePricingStrategy{

	@Override
	public int getTotal(Sale sale) {
		return sale.getActualTotal() - 100;
	}
	
}
