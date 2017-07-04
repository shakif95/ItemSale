
public class PercentageDiscountPricingStrategy implements IsalePricingStrategy{
	//float percentage  = 0.1f;

	@Override
	public int getTotal(Sale sale) {
		return (int) (sale.getActualTotal()-(sale.getActualTotal()*.1));
	}
}
