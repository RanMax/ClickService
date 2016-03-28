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
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Максим on 26.03.2016.
 */
public class UserRobot {
    HashSet<Character> engSum = new HashSet<Character>();
    HashMap<Character,Character> rusMap;
    HashMap<Character,Integer> engMap;
    public int timeout = 500;

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
        ArrayList<String> ret = new ArrayList<String>();
        ret.add("MIELE ДИАГНОСТИКА");
        ret.add("MIELE ОФИЦИАЛЬНЫЙ САЙТ РЕМОНТ");
        ret.add("MIELE ОШИБКА ПОДАЧИ ВОДЫ");
        ret.add("MIELE РЕМОНТ");
        ret.add("MIELE РЕМОНТ БЫТОВОЙ ТЕХНИКИ");
        ret.add("MIELE РЕМОНТ МОСКВА");
        ret.add("MIELE СЕРВИС");
        ret.add("MIELE СЕРВИС ЦЕНТР");
        ret.add("MIELE СЕРВИСНЫЙ ЦЕНТР");
        ret.add("MIELE СЕРВИСНЫЙ ЦЕНТР МОСКВА");
        ret.add("MIELE СЛОМАЛАСЬ");
        ret.add("MIELE СРОЧНЫЙ РЕМОНТ");
        ret.add("MIELE СТИРАЛЬНАЯ МАШИНА ЗАПЧАСТИ");
        ret.add("MILELE РЕМОНТ");
        ret.add("SERVICE MIELE");
        ret.add("SERVICE MIELE");
        ret.add("W 3240 MIELE ЗАПЧАСТИ МАНЖЕТ");
        ret.add("WATERPROOF MIELE");
        ret.add("СЕРВИСНАЯ СЛУЖБА МИЕЛЕ");
        ret.add("СЕРВИСНАЯ СЛУЖБА МИЕЛЕ");
        ret.add("ЗАПЧАСТИ MIELE");
        ret.add("ЗАПЧАСТИ MIELE");
        ret.add("ЗАПЧАСТИ MIELE В МОСКВЕ");
        ret.add("ЗАПЧАСТИ MIELE В НАЛИЧИИ");
        ret.add("ЗАПЧАСТИ ДЛЯ MIELE CVA 620");
        ret.add("ЗАПЧАСТИ ДЛЯ MIELE CVA 620 РЕМОНТ");
        ret.add("ЗАПЧАСТИ ДЛЯ МАШИН MIELE");
        ret.add("ЗАПЧАСТИ ДЛЯ СТИРАЛЬНОЙ МАШИНЫ МИЛЕ PW 5065");
        ret.add("ЗАПЧАСТИ ДЛЯ СТИРАЛЬНЫХ МАШИН MIELE");
        ret.add("ЗАПЧАСТИ ДЛЯ СТИРАЛЬНЫХ МАШИН МИЛЕ");
        ret.add("ЗАПЧАСТИ К ПОСУДОМОЕЧНОЙ МАШИНЕ MIELE");
        ret.add("ЗАПЧАСТИ МИЕЛЕ");
        ret.add("ЗАПЧАСТИ МИЛЕ");
        ret.add("ЗАПЧАСТИ МИЛЕ СТИРАЛЬНЫЕ МАШИНЫ");
        ret.add("ЗАПЧАСТИ МИЛИ");
        ret.add("МИЕЛЕ ОФИЦИАЛЬНЫЙ САЙТ СЕРВИС");
        ret.add("МИЕЛЕ РЕМОНТ");
        ret.add("МИЕЛЕ СЕРВИС");
        ret.add("МИЕЛЕ СЕРВИСНЫЙ ЦЕНТР МИЛЕ");
        ret.add("МИЕЛЕ СЛОМАЛАСЬ");
        ret.add("МИЕЛЕ СРОЧНЫЙ РЕМОНТ");
        ret.add("МИЛ СЕРВИС");
        ret.add("МИЛЕ РЕМОНТ");
        ret.add("МИЛЕ СЕРВИС");
        ret.add("МИЛЕ СЕРВИС ЦЕНТР");
        ret.add("МИЛЕ СЕРВИС ЦЕНТР МОСКВА");
        ret.add("МИЛЕ СЕРВИСНЫЙ ЦЕНТР");
        ret.add("МИЛЕ СРОЧНЫЙ РЕМОНТ");
        ret.add("МИЛИ ДИАГНОСТИКА");
        ret.add("МИЛИ РЕМОНТ");
        ret.add("МИЛИ СЕРВИС");
        ret.add("МИЛИ СЛОМАЛАСЬ");
        ret.add("МИЛЛ СЕРВИС");
        ret.add("МИЛЛ СЕРВИС");
        ret.add("МИЛЛИ ДИАГНОСТИКА");
        ret.add("МИЛЛИ СЕРВИСНЫЙ ЦЕНТР");
        ret.add("ОШИБКА WATERPROOF MIELE");
        ret.add("ОШИБКА СЛИВА ВОДЫ MIELE");
        ret.add("ПОДКЛЮЧЕНИЕ СТИРАЛЬНОЙ МАШИНЫ MIELE");
        ret.add("РЕМОНТ MIELE В МОСКВЕ");
        ret.add("РЕМОНТ БЫТОВОЙ ТЕХНИКИ МИЛЕ");
        ret.add("РЕМОНТ ВАРОЧНЫХ ПАНЕЛЕЙ MIELE");
        ret.add("РЕМОНТ ВЫТЯЖЕК MIELE");
        ret.add("РЕМОНТ ВЫТЯЖКИ MIELE");
        ret.add("РЕМОНТ ДУХОВЫХ ШКАФОВ MIELE");
        ret.add("РЕМОНТ КОФЕМАШИН MIELE");
        ret.add("РЕМОНТ МАШИН MIELE");
        ret.add("РЕМОНТ МИЛЛЕ");
        ret.add("РЕМОНТ МИЛЛИ");
        ret.add("РЕМОНТ ПОСУДОМОЕЧНЫХ МАШИН MIELE");
        ret.add("РЕМОНТ ПОСУДОМОЕЧНЫХ МАШИН МИЛЕ");
        ret.add("РЕМОНТ СТИРАЛЬНЫХ МАШИН МИЛЕ");
        ret.add("РЕМОНТ СТИРАЛЬНЫХ МАШИН МИЛИ");
        ret.add("РЕМОНТ СТИРАЛЬНЫХ МАШИН MIELE");
        ret.add("РЕМОНТ СТИРАЛЬНЫХ МАШИН МИЕЛЕ");
        ret.add("РЕМОНТ СУШИЛЬНЫХ МАШИН MIELE");
        ret.add("РЕМОНТ ТЕХНИКИ MIELE");
        ret.add("РЕМОНТ ТЕХНИКИ МИЛЕ");
        ret.add("СЕРВИС MIELE В МОСКВЕ");
        ret.add("СЕРВИС МИЕЛЕ");
        ret.add("СЕРВИС МИЕЛЕ В МОСКВЕ");
        ret.add("СЕРВИС МИЛЕ");
        ret.add("СЕРВИС МИЛЕ В МОСКВЕ");
        ret.add("СЕРВИС МИЛЕ В МОСКВЕ");
        ret.add("СЕРВИС МИЛИ");
        ret.add("СЕРВИС МИЛЛЕ");
        ret.add("СЕРВИС ЦЕНТР MIELE");
        ret.add("СЕРВИС ЦЕНТР MIELE В МОСКВЕ");
        ret.add("СЕРВИС ЦЕНТР МИЛЕ");
        ret.add("СЕРВИС ЦЕНТР МИЛЕ В МОСКВЕ");
        ret.add("СЕРВИСНАЯ СЛУЖБА MIELE");
        ret.add("СЕРВИСНАЯ СЛУЖБА МИЛЛИ");
        ret.add("СЕРВИСНЫЙ ЦЕНТР MIELE МОСКВА");
        ret.add("СТИРАЛЬНАЯ МАШИНА MIELE ОШИБКА WATERPROOF");
        ret.add("СТИРАЛЬНАЯ МАШИНА MIELE ОШИБКА СЛИВ ВОДЫ");
        ret.add("УСТАНОВКА MIELE");
        ret.add("УСТАНОВКА МИЕЛЕ");
        ret.add("УСТАНОВКА МИЛЕ");
        ret.add("УСТАНОВКА МИЛИ");

