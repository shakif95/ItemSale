import java.util.LinkedList;

public interface IVATCalculator {
	public static LinkedList<IsalePricingStrategy> list = new LinkedList<>();
	public int getVatAmount(int saleTotal);
}
