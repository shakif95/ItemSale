

public class MyVatCalculator implements IVATCalculator{

	@Override
	public int getVatAmount(int saleTotal) {
		return (int) Math.round(saleTotal*0.05);
	}

}
