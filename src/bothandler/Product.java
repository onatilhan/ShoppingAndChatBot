 package bothandler;

public class Product{

    private String pBrand;
    private String pModel;
    private int pPrice;

    public Product(String pBrand, String pModel, int pPrice) {
        this.pBrand = pBrand;
        this.pModel = pModel;
        this.pPrice = pPrice;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getpModel(){
        return pModel;
    }

    public void setpModel(String pModel){
        this.pModel = pModel;
    }

    public double getPrice(){
        return pPrice;
    }

    public void setPrice(int pPrice){
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "BRAND : " + this.getpBrand() + ", MODEL : " + this.getpModel() + ", PRICE : " + this.getPrice();
    }
}
