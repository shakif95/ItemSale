
public class ManufacturerProxy implements IManufacturer{
	
	IManufacturer realSubject = null;
	String oid;
	//Manufacturer mf = new Manufacturer();
	public ManufacturerProxy(){
		
	}
	
	public ManufacturerProxy(String oid) {
		this.oid = oid;
	}
	
	public String getOid(){
		return oid;
	}
	
	@Override
	public String getAddress() {
		return getRealSubject().getAddress();
	}
	
	public IManufacturer getRealSubject(){
		if(realSubject==null){
			System.out.println("getOID "+getOid());
			realSubject = (IManufacturer) PersistenceFacade.getInstance().get(getOid(), Manufacturer.class);
		}
		return realSubject;
	}

	@Override
	public String getId() {
		return getRealSubject().getId();
	}

	@Override
	public String getName() {
		return getRealSubject().getName();
	}
}
