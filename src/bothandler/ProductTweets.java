package bothandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;

public class ProductTweets implements Comparable<ProductTweets>, Comparator<ProductTweets> {

    private ArrayList<String> comments;//Herbir ürünün yorumlarının tutulacağı arraylist
    private double polarity = 0;
    private double polarity2 = 0;
    private String hashtag;

    public ProductTweets() {

    }

    public ProductTweets(String hashtag) {
        this.hashtag = hashtag;
        comments = new ArrayList<String>();
    }

    public void setList(ArrayList<String> myList) {//Gelen yorum listesini comments'e atar
        comments.addAll(myList);
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public String getHashtag()//Hashtagin basındaki # işaretini kaldırarak döndürür
    {
        String newString = hashtag.replaceAll("#", "");
        return newString;
    }

    public void setPolarity() {//Polarity'i sıfırlar
        this.polarity = 0;
    }

    public void sentic() {

        SenticOperations senticStratejisi1 = null;
        SenticOperations senticStratejisi2 = null;

        senticStratejisi1 = new SenticOperations(new ArithmeticMean());
        senticStratejisi2 = new SenticOperations(new SpecialMean());

        polarity=senticStratejisi1.computePolarity(polarity, comments);
        
        polarity2=senticStratejisi2.computePolarity(polarity2, comments);

    }

    public void print() {
        for (String item : comments) {
            System.out.println(item);
        }
    }

    @Override
    public int compareTo(ProductTweets other) {//compareTo Override edilir 
        int result = 0;
        if (this.polarity > other.polarity) {//Büyükten küçüğe sıralama istendiği için normalde 1 döndürmesi gereken değer -1 döndürür.
            result = -1;
        } else if (this.polarity < other.polarity) {//Büyükten küçüğe sıralama istendiği için normalde -1 döndürmesi gereken değer 1 döndürür.
            result = 1;
        } else if (this.polarity == other.polarity) {
            result = 0;
        }

        return result;
       
    }

    @Override
    public int compare(ProductTweets p1, ProductTweets p2) {
     
        int result = 0;
        if (p1.polarity2 > p2.polarity2) {//Büyükten küçüğe sıralama istendiği için normalde 1 döndürmesi gereken değer -1 döndürür.
            result = -1;
        } else if (p1.polarity2 < p2.polarity2) {//Büyükten küçüğe sıralama istendiği için normalde -1 döndürmesi gereken değer 1 döndürür.
            result = 1;
        } else if (p1.polarity2 == p2.polarity2) {
            result = 0;
        }

        return result;
    }
    
    /*public static Comparator<ProductTweets> comp = new Comparator<ProductTweets>(){
    public int compare(ProductsTweets p1, ProductTweets p2)
    {
        int result = 0;
        if (p1.polarity2 > p2.polarity2) {//Büyükten küçüğe sıralama istendiği için normalde 1 döndürmesi gereken değer -1 döndürür.
            result = -1;
        } else if (p1.polarity2 < p2.polarity2) {//Büyükten küçüğe sıralama istendiği için normalde -1 döndürmesi gereken değer 1 döndürür.
            result = 1;
        } else if (p1.polarity2 == p2.polarity2) {
            result = 0;
        }
    }
    
    };*/

    @Override
    public String toString() {
        return " Polarity : " + polarity + "\nHashtag : " + hashtag + "\n";
    }

}
