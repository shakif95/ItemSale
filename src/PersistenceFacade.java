import java.util.HashMap;

public class PersistenceFacade {
	public static PersistenceFacade instance;
	
	HashMap<Class<?>, IMapper> mappers = new HashMap<Class<?>,IMapper>();
	
	public PersistenceFacade(){
		mappers.put(ProductSpecification.class, new ProductSpecificationRDBMapper("productspecification"));
		mappers.put(SaleLineItem.class, new SaleLineItemRDBMapper("salelineitem"));
		mappers.put(Manufacturer.class, new ManufacturerRDBMapper("manufacturer"));
	}

	public Object get(String oid,Class<?> persistenceClass) {
		IMapper mapper = null;
		mapper = (IMapper)mappers.get(persistenceClass);
		//System.out.println("get "+mapper.get(oid));
		return mapper.get(oid);
	}
	
	public void put(String oid, Object object) {
		IMapper mapper = null;
		mapper = (IMapper)mappers.get(object.getClass());
		mapper.put(oid, object);
	}
	
	public static PersistenceFacade getInstance(){
		if(instance == null){
			instance = new PersistenceFacade();
		}
		return instance;
	}
}
