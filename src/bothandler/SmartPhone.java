package bothandler;

public class SmartPhone extends Product {

    private String colour;
    private int cameraSize;
    private String resolution;
    private String os;
    private int storage;

    public SmartPhone(String brand, String model, int pPrice, int cameraSize,
            String colorStr, String resolution, String os, int storage) {
        super(brand, model, pPrice);
        this.cameraSize = cameraSize;
        this.colour = colorStr;
        this.resolution = resolution;
        this.os = os;
        this.storage = storage;
    }

    public int getCameraSize() {
        return cameraSize;
    }

    public void setCameraSize(int cameraSize) {
        this.cameraSize = cameraSize;
    }

    public String getColourStr() {
        return colour;
    }

    public void setColorStr(String colourStr) {
        this.colour = colourStr;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getOsStr() {
        return os;
    }

    public void setOsStr(String os) {
        this.os = os;
    }

    public int getStorageStr() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return super.toString() + " CAMERA SIZE : " + cameraSize
                + " COLOUR : " + getColourStr() + " RESOLUTION : " + resolution
                + " OPERATING SYSTEM : " + os + " STORAGE : " + storage ;
    }

}
