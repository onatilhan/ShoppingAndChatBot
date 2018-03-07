package bothandler;

import java.util.ArrayList;

public class ArithmeticMean implements AverageStrategy {
    
    @Override
    public double computePolarity(double polarity,ArrayList<String> comments)
    {   
        for (String oneTweet : comments) {
            String[] words = oneTweet.split("[,\\s-:?!.*\\t#]");//Gelen tweeti burdaki karakterleri gördüğü yerde bölerek bir diziye atar.

            for (int i = 0; i < words.length; i++) {

                if (BotHandler.hm.containsKey(words[i])) {//HashMap'te bu key değeri var mı ona bakılır varsa ifin içine girer
                    polarity += BotHandler.hm.get(words[i]);//Gönderilen key değerinin value'su alınır polarity'e eklenir
                }
            }
        }
        polarity=polarity/comments.size();//Polarity toplam yorum sayısına bölünerek ortalama polarity değeri elde edilir.
        System.out.println(" Polarity :" + polarity);
        return polarity;
    }
    
}
