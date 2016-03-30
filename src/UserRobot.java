import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.net.ssl.HttpsURLConnection;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by Максим on 26.03.2016.
 */
public class UserRobot {
    HashSet<Character> engSum = new HashSet<Character>();
    HashMap<Character,Character> rusMap;
    HashMap<Character,Integer> engMap;
    HashMap<Point,String> pointToSite;
    ArrayList<String> queries;
    public int timeout = 500;
    public int encode = 0;

    public UserRobot(){
        this.engSum = new HashSet<Character>();
        engSum.add(new Character('a'));
        engSum.add(new Character('b'));
        engSum.add(new Character('c'));
        engSum.add(new Character('d'));
        engSum.add(new Character('e'));
        engSum.add(new Character('f'));
        engSum.add(new Character('g'));
        engSum.add(new Character('h'));
        engSum.add(new Character('i'));
        engSum.add(new Character('j'));
        engSum.add(new Character('k'));
        engSum.add(new Character('l'));
        engSum.add(new Character('m'));
        engSum.add(new Character('n'));
        engSum.add(new Character('o'));
        engSum.add(new Character('p'));
        engSum.add(new Character('q'));
        engSum.add(new Character('r'));
        engSum.add(new Character('s'));
        engSum.add(new Character('t'));
        engSum.add(new Character('u'));
        engSum.add(new Character('v'));
        engSum.add(new Character('w'));
        engSum.add(new Character('x'));
        engSum.add(new Character('y'));
        engSum.add(new Character('z'));
        engSum.add(new Character('A'));
        engSum.add(new Character('B'));
        engSum.add(new Character('C'));
        engSum.add(new Character('D'));
        engSum.add(new Character('E'));
        engSum.add(new Character('F'));
        engSum.add(new Character('G'));
        engSum.add(new Character('H'));
        engSum.add(new Character('I'));
        engSum.add(new Character('J'));
        engSum.add(new Character('K'));
        engSum.add(new Character('L'));
        engSum.add(new Character('M'));
        engSum.add(new Character('N'));
        engSum.add(new Character('O'));
        engSum.add(new Character('P'));
        engSum.add(new Character('Q'));
        engSum.add(new Character('R'));
        engSum.add(new Character('S'));
        engSum.add(new Character('T'));
        engSum.add(new Character('U'));
        engSum.add(new Character('V'));
        engSum.add(new Character('W'));
        engSum.add(new Character('X'));
        engSum.add(new Character('Y'));
        engSum.add(new Character('Z'));
        engSum.add(new Character(' '));

        this.rusMap = new HashMap<Character, Character>();
        rusMap.put('Й','Q');
        rusMap.put('Ц','W');
        rusMap.put('У','E');
        rusMap.put('К','R');
        rusMap.put('Е','T');
        rusMap.put('Н','Y');
        rusMap.put('Г','U');
        rusMap.put('Ш','I');
        rusMap.put('Щ','O');
        rusMap.put('З','P');
        rusMap.put('Х','[');
        rusMap.put('Ъ',']');
        rusMap.put('Ф','A');
        rusMap.put('Ы','S');
        rusMap.put('В','D');
        rusMap.put('А','F');
        rusMap.put('П','G');
        rusMap.put('Р','H');
        rusMap.put('О','J');
        rusMap.put('Л','K');
        rusMap.put('Д','L');
        rusMap.put('Ж',';');
        rusMap.put('Э','\'');
        rusMap.put('Я','Z');
        rusMap.put('Ч','X');
        rusMap.put('С','C');
        rusMap.put('М','V');
        rusMap.put('И','B');
        rusMap.put('Т','N');
        rusMap.put('Ь','M');
        rusMap.put('Б',',');
        rusMap.put('Ю','.');
        rusMap.put('Ё','`');

        this.engMap = new HashMap<Character, Integer>();
        engMap.put('A',65);
        engMap.put('B',66);
        engMap.put('C',67);
        engMap.put('D',68);
        engMap.put('E',69);
        engMap.put('F',70);
        engMap.put('G',71);
        engMap.put('H',72);
        engMap.put('I',73);
        engMap.put('J',74);
        engMap.put('K',75);
        engMap.put('L',76);
        engMap.put('M',77);
        engMap.put('N',78);
        engMap.put('O',79);
        engMap.put('P',80);
        engMap.put('Q',81);
        engMap.put('R',82);
        engMap.put('S',83);
        engMap.put('T',84);
        engMap.put('U',85);
        engMap.put('V',86);
        engMap.put('W',87);
        engMap.put('X',88);
        engMap.put('Y',89);
        engMap.put('Z',90);
    }

