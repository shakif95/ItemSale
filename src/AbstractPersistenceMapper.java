import java.util.HashMap;

public abstract class AbstractPersistenceMapper implements IMapper {
	HashMap<String , Object> cached = new HashMap<String,Object>();
	
	protected abstract Object getObjectFromStorage(String oid);

	protected abstract void putObjectInStorage(String oid,Object object);
	
	
	
	public void put(String oid,Object object){
		this.putObjectInStorage(oid, object);
	}
	
	public final Object get(String oid){
		Object object = cached.get(oid);
		
		if(object==null){
			object = getObjectFromStorage(oid);
		}
		return object;
	}
}
