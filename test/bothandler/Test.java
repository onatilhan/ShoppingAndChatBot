package bothandler;

import java.io.FileNotFoundException;
import junit.framework.*;

public class Test extends TestCase {
     
    public void testIphone() throws FileNotFoundException {

        BotHandler newBot = new BotHandler();
        int count = newBot.cellPhones.size();
        assertEquals(count, 3);
    }
    
    public void testIphoneCount() throws FileNotFoundException {
        BotHandler newBot = new BotHandler();
        ProductTweets myPhone = newBot.cellPhones.get(0);
        assertEquals(myPhone.getHashtag(), "iphone7");

    }
}
