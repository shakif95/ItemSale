

public class BDVATAdapter implements IVATCalculator {
	BDVATCalculator bdcal = new BDVATCalculator();

	@Override
	public int getVatAmount(int saleTotal) {
		
		return (int) bdcal.calculateVATAmount(saleTotal);
	}
	
	
}