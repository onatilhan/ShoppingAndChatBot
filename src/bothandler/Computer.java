package bothandler;

public class Computer extends Product {
    private String processor;
    private int ram;
    private String os;
    private String gCard;
    

    public Computer(String pBrand, String pModel, int pPrice, String processor,
            int ram, String os, String gCard) { 
        super(pBrand, pModel, pPrice);
        this.processor=processor;
        this.ram=ram;
        this.os=os;
        this.gCard=gCard;
    }
    
    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRAM() {
        return ram;
    }

    public void setRAM(int ram) {
        this.ram = ram;
    }

    public String getOS() {
        return os;
    }

    public void setOS(String os) {
        this.os = os;
    }

    public String getgCard() {
        return gCard;
    }

    public void setgCard(String gCard) {
        this.gCard = this.gCard;
    }
    
     @Override
    public String toString() {
        return super.toString() + " PROCESSOR : "+ processor + " RAM : " +
                ram + " OPERATING SYSTEM : "+ os+ " GRAPHIC CARD : " + 
                gCard;
    }
}