    public void changeInput(){
        try {
            Robot r = new Robot();
            r.keyPress(18);
            r.keyPress(16);
            Thread.sleep(5);
            r.keyRelease(16);
            r.keyRelease(18);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void clearHistory(){
        try {
            Robot r = new Robot();
            //openAndTransfer(new Point(561,701));
            newTab();
            sleep(1000);
            openAndTransfer(new Point(180,59));
            sleep(500);
            setClipboard("chrome://settings/clearBrowserData");
            sleep(500);
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            sleep(500);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);
            sleep(1000);

            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            //r.setAutoDelay(500);
            /*
            r.keyPress(KeyEvent.VK_CONTROL);
            sleep(10);
            r.keyPress(KeyEvent.VK_SHIFT);
            sleep(10);
            r.keyPress(KeyEvent.VK_DELETE);
            sleep(500);

            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_SHIFT);
            r.keyRelease(KeyEvent.VK_DELETE);
            */

            sleep(2000);
            //openAndTransfer(new Point(561,688));
            r.keyPress(KeyEvent.VK_TAB);
            sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
            sleep(50);
            r.keyPress(KeyEvent.VK_TAB);
            sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
            sleep(50);
            r.keyPress(KeyEvent.VK_TAB);
            sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
            sleep(50);
            r.keyPress(KeyEvent.VK_TAB);
            sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
            sleep(50);
            r.keyPress(KeyEvent.VK_TAB);
            sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
            sleep(50);
            r.keyPress(KeyEvent.VK_TAB);
            sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
            sleep(50);
            r.keyPress(KeyEvent.VK_TAB);
            sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
            sleep(50);
            r.keyPress(KeyEvent.VK_TAB);
            sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
            sleep(50);
            r.keyPress(KeyEvent.VK_TAB);
            sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
            sleep(50);

            sleep(500);
            closeTab();

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void clearText(){
        try {
            Robot r = new Robot();
            for (int i = 0; i < 50; i++){
                r.keyPress(KeyEvent.VK_DELETE);
                r.keyRelease(KeyEvent.VK_DELETE);
            }
            for (int i = 0; i < 50; i++){
                r.keyPress(KeyEvent.VK_BACK_SPACE);
                r.keyRelease(KeyEvent.VK_BACK_SPACE);
            }
            sleep(1000);
        } catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void closeTab(){
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            sleep(this.timeout);
            r.keyPress(KeyEvent.VK_W);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_W);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public int getCode(char symbol, int code){
        if (code < 0) code = code + 255;
        if (symbol == ' ') return 32;
        try {
            System.out.println(symbol);
            if (this.engMap.containsKey(symbol)){
                return engMap.get(symbol);
            }

            if (this.rusMap.containsKey(symbol)) {

                char[] eng = new char[1];
                eng[0] = this.rusMap.get(symbol);
                String str = new String(eng);
                code = str.getBytes("UTF-8")[0];
                System.out.println(code);
                return code;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public ArrayList<String> getQueries(){
        this.queries = new ArrayList<String>();

        queries.add("MIELE ДИАГНОСТИКА");
        queries.add("MIELE ОФИЦИАЛЬНЫЙ САЙТ РЕМОНТ");
        queries.add("MIELE ОШИБКА ПОДАЧИ ВОДЫ");
        queries.add("MIELE РЕМОНТ");
        queries.add("MIELE РЕМОНТ БЫТОВОЙ ТЕХНИКИ");
        queries.add("MIELE РЕМОНТ МОСКВА");
        queries.add("MIELE СЕРВИС");
        queries.add("MIELE СЕРВИС ЦЕНТР");
        queries.add("MIELE СЕРВИСНЫЙ ЦЕНТР");
        queries.add("MIELE СЕРВИСНЫЙ ЦЕНТР МОСКВА");
        queries.add("MIELE СЛОМАЛАСЬ");
        queries.add("MIELE СРОЧНЫЙ РЕМОНТ");
        queries.add("MIELE СТИРАЛЬНАЯ МАШИНА ЗАПЧАСТИ");
        queries.add("MILELE РЕМОНТ");
        queries.add("SERVICE MIELE");
        queries.add("SERVICE MIELE");
        queries.add("W 3240 MIELE ЗАПЧАСТИ МАНЖЕТ");
        queries.add("WATERPROOF MIELE");
        queries.add("СЕРВИСНАЯ СЛУЖБА МИЕЛЕ");
        queries.add("СЕРВИСНАЯ СЛУЖБА МИЕЛЕ");
        queries.add("ЗАПЧАСТИ MIELE");
        queries.add("ЗАПЧАСТИ MIELE");
        queries.add("ЗАПЧАСТИ MIELE В МОСКВЕ");
        queries.add("ЗАПЧАСТИ MIELE В НАЛИЧИИ");
        queries.add("ЗАПЧАСТИ ДЛЯ MIELE CVA 620");
        queries.add("ЗАПЧАСТИ ДЛЯ MIELE CVA 620 РЕМОНТ");
        queries.add("ЗАПЧАСТИ ДЛЯ МАШИН MIELE");
        queries.add("ЗАПЧАСТИ ДЛЯ СТИРАЛЬНОЙ МАШИНЫ МИЛЕ PW 5065");
        queries.add("ЗАПЧАСТИ ДЛЯ СТИРАЛЬНЫХ МАШИН MIELE");
        queries.add("ЗАПЧАСТИ ДЛЯ СТИРАЛЬНЫХ МАШИН МИЛЕ");
        queries.add("ЗАПЧАСТИ К ПОСУДОМОЕЧНОЙ МАШИНЕ MIELE");
        queries.add("ЗАПЧАСТИ МИЕЛЕ");
        queries.add("ЗАПЧАСТИ МИЛЕ");
        queries.add("ЗАПЧАСТИ МИЛЕ СТИРАЛЬНЫЕ МАШИНЫ");
        queries.add("ЗАПЧАСТИ МИЛИ");
        queries.add("МИЕЛЕ ОФИЦИАЛЬНЫЙ САЙТ СЕРВИС");
        queries.add("МИЕЛЕ РЕМОНТ");
        queries.add("МИЕЛЕ СЕРВИС");
        queries.add("МИЕЛЕ СЕРВИСНЫЙ ЦЕНТР МИЛЕ");
        queries.add("МИЕЛЕ СЛОМАЛАСЬ");
        queries.add("МИЕЛЕ СРОЧНЫЙ РЕМОНТ");
        queries.add("МИЛ СЕРВИС");
        queries.add("МИЛЕ РЕМОНТ");
        queries.add("МИЛЕ СЕРВИС");
        queries.add("МИЛЕ СЕРВИС ЦЕНТР");
        queries.add("МИЛЕ СЕРВИС ЦЕНТР МОСКВА");
        queries.add("МИЛЕ СЕРВИСНЫЙ ЦЕНТР");
        queries.add("МИЛЕ СРОЧНЫЙ РЕМОНТ");
        queries.add("МИЛИ ДИАГНОСТИКА");
        queries.add("МИЛИ РЕМОНТ");
        queries.add("МИЛИ СЕРВИС");
        queries.add("МИЛИ СЛОМАЛАСЬ");
        queries.add("МИЛЛ СЕРВИС");
        queries.add("МИЛЛ СЕРВИС");
        queries.add("МИЛЛИ ДИАГНОСТИКА");
        queries.add("МИЛЛИ СЕРВИСНЫЙ ЦЕНТР");
        queries.add("ОШИБКА WATERPROOF MIELE");
        queries.add("ОШИБКА СЛИВА ВОДЫ MIELE");
        queries.add("ПОДКЛЮЧЕНИЕ СТИРАЛЬНОЙ МАШИНЫ MIELE");
        queries.add("РЕМОНТ MIELE В МОСКВЕ");
        queries.add("РЕМОНТ БЫТОВОЙ ТЕХНИКИ МИЛЕ");
        queries.add("РЕМОНТ ВАРОЧНЫХ ПАНЕЛЕЙ MIELE");
        queries.add("РЕМОНТ ВЫТЯЖЕК MIELE");
        queries.add("РЕМОНТ ВЫТЯЖКИ MIELE");
        queries.add("РЕМОНТ ДУХОВЫХ ШКАФОВ MIELE");
        queries.add("РЕМОНТ КОФЕМАШИН MIELE");
        queries.add("РЕМОНТ МАШИН MIELE");
        queries.add("РЕМОНТ МИЛЛЕ");
        queries.add("РЕМОНТ МИЛЛИ");
        queries.add("РЕМОНТ ПОСУДОМОЕЧНЫХ МАШИН MIELE");
        queries.add("РЕМОНТ ПОСУДОМОЕЧНЫХ МАШИН МИЛЕ");
        queries.add("РЕМОНТ СТИРАЛЬНЫХ МАШИН МИЛЕ");
        queries.add("РЕМОНТ СТИРАЛЬНЫХ МАШИН МИЛИ");
        queries.add("РЕМОНТ СТИРАЛЬНЫХ МАШИН MIELE");
        queries.add("РЕМОНТ СТИРАЛЬНЫХ МАШИН МИЕЛЕ");
        queries.add("РЕМОНТ СУШИЛЬНЫХ МАШИН MIELE");
        queries.add("РЕМОНТ ТЕХНИКИ MIELE");
        queries.add("РЕМОНТ ТЕХНИКИ МИЛЕ");
        queries.add("СЕРВИС MIELE В МОСКВЕ");
        queries.add("СЕРВИС МИЕЛЕ");
        queries.add("СЕРВИС МИЕЛЕ В МОСКВЕ");
        queries.add("СЕРВИС МИЛЕ");
        queries.add("СЕРВИС МИЛЕ В МОСКВЕ");
        queries.add("СЕРВИС МИЛЕ В МОСКВЕ");
        queries.add("СЕРВИС МИЛИ");
        queries.add("СЕРВИС МИЛЛЕ");
        queries.add("СЕРВИС ЦЕНТР MIELE");
        queries.add("СЕРВИС ЦЕНТР MIELE В МОСКВЕ");
        queries.add("СЕРВИС ЦЕНТР МИЛЕ");
        queries.add("СЕРВИС ЦЕНТР МИЛЕ В МОСКВЕ");
        queries.add("СЕРВИСНАЯ СЛУЖБА MIELE");
        queries.add("СЕРВИСНАЯ СЛУЖБА МИЛЛИ");
        queries.add("СЕРВИСНЫЙ ЦЕНТР MIELE МОСКВА");
        queries.add("СТИРАЛЬНАЯ МАШИНА MIELE ОШИБКА WATERPROOF");
        queries.add("СТИРАЛЬНАЯ МАШИНА MIELE ОШИБКА СЛИВ ВОДЫ");
        queries.add("УСТАНОВКА MIELE");
        queries.add("УСТАНОВКА МИЕЛЕ");
        queries.add("УСТАНОВКА МИЛЕ");
        queries.add("УСТАНОВКА МИЛИ");

/*
        ret.add("RESTART ВЫЗВАТЬ");
        ret.add("RESTART РЕМОНТ");
        ret.add("RESTART РЕМОНТ МОСКВА");
        ret.add("RESTART СЕРВИС");
        ret.add("RESTART СЕРВИСНЫЙ ЦЕНТР");
        ret.add("RESTART СРОЧНЫЙ РЕМОНТ");
        ret.add("RESTART ФИРМЕННЫЙ РЕМОНТ");
        ret.add("RESTART ФИРМЕННЫЙ СЕРВИСНЫЙ ЦЕНТР");
        ret.add("РЕСТАРТ МОСКВА");
        ret.add("РЕСТАРТ ОФИЦИАЛЬНЫЙ САЙТ");
        ret.add("РЕСТАРТ ОФИЦИАЛЬНЫЙ СЕРВИС");
        ret.add("РЕСТАРТ ОФИЦИАЛЬНЫЙ СЕРВИСНЫЙ ЦЕНТР");
        ret.add("РЕСТАРТ РЕМОНТ");
        ret.add("РЕСТАРТ САЙТ");
        ret.add("РЕСТАРТ СЕРВИС");
        ret.add("РЕСТАРТ СРОЧНЫЙ РЕМОНТ");
        ret.add("РЕМОНТ ВАРОЧНОЙ ПАНЕЛИ РЕСТАРТ");
        ret.add("РЕМОНТ ВЫТЯЖЕК RESTART");
        ret.add("РЕМОНТ ВЫТЯЖЕК РЕСТАРТ");
        ret.add("РЕМОНТ ПЛИТ RESTART");
        ret.add("РЕМОНТ ПЛИТ РЕСТАРТ");
        ret.add("РЕМОНТ ХОЛОДИЛЬНИКОВ RESTART");
        ret.add("РЕМОНТ ХОЛОДИЛЬНИКОВ РЕСТАРТ");
        */

        /*
        ret.add("RESTART РЕМОНТ");
        ret.add("RESTART СЕРВИС");
        ret.add("РЕМОНТ ВАРОЧНОЙ ПАНЕЛИ RESTART");
        */
        Collections.shuffle(queries);

        return queries;
    }

    public int getRandom(int bound){
        Random r = new Random();
        int ret = r.nextInt(bound);
        return ret;
    }

    public String getRandomString(){
        int size = this.queries.size();
        int index = getRandom(size);
        return queries.get(index);
    }

    public void input(String text){
        try {
            text = text.toUpperCase();
            char[] arr = text.toCharArray();
            byte[] bytes = text.getBytes("UTF-8");
            for (int i = 0; i < text.length(); i++) {
                //String symbol = text.substring(i, i + 1);
                inputSymbol(arr[i],bytes[i]);
                Random r = new Random();
                int pause = r.nextInt(400);
                sleep(pause + 100);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void sleep(int millis){
        Random r = new Random();
        if (millis > 4) millis = millis + r.nextInt(millis/4);
        try {
            Thread.sleep(millis);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void inputChar(int keyPress){
        try {
            Robot r = new Robot();
            r.keyPress(keyPress);
            r.keyRelease(keyPress);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    protected void inputSymbol(char symbol, int code){
        if ((this.rusMap.containsKey(symbol)) && (this.encode == 0)){
            changeInput();
            this.encode = 1;
        }
        if ((!this.rusMap.containsKey(symbol)) && (this.encode != 0)){
            changeInput();
            this.encode = 0;
        }
        int num = getCode(symbol,code);
        inputChar(num);
        //if (this.rusMap.containsKey(symbol)){
        //    changeInput();
        //}
    }



    public void mouse1Press(int x, int y){
        try {
            Robot r = new Robot();
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void mousePress(int x, int y,int key){
        try {
            Robot r = new Robot();
            r.mousePress(key);
            r.mouseRelease(key);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void mouseMove(int x, int y){
        Point location = MouseInfo.getPointerInfo().getLocation();
        int startX = (int)location.getX();
        int startY = (int)location.getY();
        try {
            Robot r = new Robot();
            r.mouseMove(x, y);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void mouseWheel(int length){
        try {
            Robot r = new Robot();
            r.mouseWheel(length);
            //sleep(2000);
            //r.mouseWheel(5);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void newTab(){
        setClipboard("https://yandex.ru/search/?text=");
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            sleep(this.timeout);
            r.keyPress(KeyEvent.VK_T);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_T);
            sleep(2*this.timeout);
            mouseMove(256,60);
            openAndTransfer(new Point(256,60));
            sleep(this.timeout);
            r.keyPress(KeyEvent.VK_CONTROL);
            sleep(this.timeout);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);

            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            sleep(6*this.timeout);

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void open(Point point){
        mouseMove(point.x, point.y);
        sleep(this.timeout);
        mousePress(point.x, point.y, InputEvent.BUTTON3_MASK);
        sleep(this.timeout);
        mouseMove(point.x+10, point.y+10);
        mousePress(point.x+10, point.y+10, InputEvent.BUTTON1_MASK);
    }

    public void openAndTransfer(Point point){
        mouseMove(point.x, point.y);
        sleep(this.timeout);
        mousePress(point.x, point.y, InputEvent.BUTTON1_MASK);
    }

    public ArrayList<Point> getPoints(String query){
        this.pointToSite = new HashMap<Point, String>();
        Point[] points = new Point[4];
        points[0]=new Point(230,206);
        points[1]=new Point(230,332);
        points[2]=new Point(230,455);
        points[3]=new Point(230,580);
        ArrayList<Point> ret = new ArrayList<Point>();
        try {
            String queryText = "https://yandex.ru/search/?text="+query + "&rstr=-1";
            //downloadFiles("https://yandex.ru/search/?text=miele%20aaa%20%D1%80%D0%B5%D0%BC%D0%BE%D0%BD%D1%82%20%D1%81%D1%82%D0%B8%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D1%85%20%D0%BC%D0%B0%D1%88%D0%B8%D0%BD%20miele&lr=213&rstr=-1&rnd=82767","e:/direct.html",100);
            File input = new File("C:\\Users\\Максим\\Downloads\\page.html");
            Document doc = Jsoup.parse(input, "utf8", "http://example.com/");
            System.out.println(doc.text());
            int j = 0;
            for (Element mainDiv : doc.select("div[class=serp-list]")) {
                int i = 0;
                for (Element div : mainDiv.select("div[class=serp-item serp-adv-item]")) {
                    String text = div.text();
                    System.out.println(text);

                    if (j==0 && !text.contains("miele-m.ru") && !text.contains("miele-servicebt.ru")){
                        if (i < 3) {
                            ret.add(points[i]);
                            if (text.contains("mirrestart.ru")) this.pointToSite.put(points[i],"mirrestart.ru");
                            if (text.contains("service-restart.ru")) this.pointToSite.put(points[i],"service-restart.ru");
                            if (text.contains("miele.ru")) this.pointToSite.put(points[i],"miele.ru");
                            System.out.println("Add point " + i);
                        }

                    }

                    i++;
                }
                j++;
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return ret;
    }

    public static void downloadFiles(String strURL, String strPath, int buffSize) {
        try {
            URL connection = new URL(strURL);
            HttpsURLConnection urlconn;
            urlconn = (HttpsURLConnection) connection.openConnection();
            urlconn.addRequestProperty("123","123");

            urlconn.setRequestMethod("GET");
            urlconn.connect();
            InputStream in = null;
            in = urlconn.getInputStream();
            //InputStreamReader inp = new InputStreamReader(in);
            OutputStream writer = new FileOutputStream(strPath);

            OutputStreamWriter w = new OutputStreamWriter(writer, StandardCharsets.UTF_8);

            byte buffer[] = new byte[buffSize];
            byte bufferUtf[];
            //char buffer[] = new char[buffSize];
            int c = in.read(buffer);
            while (c > 0) {
                //String str = new String(buffer, "cp1251");
                //bufferUtf = str.getBytes("utf-8");
                writer.write(buffer, 0, c);
                c = in.read(buffer);
            }
            writer.flush();
            writer.close();
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public void savePage(){
        setClipboard("page.html");
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            sleep(this.timeout);
            r.keyPress(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_S);
            sleep(2*this.timeout);

            r.keyPress(KeyEvent.VK_CONTROL);
            sleep(this.timeout);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);

            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            sleep(this.timeout);

            r.keyPress(KeyEvent.VK_LEFT);
            r.keyRelease(KeyEvent.VK_LEFT);

            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);



            sleep(2*this.timeout);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public void setClipboard(String str) {
        StringSelection ss = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }



    public void start(){
        ArrayList<String> queries = getQueries();
        int j = 0;
        for (String query: queries){
            clearHistory();
            openAndTransfer(new Point(902,63)); //Переключение proxy
            sleep(1000);

            openAndTransfer(new Point(667,139));
            sleep(500);
            openAndTransfer(new Point(301,210));
            sleep(500);
            input("Москва и ");
            sleep(500);
            inputChar(KeyEvent.VK_ENTER); //13.Enter
            sleep(500);
            openAndTransfer(new Point(667,139));
            sleep(500);

            mouseMove(338, 134);
            mouse1Press(338, 134);
            clearText();
            input(query);
            inputChar(KeyEvent.VK_ENTER); //13.Enter
            //ur.input("ABCDEFGHIJKLMNOPQRSTYVWXYZ");
            sleep(20*this.timeout);
            savePage();
            ArrayList<Point> points = getPoints(query);


            for (Point p: points){
                sleep(2*this.timeout);
                //open(p);
                openAndTransfer(p);

                Random r = new Random();
                int pause = r.nextInt(40);
                sleep(20 * this.timeout + pause * this.timeout);

                String site = this.pointToSite.get(p);
                if (site != null) {
                    if (site.equals("service-restart.ru")) sceneServiceRestartRu();
                    if (site.equals("mirrestart.ru")) sceneMirRestartRu();
                    if (site.equals("miele.ru")) sceneMieleRu();

                }

                mouseWheel(4);
                sleep(this.timeout);
                mouseWheel(4);
                sleep(this.timeout);
                mouseWheel(4);
                sleep(this.timeout);
                mouseWheel(-4);
                sleep(this.timeout);
                mouseWheel(-4);
                sleep(this.timeout);
                mouseWheel(-4);
                sleep(this.timeout);
                openAndTransfer(new Point(268,333));
                sleep(4*this.timeout);
                openAndTransfer(new Point(863,248));
                sleep(4*this.timeout);
                openAndTransfer(new Point(231,860));

                sleep(20 * this.timeout);

                closeTab();
                sleep(4*this.timeout);
            }
            j++;
            if (j > 0) {

                newTab();
                j = 0;
            }

        }
    }

    public void sceneMieleRu(){
        int rand = getRandom(2);
        System.out.println("Random="+rand);
        //rand = 1;
        if (rand == 0) {
            openAndTransfer(new Point(40, 340));
            sleep(4000);
            openAndTransfer(new Point(129, 341));
            sleep(4000);
            openAndTransfer(new Point(231, 345));
            sleep(4000);
            openAndTransfer(new Point(371, 342));
            sleep(4000);
            openAndTransfer(new Point(554, 347));
            sleep(4000);
            try {
                Robot r = new Robot();
                r.mouseWheel(5);
                sleep(2000);
                r.mouseWheel(5);
                sleep(2000);
                r.mouseWheel(-5);
                sleep(2000);
                r.mouseWheel(-5);
                sleep(2000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (rand == 1){
            openAndTransfer(new Point(724, 344));
            sleep(4000);
            String input = getRandomString();
            input(input);
        }
    }

    public void sceneServiceRestartRu(){
        openAndTransfer(new Point(400,261));
        sleep(4000);
        openAndTransfer(new Point(391,389));
        sleep(4000);
        try {
            Robot r = new Robot();
            r.mouseWheel(100);
            sleep(2000);
            r.mouseWheel(100);
            sleep(2000);
            r.mouseWheel(100);
            sleep(2000);
            r.mouseWheel(100);
            sleep(2000);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void sceneMirRestartRu(){
        openAndTransfer(new Point(56,459));
        sleep(2000);
        openAndTransfer(new Point(94,537));
        sleep(2000);
        openAndTransfer(new Point(113,610));
        sleep(2000);
        openAndTransfer(new Point(775,459));
        sleep(2000);
        openAndTransfer(new Point(580,465));
        sleep(2000);
        input("ремонт варочной панели");
        sleep(2000);
        inputChar(KeyEvent.VK_ENTER);
        sleep(4000);
        try {
            Robot r = new Robot();
            r.mouseWheel(100);
            sleep(2000);
            r.mouseWheel(100);
            sleep(2000);
            r.mouseWheel(100);
            sleep(2000);
            r.mouseWheel(100);
            sleep(2000);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
