package bothandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SenticSingleton {
    
       Scanner s = null;
       
    private SenticSingleton() throws FileNotFoundException{
            s = new Scanner(new BufferedReader(new FileReader("senticnet4.txt")));
    }
    
     private static SenticSingleton instance = null;
     
      public static SenticSingleton getInstance() throws FileNotFoundException{
          if(instance==null)
          {
              instance= new SenticSingleton();
          }
        return instance;
     }
}
