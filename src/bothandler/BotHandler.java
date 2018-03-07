package bothandler;

import java.awt.event.*;
import java.util.*;
import twitter4j.*;
import twitter4j.conf.*;
import java.io.*;
import java.nio.file.*;
import java.util.logging.Level;
import javax.swing.*;

public class BotHandler extends JFrame {

    static private JTextField txtEnter = new JTextField();
    static private JTextArea txtChat = new JTextArea();
    static private JButton button = new JButton("Get Tweets");
    static private JButton button2 = new JButton("Add Smartphone");
    static private JButton button3 = new JButton("Add Mouse");
    static private JButton button4 = new JButton("Add Computer");
    static private JButton button5 = new JButton("Add Game Console");
    static HashMap<String, Float> hm = new HashMap<String, Float>();//Senticnet dosyasından okuma yapmak için HashMap oluşturulur

    static ArrayList<String> exceptionMessageList = new ArrayList<String>(Arrays.asList("İsteğiniz anlaşılamadı :(", "Lütfen tekrarlar mısınız? :)"));
    static ArrayList<String> greetingsMessageList = new ArrayList<String>(Arrays.asList("Merhaba!", "Selamlar!"));
    static ArrayList<String> goodbyeMessageList = new ArrayList<String>(Arrays.asList("Hoşçakalın", "İyi günler dilerim", "Sevgiler, hoşçakalın.."));
    static ArrayList<String> howAreUMessageList = new ArrayList<String>(Arrays.asList("İyiyim teşekkürler efendim siz nasılsınız?", "Teşekkürler iyiyim sizi sormalı..."));
    static ArrayList<String> helpMessageList = new ArrayList<String>(Arrays.asList("Nasıl yardımcı olabilirim?", "Yardımcı olmamı istediğiniz bir konu var mı?"));
    static ArrayList<Product> productList = new ArrayList<Product>(); // ProductFactory ile üretilen nesnelerin listesi
  
    static ArrayList<ProductTweets> cellPhones = new ArrayList<ProductTweets>();//Telefonların yorumlarının, polarity değerlerinin ve hashtaglerinin tutulduğu arraylist
    static ArrayList<ProductTweets> computers = new ArrayList<ProductTweets>();//Bilgisayarların yorumlarının, polarity değerlerinin ve hashtaglerinin tutulduğu arraylist
    static ArrayList<ProductTweets> mouses = new ArrayList<ProductTweets>();//Mouseların yorumlarının, polarity değerlerinin ve hashtaglerinin tutulduğu arraylist
    static ArrayList<ProductTweets> gameConsoles = new ArrayList<ProductTweets>();//Oyun konsollarının yorumlarının, polarity değerlerinin ve hashtaglerinin tutulduğu arraylist

    public BotHandler() throws FileNotFoundException {

        productList.add(ProductFactory.getProduct("SmartPhone", "Apple", "iphone7", 3999, 12, "Rose Gold", "1334x750", "Ios", 64));//Ürünler listelere eklenir
        productList.add(ProductFactory.getProduct("SmartPhone", "Samsung", "galaxys8plus", 3449, 12, "Black", "2960x1440", "Android", 64));//Ürünler listelere eklenir
        productList.add(ProductFactory.getProduct("SmartPhone", "Lenovo", "lenovop2", 1449, 13, "Gold", "1080x1920", "Android", 32));//Ürünler listelere eklenir
        productList.add(ProductFactory.getProduct("Computer", "Apple", "macbookpro", 13916, "Intel Core i7", 16, "macOS", "Intel® HD Graphics"));
        productList.add(ProductFactory.getProduct("Computer", "Lenovo", "thinkpad", 4395, "Intel Core i7", 8, "Windows 10 Pro", "Nvidia GeForce"));
        productList.add(ProductFactory.getProduct("Computer", "Apple", "macbookair", 5299, "Intel Core i5", 8, "macOS", "Intel® HD Graphics"));
        productList.add(ProductFactory.getProduct("Mouse", "Logitech", "g900", 599, 12000, "Light Grey - Black", "Wired", "145 gr"));
        productList.add(ProductFactory.getProduct("Mouse", "Logitech", "g903", 279, 5000, "Black", "Wired", "80 gr"));
        productList.add(ProductFactory.getProduct("Mouse", "Steelseries", "rival100", 299, 12000, "Black", "Wired", "90 gr"));
        productList.add(ProductFactory.getProduct("GameConsole", "Microsoft", "xboxonex", 2699, "2,3 kg", "Black", "1 TB"));
        productList.add(ProductFactory.getProduct("GameConsole", "Sony", "playstation4", 1039, "2,1 kg", "Gold", "500 GB"));
        productList.add(ProductFactory.getProduct("GameConsole", "Nintendo", "nintendoswitch", 2499, "2,9 kg", "Red-Blue", "1 TB"));


        for (Product item : productList) {
            ProductTweets myObject = new ProductTweets("#" + item.getpModel().toLowerCase());//Hashtag gönderilerek Product tweets nesnesi oluşturulur
            myObject.setList(readFile("#" + item.getpModel().toLowerCase()));//Readfile hashtagi içeren yorumların oldugu listeyi döndürür. setList bunu yorumların oldugu arrayliste atar.
            if (item instanceof SmartPhone) {
                cellPhones.add(myObject);
            } else if (item instanceof Computer) {
                computers.add(myObject);
            } else if (item instanceof Mouse) {
                mouses.add(myObject);
            } else if (item instanceof GameConsole) {
                gameConsoles.add(myObject);
            }
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Bu pencere kapatıldığında program sonlanır
        this.setSize(950, 680);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Java Bot Example");

        txtEnter.setLocation(5, 520);
        txtEnter.setSize(935, 30);
        txtEnter.requestFocusInWindow();

        txtChat.setLocation(5, 5);
        txtChat.setSize(935, 510);
        txtChat.setEditable(false);

        button.setSize(150, 50);
        button2.setSize(150, 50);
        button.setLocation(20, 570);
        button2.setLocation(200, 570);
        button3.setSize(150, 50);
        button3.setLocation(380, 570);
        button4.setSize(150, 50);
        button4.setLocation(560, 570);
        button5.setLocation(740, 570);
        button5.setSize(150, 50);

        this.add(txtEnter);
        this.add(txtChat);
        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);

        hashMap();//Program çalıştırıldığında senticnet4.txt dosyasından kelimeler ve polarity değerleri HashMap'e aktarılır.
    }

