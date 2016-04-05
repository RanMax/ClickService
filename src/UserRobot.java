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
    public int speed = 0;
    //public static int counter = 0;
    public int steps = 0;

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
        rusMap.put('Б','<');
        rusMap.put('Ю','>');
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

    public void cCleaner(){
        sleep(10*timeout);
        openAndTransfer(new Point(184,753));
        sleep(20*this.timeout);
        openAndTransfer(new Point(1129,642));
        sleep(5*this.timeout);
        inputChar(KeyEvent.VK_ENTER);
        sleep(20*this.timeout);
    }

    public void changeInput(){
        System.out.println("Encode="+this.encode);
        try {
            Robot r = new Robot();

            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_SHIFT);
            sleep(5);
            r.keyRelease(KeyEvent.VK_ALT);
            r.keyRelease(KeyEvent.VK_SHIFT);
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
            openAndTransfer(new Point(276,45));
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
        randomClick(new Point(27,7),new Point(170,16));
        /* Закрытие вкладки - старая версия
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
        */
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
/*
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
*/

        queries.add("RESTART ВЫЗВАТЬ");
        queries.add("RESTART РЕМОНТ");
        queries.add("RESTART РЕМОНТ МОСКВА");
        queries.add("RESTART СЕРВИС");
        queries.add("RESTART СЕРВИСНЫЙ ЦЕНТР");
        queries.add("RESTART СРОЧНЫЙ РЕМОНТ");
        queries.add("RESTART ФИРМЕННЫЙ РЕМОНТ");
        queries.add("RESTART ФИРМЕННЫЙ СЕРВИСНЫЙ ЦЕНТР");
        queries.add("РЕСТАРТ МОСКВА");
        queries.add("РЕСТАРТ ОФИЦИАЛЬНЫЙ САЙТ");
        queries.add("РЕСТАРТ ОФИЦИАЛЬНЫЙ СЕРВИС");
        queries.add("РЕСТАРТ ОФИЦИАЛЬНЫЙ СЕРВИСНЫЙ ЦЕНТР");
        queries.add("РЕСТАРТ РЕМОНТ");
        queries.add("РЕСТАРТ САЙТ");
        queries.add("РЕСТАРТ СЕРВИС");
        queries.add("РЕСТАРТ СРОЧНЫЙ РЕМОНТ");
        queries.add("РЕМОНТ ВАРОЧНОЙ ПАНЕЛИ РЕСТАРТ");
        queries.add("РЕМОНТ ВЫТЯЖЕК RESTART");
        queries.add("РЕМОНТ ВЫТЯЖЕК РЕСТАРТ");
        queries.add("РЕМОНТ ПЛИТ RESTART");
        queries.add("РЕМОНТ ПЛИТ РЕСТАРТ");
        queries.add("РЕМОНТ ХОЛОДИЛЬНИКОВ RESTART");
        queries.add("РЕМОНТ ХОЛОДИЛЬНИКОВ РЕСТАРТ");



        queries.add("RESTART РЕМОНТ");
        queries.add("RESTART СЕРВИС");
        queries.add("РЕМОНТ ВАРОЧНОЙ ПАНЕЛИ RESTART");
        queries.add("RESTART РЕМОНТ");
        queries.add("RESTART СЕРВИС");
        queries.add("РЕМОНТ ВАРОЧНОЙ ПАНЕЛИ RESTART");
        queries.add("RESTART РЕМОНТ");
        queries.add("RESTART СЕРВИС");
        queries.add("РЕМОНТ ВАРОЧНОЙ ПАНЕЛИ RESTART");
        queries.add("RESTART РЕМОНТ");
        queries.add("RESTART СЕРВИС");
        queries.add("РЕМОНТ ВАРОЧНОЙ ПАНЕЛИ RESTART");

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

    public void mouse2Press(int x, int y){
        try {
            Robot r = new Robot();
            r.mousePress(InputEvent.BUTTON3_MASK);
            r.mouseRelease(InputEvent.BUTTON3_MASK);
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

    public int mouseMove(int x, int y){
        Point location = MouseInfo.getPointerInfo().getLocation();
        RobotPoint startPoint = new RobotPoint(location);
        RobotPoint endPoint = new RobotPoint(new Point(x,y));
        startPoint.next = endPoint;
        startPoint = generateTrace(startPoint);
        int sumary = go(startPoint);
        return  sumary;
    }

    public void mouseSerf(Point p1, Point p2, int time){
        while (time > 0){
            int pause = 0;
            int dx = Math.abs(p1.x - p2.x)/2;
            int dy = Math.abs(p1.y - p2.y);
            int x1 = getRandom(dx)+p1.x;
            int y1 = getRandom(dy)+p1.y;
            int x2 = getRandom(dx)+p1.x+dx;
            int y2 = getRandom(dy)+p1.y;
            Point pN1 = new Point(x1,y1);
            Point pN2 = new Point(x2,y2);
            pause = pause + mouseMove(pN1.x,pN1.y);

            pause = pause + mouseMove(pN2.x,pN2.y);

            int pause2 = getRandom(5000);
            pause = pause + pause2;
            time = time-pause;
        }
    }

    public void mouseWheel(int cnt){
        int absCnt = Math.abs(cnt);
        int speed = getRandom(30);
        while (absCnt > 0){
            try {
                int pause = 10+speed*getRandom(10);
                int stop = getRandom(20);
                if (stop == 0){
                    int stopPause = 2000+getRandom(5000);
                    mouseSerf(new Point(172,169),new Point(1022,710),stopPause);
                    //Thread.sleep(stopPause);
                }
                Thread.sleep(pause);
                Robot r = new Robot();
                r.mouseWheel((int)Math.signum(cnt));
            } catch (Exception ex){ex.printStackTrace();}
            absCnt--;
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
            mouseMove(276,45);
            openAndTransfer(new Point(276,45));
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
        mouseMove(point.x,point.y);
        int dx = getRandom(9)-4;
        int dy = getRandom(9)-4;
        mouseMove(point.x, point.y);
        sleep(this.timeout);
        mousePress(point.x+dx, point.y+dy, InputEvent.BUTTON1_MASK);
    }

    public void randomClick(Point p1, Point p2){
        int x = p1.x + getRandom(p2.x - p1.x);
        int y = p1.y + getRandom(p2.y - p1.y);
        openAndTransfer(new Point(x,y));
    }

    public ArrayList<Point> getPoints(String query){
        this.pointToSite = new HashMap<Point, String>();
        Point[] points = new Point[4];
        //points[0]=new Point(213,172);
        //points[1]=new Point(213,300);
        //points[2]=new Point(217,385);
        //points[3]=new Point(205,511);
        points[0]=new Point(127,151);
        points[1]=new Point(132,279);
        points[2]=new Point(135,406);
        points[3]=new Point(132,490);
        ArrayList<Point> ret = new ArrayList<Point>();
        try {
            String queryText = "https://yandex.ru/search/?text="+query + "&rstr=-1";
            //downloadFiles("https://yandex.ru/search/?text=miele%20aaa%20%D1%80%D0%B5%D0%BC%D0%BE%D0%BD%D1%82%20%D1%81%D1%82%D0%B8%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D1%85%20%D0%BC%D0%B0%D1%88%D0%B8%D0%BD%20miele&lr=213&rstr=-1&rnd=82767","e:/direct.html",100);
            File input = new File("C:\\Documents and Settings\\ххх\\Мои документы\\Downloads\\page.html");
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

    public void scroll(){
        int cnt = getRandom(20);
        mouseWheel(cnt);
        mouseWheel(cnt*(-1));
    }



    public void start(){
        ArrayList<String> queries = getQueries();
        int j = 0;
        for (String query: queries){
            int maxJ = 3+getRandom(2);
            if (j >= maxJ) {
                cCleaner();//чистка браузера
                sleep(20 * timeout);

                openAndTransfer(CsC.BUTTON_MODEM_OPEN);//запуск модема
                sleep(1500);
                openAndTransfer(CsC.BUTTON_MODEM_CONNECT);//отключение
                sleep(5000);
                openAndTransfer(CsC.BUTTON_MODEM_CONNECT);//включение
                sleep(5000);

                sleep(20 * timeout);

                openAndTransfer(CsC.BUTTON_CHROME_START);//запуск chrome
                sleep(30 * this.timeout);
                //newTab();
                //newTab();
                //newTab();
            /* Ввод поискового запроса START*/
                input(query);//вввод поискового запроса
                sleep(6 * timeout);
                int rand = getRandom(2);
                if (rand == 0) {
                    inputChar(KeyEvent.VK_ENTER);
                } else {
                    randomClick(CsC.BUTTON_YANDEX_SEARCH_FIRST_1,CsC.BUTTON_YANDEX_SEARCH_FIRST_2);
                }
                sleep(10 * timeout);
            /* Ввод поискового запроса END*/
                randomClick(CsC.BUTTON_YANDEX_DEFAULT_SEARCH_NO_1,CsC.BUTTON_YANDEX_DEFAULT_SEARCH_NO_2); //Отказ сделать Яндекс основным поиском
                sleep(2 * timeout);
            /* Повторный поиск START*/
                rand = getRandom(2);
                if (rand == 0) {
                    randomClick(CsC.BUTTON_YANDEX_SEARCH_BAR_1, CsC.BUTTON_YANDEX_SEARCH_BAR_2);
                    sleep(timeout);
                    inputChar(KeyEvent.VK_ENTER);
                } else {
                    randomClick(CsC.BUTTON_YANDEX_SEARCH_SECOND_1, CsC.BUTTON_YANDEX_SEARCH_SECOND_2);
                }
            /* Повторный поиск END*/

                sleep(10 * timeout);
                j = 0;
                clearText();
            }
            scroll();
/*
            //openAndTransfer(new Point(62, 532));
            randomClick(new Point(62,532), new Point(70,600));
            sleep(5000);
            //clearHistory();

            //openAndTransfer(new Poi020nt(902,63)); //Переключение proxy
            sleep(1000);

            //openAndTransfer(new Point(661,94));//расширенный поиск
            //sleep(500);
            //openAndTransfer(new Point(292,164));//смена региона
            //sleep(500);
            //input("Москва и ");
            //sleep(500);
            //inputChar(KeyEvent.VK_ENTER); //13.Enter
            //sleep(500);
            //openAndTransfer(new Point(661,94));//расширенный поиск
            sleep(500);

            mouseMove(321, 95);
            //openAndTransfer(new Point(321, 95));//строка поиска яндекс
            randomClick(new Point(140,87), new Point(578,107));//строка поиска яндекс
            clearText();
            input(query);
            inputChar(KeyEvent.VK_ENTER); //13.Enter
            sleep(2000);
            //openAndTransfer(new Point(720, 96));//кнопка поиска
            randomClick(new Point(684,82), new Point(755,112));//кнопка поиска
            sleep(10*timeout);
            scroll();

            //ur.input("ABCDEFGHIJKLMNOPQRSTYVWXYZ");
            */
            sleep(10*this.timeout);
            savePage();
            ArrayList<Point> points = getPoints(query);

            for (Point p: points){
                sleep(2*this.timeout);
                //open(p);
                //openAndTransfer(p);
                randomClick(p,new Point(p.x+350, p.y+15));

                Random r = new Random();
                int pause = r.nextInt(40);
                mouseSerf(CsC.BUTTON_DEFAULT_SERF_AREA_1,CsC.BUTTON_DEFAULT_SERF_AREA_2,10 * this.timeout + pause * this.timeout);

                String site = this.pointToSite.get(p);
                if (site != null) {
                    if (site.equals("service-restart.ru")) sceneServiceRestartRu();
                    if (site.equals("mirrestart.ru")) sceneMirRestartRu();
                    if (site.equals("miele.ru")) sceneMieleRu();

                }

                scroll();
                /* Эмуляция стандартного поведения на странице START*/
                int randClick = getRandom(3);
                if (randClick == 0) {
                    randomClick(new Point(71, 110), new Point(1034, 589));
                    //openAndTransfer(new Point(268,333));
                    sleep(4 * this.timeout);
                }
                randomClick(new Point(71, 110), new Point(1034, 589));
                sleep(4*this.timeout);
                randomClick(new Point(71, 110), new Point(1034, 589));

                mouseSerf(new Point(172,169),new Point(1022,710),40 * this.timeout);
                /* Эмуляция стандартного поведения на странице END*/

                closeTab();
                sleep(4*this.timeout);
            }
            j++;
        }
    }

    public void textSelection(Point p1,Point p2){
        try {
            int d1x = getRandom(9)-4;
            int d1y = getRandom(9)-4;
            int d2x = getRandom(9)-4;
            int d2y = getRandom(9)-4;
            //sleep(10000);
            Robot r = new Robot();
            //Point p1 = new Point(568,935);
            //Point p2 = new Point(733,939);
            //Point p3 = new Point(645,299);
            //openAndTransfer(new Point(561,701));
            r.mouseMove(p1.x+d1x, p2.y+d1y);
            sleep(1500);
            r.mousePress(InputEvent.BUTTON1_MASK);
            sleep(2000);
            r.mouseMove(p2.x+d2x, p2.y+d2y);
            sleep(500);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            sleep(2000);

            //r.mousePress(InputEvent.BUTTON1_MASK);
            //r.mouseRelease(InputEvent.BUTTON1_MASK);
            //Thread.sleep(5000);

            r.keyPress(KeyEvent.VK_CONTROL);
            sleep(500);
            r.keyPress(KeyEvent.VK_C);
            r.keyRelease(KeyEvent.VK_CONTROL);
            sleep(100);
            r.keyRelease(KeyEvent.VK_C);
        } catch (Exception ex){ex.printStackTrace();}
    }

    public int go(RobotPoint startPoint){
        int sumary = 0;
        try {
            if (startPoint != null) {
                System.out.println("STEP"+steps+"SPEED"+speed);
                steps++;
                if (steps > 100) {
                    speed = speed + getRandom(3)-1;
                    steps = 0;
                }
                if (speed < 0) speed = 0;
                if (speed > 2) speed = 2;
                //if (counter <= 0) {
                int pause = speed+ getRandom(2);
                Thread.sleep(pause);
                sumary = sumary + pause;
                //counter = speed;
                //}
                //counter--;
                Robot r = new Robot();
                r.mouseMove(startPoint.point.x, startPoint.point.y);
                sumary = sumary + go(startPoint.next);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return sumary;
    }

    public RobotPoint generateTrace(RobotPoint p){
        if (getDistance(p.point,p.next.point)<3) return p;
        else {
            RobotPoint next = p.next;
            int dx = getRandom(Math.abs(p.point.x - p.next.point.x)/4+1);
            int dy = getRandom(Math.abs(p.point.y - p.next.point.y)/4+1);
            int nx = Math.min(p.point.x,p.next.point.x)+dx+Math.abs(p.point.x - p.next.point.x)*3/8;
            int ny = Math.min(p.point.y,p.next.point.y)+dy+Math.abs(p.point.y - p.next.point.y)*3/8;
            Point newPoint = new Point(nx,ny);
            RobotPoint newRobotPoint = new RobotPoint(newPoint);
            newRobotPoint.next = next;
            p.next = generateTrace(newRobotPoint);
            return generateTrace(p);
        }
    }

    public double getDistance(Point p1,Point p2){
        return Math.pow(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2),0.5);
    }

    public void sceneMieleRu(){
        int rand = getRandom(2);
        System.out.println("Random="+rand);
        //rand = 1;
        if (rand == 0) {
            openAndTransfer(new Point(180, 302));
            sleep(4000);
            openAndTransfer(new Point(262, 302));
            sleep(4000);
            openAndTransfer(new Point(353, 302));
            sleep(4000);
            openAndTransfer(new Point(500, 302));
            sleep(4000);
            openAndTransfer(new Point(680, 303));
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
            openAndTransfer(new Point(838, 301));
            sleep(4000);
            String input = getRandomString();
            input(input);
        }
    }

    public void sceneServiceRestartRu(){
        int rand = getRandom(2);
        System.out.println("sceneServiceRestartRu.RAND="+rand);
        if (rand == 0){
            textSelection(new Point(410,83),new Point(545,79));
        } else {
            textSelection(new Point(408,110),new Point(548,105));
        }
        sleep(1000);
        randomClick(new Point(26,80),new Point(567,227));

        scroll();
        sleep(4*timeout);

        int r2 = getRandom(2);
        if (r2==0) {
            int cnt = getRandom(6);
            openAndTransfer(new Point(726, 228));
            sleep(4000);
            openAndTransfer(new Point(700, 270 + 25 * cnt));
            scroll();
        } else {
            randomClick(new Point(576,261), new Point(752,416));
            sleep(2000);
            scroll();
        }
        //openAndTransfer(new Point(644,228));
        randomClick(new Point(620,220),new Point(672,231));
        //mouseWheel(100);
        sleep(2000);
        scroll();
        sleep(2000);
        sleep(4000);


    }

    public void sceneMirRestartRu(){
        int rand = getRandom(2);
        int selection = getRandom(2);
        System.out.println("sceneMirRestartRu.Rand="+rand);
        if (selection == 0 ){
            textSelection(new Point(12,100),new Point(124,103));
        } else {
            textSelection(new Point(12,130),new Point(120,127));
        }
        sleep(1500);
        randomClick(new Point(385,192),new Point(770,393));
        sleep(1000);
        scroll();
        sleep(4*timeout);
        if (rand ==0) {
            openAndTransfer(new Point(170, 420));
            sleep(2000);
            openAndTransfer(new Point(187, 460));
            sleep(2000);
            scroll();
            sleep(2000);
            openAndTransfer(new Point(170, 420));
            sleep(2000);
            openAndTransfer(new Point(177, 494));
            sleep(2000);
            scroll();
            sleep(2000);
            openAndTransfer(new Point(170, 420));
            sleep(2000);
            openAndTransfer(new Point(174, 529));
            sleep(2000);
            scroll();
            sleep(2000);
            openAndTransfer(new Point(170, 420));
            sleep(2000);
            openAndTransfer(new Point(177, 565));
            sleep(2000);
            scroll();
            sleep(2000);
        } else {
            openAndTransfer(new Point(1233, 419));
            sleep(2000);
            openAndTransfer(new Point(1000, 419));
            sleep(2000);
            input(getRandomString());
            sleep(2000);
            inputChar(KeyEvent.VK_ENTER);
            sleep(4000);
            scroll();
        }
    }

    public class RobotPoint{
        public RobotPoint next;
        public Point point;

        public RobotPoint(Point point){
            this.point = point;
        }

        public RobotPoint getNext() {
            return next;
        }

        public void setNext(RobotPoint next) {
            this.next = next;
        }
    }
}
