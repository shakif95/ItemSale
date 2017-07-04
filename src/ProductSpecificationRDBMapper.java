import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSpecificationRDBMapper extends AbstractRDBMapper{
	public ProductSpecificationRDBMapper(String table){
		super(table);
	}

	

	@Override
	protected void putObjectInStorage(String id, Object object) {
		
		
	}

	@Override
	protected Object getObjectFromRecord(String oid, ResultSet DBStorage) {
		String name = null;
		String price = null;
		String id = null;
		String manu_id =null;
		
			
		try {
			while(DBStorage.next()){
				id = DBStorage.getString("oid");
				name = DBStorage.getString("name");
				price = DBStorage.getString("price");
				manu_id = DBStorage.getString("manu_id");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(oid==null){
				return null;
			}
			
			ProductSpecification ps = new ProductSpecification();
			
			ps.setId(id);
			ps.setName(name);
			ps.setPrice(price);
			ps.setManufacturer(manu_id);
			//System.out.println("man "+manu_id);
			//System.out.println(ps.getManufacturer().getAddress());
			return ps;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void put(String oid, Object object) {
		// TODO Auto-generated method stub
		
	}



}