    public static void main(String[] args) throws FileNotFoundException {

        new BotHandler();//Bot ile konuşma ekranı oluşturulur.
        computeSentic();//Kelimelerin sentic değerleri hesaplanır

        button.addActionListener(new ActionListener() {//Get Tweets butonuna basıldığında her bir ürün için tweet çekilir ve bu tweetleri dosyaya yazar.
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (Product item : productList) { /****/
                        getTweetWriteFile(item.getpModel());
                    }

                    computeSentic();//Çekilen yeni tweetlerle beraber sentic değeri hesaplanır
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(BotHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        button2.addActionListener(new ActionListener() {//Add Smartphone butonuna basıldığında yeni telefon eklemek için bir sayfa açılır.
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSmartphone newPhone = new AddSmartphone();//AddSmartphone listesi oluşturulur.
                newPhone.setVisible(true);//Ekranda görünür yapılır.
            }
        });

        button3.addActionListener(new ActionListener() {//Add Computer butonuna basıldığında yeni bilgisayar eklemek için sayfa açılır.
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMouse newMouse = new AddMouse();
                newMouse.setVisible(true);
            }
        });

        button4.addActionListener(new ActionListener() {//Add Mouse butonuna basıldığında yeni mouse eklemek için sayfa açılır.
            @Override
            public void actionPerformed(ActionEvent e) {
                AddComputer newComputer = new AddComputer();
                newComputer.setVisible(true);
            }
        });

        button5.addActionListener(new ActionListener() {//Add Game Console butonuna basıldığında yeni oyun konsolu eklmek için sayfa açılır.
            @Override
            public void actionPerformed(ActionEvent e) {
                AddGameConsole newGameConsole = new AddGameConsole();
                newGameConsole.setVisible(true);
            }
        });

        txtEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerText = txtEnter.getText();
                txtChat.append("You : " + customerText + "\n");
                txtEnter.setText("");

                if (customerText.toLowerCase().contains("selam") || customerText.toLowerCase().contains("merhaba")) {//Kullanıcının yazacağı cümlelere göre konuşma buradan ilerler
                    decideRandom(greetingsMessageList);
                } else if (customerText.toLowerCase().equals("teşekkürler")) {
                    decideRandom(goodbyeMessageList);
                } else if (customerText.toLowerCase().contains("ürün seçmek istiyorum") || customerText.toLowerCase().contains("ürün seçeceğim")) {
                    txtChat.append("AI: " + "Lutfen ürünü seçiniz:" + "\n");
                    txtChat.append("AI: " + "1: Cep Telefonu" + "\n");
                    txtChat.append("AI: " + "2: Bilgisayar" + "\n");
                    txtChat.append("AI: " + "3: Mouse" + "\n");
                    txtChat.append("AI: " + "4: Oyun Konsolu" + "\n");
                } else if (customerText.toLowerCase().contains("nasılsınız") || customerText.toLowerCase().contains("nasılsın")) {
                    decideRandom(howAreUMessageList);
                } else if (customerText.toLowerCase().contains("iyiyim") || customerText.toLowerCase().contains("iyiyim teşekkürler")) {
                    decideRandom(helpMessageList);
                } else if (customerText.equals("1")) {
                    txtChat.append("Ürünlerimiz en beğenilenlerden başlayarak sıralanmıştır\n");
                    txtChat.append("1.Sıralama stratejimize dayanarak hazırlanmıştır\n");
                    Collections.sort(cellPhones);//compareTo methoduna göre ürünler polarity değerlerine göre azalan sırada sıralanır
                  
                    for (ProductTweets item1 : cellPhones) {
                        for (Product item2 : productList) {//Ürünün özellikleri bulunur
                            if (item2 instanceof SmartPhone) {
                                if (item1.getHashtag().equals(item2.getpModel())) {
                                    txtChat.append(item2.toString() + "\n");//Ekrana ürün özellikleriyle beraber yazdırılır
                                    break;
                                }
                            }
                        }
                    }
                    txtChat.append("2.Sıralama stratejimize dayanarak hazırlanmıştır\n");
                    Collections.sort(cellPhones, new ProductTweets());
                        for (ProductTweets item1 : cellPhones) {
                        for (Product item2 : productList) {//Ürünün özellikleri bulunur
                            if (item2 instanceof SmartPhone) {
                                if (item1.getHashtag().equals(item2.getpModel())) {
                                    txtChat.append(item2.toString() + "\n");//Ekrana ürün özellikleriyle beraber yazdırılır
                                    break;
                                }
                            }
                        }
                    }
                    
                } else if (customerText.equals("2")) {
                    Collections.sort(computers);//compareTo methoduna göre ürünler polarity değerlerine göre azalan sırada sıralanır  
                    txtChat.append("Ürünlerimiz en beğenilenlerden başlayarak sıralanmıştır\n");
                    txtChat.append("1.Sıralama stratejimize dayanarak hazırlanmıştır\n");
                    for (ProductTweets item1 : computers) {
                        for (Product item2 : productList) {//Ürünün özellikleri bulunur
                            if (item2 instanceof Computer) {
                                if (item1.getHashtag().equals(item2.getpModel())) {
                                    txtChat.append(item2.toString() + "\n");//Ekrana ürün özellikleriyle beraber yazdırılır
                                    break;
                                }
                            }

                        }
                    }
                    
                    Collections.sort(computers, new ProductTweets());//compareTo methoduna göre ürünler polarity değerlerine göre azalan sırada sıralanır
                    txtChat.append("2.Sıralama stratejimize dayanarak hazırlanmıştır\n");
                    for (ProductTweets item1 : computers) {
                        for (Product item2 : productList) {//Ürünün özellikleri bulunur
                            if (item2 instanceof Computer) {
                                if (item1.getHashtag().equals(item2.getpModel())) {
                                    txtChat.append(item2.toString() + "\n");//Ekrana ürün özellikleriyle beraber yazdırılır
                                    break;
                                }
                            }

                        }
                    }
                 
                } else if (customerText.equals("3")) {
                    Collections.sort(mouses);//compareTo methoduna göre ürünler polarity değerlerine göre azalan sırada sıralanır
                    txtChat.append("Ürünlerimiz en beğenilenlerden başlayarak sıralanmıştır\n");
                    txtChat.append("1.Sıralama stratejimize dayanarak hazırlanmıştır\n");

                    for (ProductTweets item1 : mouses) {
                        for (Product item2 : productList) {//Ürünün özellikleri bulunur
                            if (item2 instanceof Mouse) {
                                if (item1.getHashtag().equals(item2.getpModel())) {
                                    txtChat.append(item2.toString() + "\n");//Ekrana ürün özellikleriyle beraber yazdırılır
                                    break;
                                }
                            }
                        }
                    }
                    
                    Collections.sort(mouses,new ProductTweets());//compareTo methoduna göre ürünler polarity değerlerine göre azalan sırada sıralanır
                    txtChat.append("2.Sıralama stratejimize dayanarak hazırlanmıştır\n");

                    for (ProductTweets item1 : mouses) {
                        for (Product item2 : productList) {//Ürünün özellikleri bulunur
                            if (item2 instanceof Mouse) {
                                if (item1.getHashtag().equals(item2.getpModel())) {
                                    txtChat.append(item2.toString() + "\n");//Ekrana ürün özellikleriyle beraber yazdırılır
                                    break;
                                }
                            }
                        }
                    }
                    
                    
                    
                } else if (customerText.equals("4")) {
                    Collections.sort(gameConsoles);//compareTo methoduna göre ürünler polarity değerlerine göre azalan sırada sıralanır
                    txtChat.append("1.Sıralama stratejimize dayanarak hazırlanmıştır\n");
                    for (ProductTweets item1 : gameConsoles) {
                        for (Product item2 : productList) {//Ürünün özellikleri bulunur
                            if (item2 instanceof GameConsole) {
                                if (item1.getHashtag().equals(item2.getpModel())) {
                                    txtChat.append(item2.toString() + "\n");//Ekrana ürün özellikleriyle beraber yazdırılır
                                    break;
                                }
                            }

                        }
                    }
                    
                    Collections.sort(gameConsoles,new ProductTweets());//compareTo methoduna göre ürünler polarity değerlerine göre azalan sırada sıralanır
                    txtChat.append("2.Sıralama stratejimize dayanarak hazırlanmıştır\n");
                    for (ProductTweets item1 : gameConsoles) {
                        for (Product item2 : productList) {//Ürünün özellikleri bulunur
                            if (item2 instanceof GameConsole) {
                                if (item1.getHashtag().equals(item2.getpModel())) {
                                    txtChat.append(item2.toString() + "\n");//Ekrana ürün özellikleriyle beraber yazdırılır
                                    break;
                                }
                            }

                        }
                    }
                } else {
                    decideRandom(exceptionMessageList);//Tanımlanmayan bir string girilirse default ifadelerden rastgele seçilerek ekrana yazdırılır
                }
            }
        });
    }

    static private void decideRandom(ArrayList<String> messageList) {
        int decider = (int) (Math.random() * messageList.size());
        txtChat.append("AI: " + messageList.get(decider) + "\n");
    }

    public static void getTweetWriteFile(String pBrand) throws IOException {
        PrintWriter writer = null;

        ConfigurationBuilder cb = new ConfigurationBuilder();//twittera erişim için gerekli key değerleri burada yazılır
        cb.setOAuthConsumerKey("OdIMJPgkZSistbq3dTLMgMX2v");
        cb.setOAuthConsumerSecret("7zQbqJvIdAZpFoWNRDFVwM9QIONPhQR3UdHKQgjQHB6EXxfpJf");
        cb.setOAuthAccessToken("183352091-R74QO5XQtLnanie5ki4XEtKUexMCQDYcEhI42FQZ");
        cb.setOAuthAccessTokenSecret("Ee4cfy4naVnVyAeodSseHhdu0UYVwY2cIommBqC2Nr5ay");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        Query myQuery = new Query("#" + pBrand).lang("en");//Arama yapılacak hashtag değeri ve tweetin dili belirlenir

        myQuery.setCount(10);
        try {
            QueryResult result;
            result = twitter.search(myQuery);//Result içine sorgu değerleri atanır
            List<Status> tweets = result.getTweets();//Tweetler listeye atılır

            for (Status tweet : tweets) {
                System.out.println("@" + tweet.getUser().getScreenName() + " ------ " + tweet.getText());
                Files.write(Paths.get("myfile.txt"), (tweet.getText().toLowerCase() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);//myfile dosyasına tweetler sıra sıra yazılır
            }

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }

    }

    public static void computeSentic() {//Tüm ürünler için ayrı ayrı sentic değerleri hesaplanır

        for (ProductTweets item : cellPhones) {//cellPhones içindeki tüm ürünler için sentic değeri hesaplanır
            item.setPolarity();
            item.sentic();
        }

        for (ProductTweets item : computers) {//computer içindeki tüm ürünler için sentic değeri hesaplanır
            item.setPolarity();
            item.sentic();
        }

        for (ProductTweets item : mouses) {//mouses içindeki tüm ürünler için sentic değeri hesaplanır
            item.setPolarity();
            item.sentic();
        }

        for (ProductTweets item : gameConsoles) {//gameConsoles içindeki tüm ürünler için sentic değeri hesaplanır
            item.setPolarity();
            item.sentic();
        }

    }

    public static ArrayList<String> readFile(String model) {//Bu fonksiyon ProductTweets tipinde arraylist içinde bulunan ürünlerin her biri için ürünün modeline göre dosyadan yorum arar ve list'e ekler.

        File file = new File("myfile.txt");
        String line;
        ArrayList<String> list = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                if (line.contains(model)) {//Eğer ürünün modeli o satırda yazılmış tweette geçiyorsa list'e ekler
                    list.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(BotHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BotHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static void hashMap() throws FileNotFoundException {//senticnet4.txt'den okunan sentic değerleri ve kelimeler hashmap'e aktarılır 

        String myStr, str;
        Float myPolarity;

        SenticSingleton senticDosyası = SenticSingleton.getInstance();
        try {

            while (senticDosyası.s.hasNext()) { //<3
                myStr = senticDosyası.s.next();//Key değeri string olur, yani kelimenin kendisi key değeridir
                str = senticDosyası.s.next();
                str = "";
                str = senticDosyası.s.next();
                myPolarity = Float.parseFloat(str);//Dosyadan okunan değer floata çevrilir key değeri ile ulaşacağımız value bu değerdir.
                hm.put(myStr, myPolarity);
            }
        } catch (Exception e) {
        }
    }

}
