package bothandler;

public class Mouse extends Product {

    private int dpi;
    private String colour;
    private String connectivity; //wired wireless
    private String weight;

    public Mouse(String pBrand, String pModel, int pPrice, int dpi, String colour, String connectivity, String weight) {
        super(pBrand, pModel, pPrice);
        this.dpi = dpi;
        this.colour = colour;
        this.connectivity = connectivity;
        this.weight=weight;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public int getDpi() {
        return dpi;
    }

    public String getColourStr() {
        return colour;
    }

    public void setColorStr(String colourStr) {
        this.colour = colourStr;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectiviy(String connectivity) {
        this.connectivity = connectivity;
    }

    public void setWeight(String weight) {
        this.weight=weight;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return super.toString() + " DPI : "+ dpi + " COLOUR : " +
                colour + " WEIGHT : "+ weight+ " CONNECTIVITY : " + 
                connectivity;
    }

}