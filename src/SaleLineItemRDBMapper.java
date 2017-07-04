import java.sql.ResultSet;

public class SaleLineItemRDBMapper extends AbstractRDBMapper {
	public SaleLineItemRDBMapper(String table){
		super(table);
	}

	

	@Override
	protected void putObjectInStorage(String oid, Object object) {
		SaleLineItem sli = (SaleLineItem) object;
		
		String subtotal = String.valueOf(sli.getSubTotal());
		String name = String.valueOf(sli.getPs().getName());
		String id = String.valueOf(sli.getPs().getId());
		int quantity = sli.getQuantity();
		//System.out.println("missing");
		try{
			st = db.conn.createStatement();
			st.executeUpdate("insert into "+table+" (oid,name,quantity,subtotal) values('"+id+"','"+name+"',"+quantity+",'"+subtotal+"')");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected Object getObjectFromRecord(String oid, ResultSet DBStorage) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
