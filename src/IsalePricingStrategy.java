import java.util.LinkedList;

public interface IsalePricingStrategy {
	public LinkedList<IsalePricingStrategy> list = new LinkedList<>();
		public int getTotal(Sale sale);
}
