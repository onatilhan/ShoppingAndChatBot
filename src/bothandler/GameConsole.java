package bothandler;

public class GameConsole extends Product {
    private String weight;
    private String colour;
    private String storage;
    
    
     public GameConsole(String brand, String model, int pPrice,String weight,
             String colour,String storage ) {
        super(brand, model, pPrice);
        this.weight = weight;
        this.colour = colour;
        this.storage = storage;
    }
     
     public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
    
       @Override
    public String toString() {
        return super.toString() + " WEIGHT : " + weight + " COLOUR : " + colour +
                " STORAGE : " + storage;
    }  
}
