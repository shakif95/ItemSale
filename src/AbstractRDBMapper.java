import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractRDBMapper extends AbstractPersistenceMapper{
	String table;
	ResultSet DBStorage;
	DBConnect db;
	Statement st;
	
	public AbstractRDBMapper(String table){
		this.table=table;
		db = new DBConnect();
	}
	
	private ResultSet getDBResult(String oid){
		String id = oid;
		//System.out.println("table "+table+"\noid "+id);
		try {
			st = (Statement)db.conn.createStatement();
			DBStorage = st.executeQuery("select * from "+table+" where oid = '"+id+"'");
		} catch (SQLException e) {
			System.out.println("sql error");
		}
		return DBStorage;
	}
	
	@Override
	protected Object getObjectFromStorage(String oid) {
		DBStorage = getDBResult(oid);
		return getObjectFromRecord(oid, DBStorage);
	}
	
	@Override
	protected abstract void putObjectInStorage(String oid,Object object);
	protected abstract Object getObjectFromRecord(String oid,ResultSet DBStorage);
	
	
}
