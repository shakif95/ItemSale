import java.sql.ResultSet;
import java.sql.SQLException;

public class ManufacturerRDBMapper extends AbstractRDBMapper{
	public ManufacturerRDBMapper(String table){
		super(table);
	}

	

	@Override
	protected void putObjectInStorage(String id, Object object) {
		
		
	}

	@Override
	protected Object getObjectFromRecord(String oid, ResultSet DBStorage) {
		//String oid =null;
		String name = null;
		String address = null;
		System.out.println("id "+oid);
		try {
			//System.out.println(DBStorage.next());
			while(DBStorage.next()){
				
				name = DBStorage.getString("name");
				//System.out.println(name);
				address = DBStorage.getString("address");
				//System.out.println(address);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(oid==null){
				return null;
			}
			
			Manufacturer m = new Manufacturer();
			
			m.setName(name);
			m.setAddress(address);
			
			//System.out.println(m.getAddress());
			return m;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void put(String oid, Object object) {
		// TODO Auto-generated method stub
		
	}



}