        return ret;
    }

    public void input(String text){
        try {
            text = text.toUpperCase();
            char[] arr = text.toCharArray();
            byte[] bytes = text.getBytes("UTF-8");
            for (int i = 0; i < text.length(); i++) {
                //String symbol = text.substring(i, i + 1);
                inputSymbol(arr[i],bytes[i]);
                sleep(100);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void sleep(int millis){
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
        if (this.rusMap.containsKey(symbol)){
            changeInput();
        }
        int num = getCode(symbol,code);
        inputChar(num);
        if (this.rusMap.containsKey(symbol)){
            changeInput();
        }
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
        try {
            Robot r = new Robot();
            r.mouseMove(x, y);
        } catch (Exception ex){
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
        Point[] points = new Point[4];
        points[0]=new Point(230,206);
        points[1]=new Point(230,332);
        points[2]=new Point(230,455);
        points[3]=new Point(230,580);
        ArrayList<Point> ret = new ArrayList<Point>();
        try {
            String queryText = "https://yandex.ru/search/?text="+query + "&rstr=-1";
            //downloadFiles("https://yandex.ru/search/?text=miele%20aaa%20%D1%80%D0%B5%D0%BC%D0%BE%D0%BD%D1%82%20%D1%81%D1%82%D0%B8%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D1%85%20%D0%BC%D0%B0%D1%88%D0%B8%D0%BD%20miele&lr=213&rstr=-1&rnd=82767","e:/direct.html",100);
            File input = new File("E:\\04_JavaProjects\\ClickService\\temp\\page.html");
            Document doc = Jsoup.parse(input, "utf8", "http://example.com/");
            System.out.println(doc.text());
            int j = 0;
            for (Element mainDiv : doc.select("div[class=serp-list]")) {
                int i = 0;
                for (Element div : mainDiv.select("div[class=serp-item serp-adv-item]")) {
                    String text = div.text();
                    System.out.println(text);

                    if (j==0 && !text.contains("miele-m.ru") && !text.contains("miele-servicebt.ru")){
                        if (i < 4) {
                            ret.add(points[i]);
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
            mouseMove(338, 134);
            mouse1Press(338, 134);
            clearText();
            input(query);
            inputChar(KeyEvent.VK_ENTER); //13.Enter
            //ur.input("ABCDEFGHIJKLMNOPQRSTYVWXYZ");
            sleep(10*this.timeout);
            savePage();
            ArrayList<Point> points = getPoints(query);

                for (Point p: points){
                sleep(2*this.timeout);
                //open(p);
                openAndTransfer(p);
                sleep(8*this.timeout);
                closeTab();
                sleep(4*this.timeout);
            }
            j++;
            if (j > 2) {
                newTab();
                j = 0;
            }

        }
    }
}
