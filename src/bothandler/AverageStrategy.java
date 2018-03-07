package bothandler;

import java.util.ArrayList;

public interface AverageStrategy {
    double computePolarity(double polarity,ArrayList<String> comments);  
}
