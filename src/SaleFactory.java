

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;



public class SaleFactory {
	
	
	LinkedList<ProductSpecification> list = new LinkedList<>();
	private static SaleFactory instance = null;
	IVATCalculator vatCalculator;
	SaleJFrame salein = new SaleJFrame();
	
	/*public SaleFactory() {
		items();
	}*/

	/*public void items() {
		String []ID = {"mlk","cht","ch","eg","frc","prg","ly","mfj","bds",
                "sp","rc","te","cof","sgr"};
        String []name = {"Milk","Chocolate","Cheese","Eggs","Fruit cake","Pringles",
                "Lays","Mixed Fruit Jam","Body Spray",
                "Soap","Rice","Tea","Coffee","Suger"};

        String []price = {"100","150","320","10","25","110","65","250","450","35","50","70","180","55"};
        
        for(int i=0;i<ID.length;i++){
            ProductSpecification product = new ProductSpecification();
            product.setId(ID[i]);
            product.setName(name[i]);
            product.setPrice(price[i]);
            list.add(product);
        }
	}*/
	
	public ProductSpecification getProduct(String id){
        ProductSpecification ps = null;
        
        String oid = String.valueOf(id);
        ps = (ProductSpecification) PersistenceFacade.getInstance().get(oid, ProductSpecification.class);
        return ps;
    }

	

	public static synchronized SaleFactory getInstance() {
		
		if(instance==null){
			instance = new SaleFactory();
		}
		return instance;
	}
	
	public IVATCalculator getvatCalculator() throws InstantiationException, IllegalAccessException, ClassNotFoundException, FileNotFoundException, IOException{
		Properties vatInfo = new Properties();
		vatInfo.load(new FileInputStream("D:\\WorkSpace_assignments\\ItemSale2\\resource\\properties.ini"));

		
		if(vatCalculator==null){
			String className = null;
			if(salein.choice.equals("BD"))
				className = vatInfo.getProperty("optionBD");
			else if(salein.choice.equals("Int'l"))
				className = vatInfo.getProperty("option");
			//System.out.println(className);
			vatCalculator  = (IVATCalculator) Class.forName(className).newInstance();
		}
		
		return vatCalculator;
	}
	
	
}
