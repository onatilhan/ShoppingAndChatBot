/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bothandler;

import java.util.ArrayList;

public class SenticOperations {
    
    private AverageStrategy strateji;
    
        public SenticOperations(AverageStrategy strateji)
        {
            this.strateji = strateji;
        }
 
        public double computePolarity(double polarity,ArrayList<String> comments)
        {
            polarity=this.strateji.computePolarity(polarity, comments);
            return polarity;
        }
    
}
