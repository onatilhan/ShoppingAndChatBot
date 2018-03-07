package bothandler;


public class ProductFactory {
    
    public static Product getProduct(String type,String pBrand, String pModel, int pPrice, String processor, 
            int ram, String os, String gCard){
        
		if("Computer".equalsIgnoreCase(type))
                   return new Computer(pBrand, pModel, pPrice, processor, ram, os, gCard);
		return null;
	}
    
      public static Product getProduct(String type,String brand, String model, int pPrice, int cameraSize,
            String colorStr, String resolution, String os, int storage){
        
		if("SmartPhone".equalsIgnoreCase(type))
                   return new SmartPhone(brand,  model,  pPrice,  cameraSize,
             colorStr,  resolution,os,  storage);
		return null;
	}
      
       public static Product getProduct(String type,String pBrand, String pModel, int pPrice, int dpi, 
               String colour, String connectivity, String weight){
        
		if("Mouse".equalsIgnoreCase(type))
                   return new Mouse(pBrand, pModel, pPrice, dpi, colour, connectivity, weight);
		return null;
	}
       
       public static Product getProduct(String type,String brand, String model, int pPrice,String weight,
             String colour,String storage){
        
		if("GameConsole".equalsIgnoreCase(type))
                   return new GameConsole(brand, model, pPrice, weight,
             colour,storage);
		return null;
	}
}
