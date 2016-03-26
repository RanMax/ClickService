import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.net.ssl.HttpsURLConnection;
import java.awt.*;
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
        ret.add("РЕМОНТ ЗАПЧАСТЕЙ MIELE");
        ret.add("СЕРВИС MIELE В МОСКВЕ");
        ret.add("ОФИЦИАЛЬНЫЙ СЕРВИСНЫЙ ЦЕНТР MIELE");
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

    public void open(Point point){
        mouseMove(point.x, point.y);
        sleep(500);
        mousePress(point.x, point.y, InputEvent.BUTTON3_MASK);
        sleep(500);
        mouseMove(point.x+10, point.y+10);
        mousePress(point.x+10, point.y+10, InputEvent.BUTTON1_MASK);
    }

    public ArrayList<Point> getPoints(String query){
        Point[] points = new Point[4];
        points[0]=new Point(195,206);
        points[1]=new Point(255,332);
        points[2]=new Point(245,455);
        points[3]=new Point(249,580);
        ArrayList<Point> ret = new ArrayList<Point>();
        try {
            //downloadFiles("https://yandex.ru/search/?text=miele%20aaa%20%D1%80%D0%B5%D0%BC%D0%BE%D0%BD%D1%82%20%D1%81%D1%82%D0%B8%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D1%85%20%D0%BC%D0%B0%D1%88%D0%B8%D0%BD%20miele&lr=213&rstr=-1&rnd=82767","e:/direct.html",100);
            File input = new File("e:/direct2.html");
            Document doc = Jsoup.parse(input, "utf8", "http://example.com/");
            System.out.println(doc.text());
            int j = 0;
            for (Element mainDiv : doc.select("div[class=serp-list]")) {
                int i = 0;
                for (Element div : mainDiv.select("div")) {
                    String text = div.text();
                    if (j==0 && !text.equals("Сервис MIELE в Москве. / miele-m.ru Рекламаmiele-m.ru Ремонт и сервис, оригинальные комплектующие. Гарантия. Москва и МО. духовые шкафы варочные панели холодильники стиральные машины Контактная информация 8 (800) 333-50-83 пн-вс 9:00-21:00 Ремонт стиральных машин MIELE? / remont-obsluzhivanie.ru Рекламаremont-obsluzhivanie.ru Диагностика = 0 руб. при сложном ремонте. Выезд Москва и МО сразу. Звоните! Гарантия Цены Скидки и акции Заказать выезд мастера Контактная информация +7 (499) 404-20-01 пн-вс 8:00-23:00 Официальный сервисный центр Miele / miele.ru Рекламаmiele.ru Гарантийный и послегарантийный ремонт бытовой техники Miele. Подключение. Заявка Запрос запчастей Ремонт Контакты Контактная информация +7 (495) 745-89-90 пн-пт 8:00-20:00, сб-вс 9:00-19:00 Ремонт Miele («Мили») в Москве | Ремонт бытовой... moscow-miele.ru Сохранённая копияПоказать ещё с сайтаПожаловаться Стоимость ремонта стиральных машин Miele. Вызвать мастера по ремонту техники Miele в Москве. Вы можете вызвать мастера по ремонту бытовой техники Miele в Москве у нас и тем самым - Вы получаете лучший сервис с гарантией высшего... Цены на ремонт стиральных машин Miele » Сервисный... miele-servis.ru›Цены на услуги›Прейскуранте Сохранённая копияПоказать ещё с сайтаПожаловаться Сервисный центр ремонт Miele в Москве. ... Ремонт стиральных машин ВЫЗОВ МАСТЕРА Ремонт бытовой техники Запчасти Установка/подключение Цены на услуги Полезное Контакты Отзывы. Miele-m - Ремонт и сервисное обслуживание miele-m.ru Сохранённая копияПоказать ещё с сайтаПожаловаться Ремонт стиральных машин Miele. ... Если Вам нужен качественный ремонт стиральной машины Miele на дому, обращайтесь в наш СЦ! ... Ежедневно, включая выходные и праздники, 365 дней в году по всей Москве и Московской области. Ремонт стиральных машин Miele | Сервис Miele. +7 495... moscow-servis-miele.ru›Услуги›Ремонт стиральных машин Miele Сохранённая копияПоказать ещё с сайтаПожаловаться Ремонт стиральной машины Miele в Москве Московской области, зависит от профессионализма мастера, какой мастер такой и ремонт. В нашем случаи мы гарантируем Вам, качество, своевременную сдачу работы и чистоту. Ремонт стиральных машин Miele на дому | СЦ МастерБюро masterburo.ru›remont-stiralnyh-mashin/miele/ Сохранённая копияПоказать ещё с сайтаПожаловаться МастерБюро осуществляет ремонт стиральных машин Miele (Миле) любых моделей за пару часов. Наши специалисты выезжают на дом и ремонтируют, не забирая машину в сервис центр. Устранение протечки стиральной машины Miele servis-gold.ru›ustranenie-protechki-stiralnoy-mash Сохранённая копияПоказать ещё с сайтаПожаловаться Итак, течет стиральная машина Miele. Помните - такой ремонт иногда можно сделать своими руками. Сервисный центр Золотые руки - ремонт бытовой техники в Москве и Московской области, диагностика и ремонт стиральных машин, диагностика и... Ремонт стиральных машин Miele / Миле на дому... rembitteh.ru›remont-stiralnyh-mashin-miele/ Сохранённая копияПоказать ещё с сайтаПожаловаться О марке стиральных машин MIELE / Миле: Стиральные машинки Miele (Миле) — это популярная немецкая бытовая техника премиум-класса. ... Мы выезжаем в города Московской области Ремонт стиральных машин Miele в Москве и Московской... ls-servis.ru›miele-stiralnye-mashiny Сохранённая копияПоказать ещё с сайтаПожаловаться Ремонт стиральных машин Miele. Немецкая техника Miele известна сегодня каждому. ... Работаем в Москве и Подмосковье. Ремонт стиральных машин Miele на дому. Выезд мастера... remdial.ru›miele.html Сохранённая копияПоказать ещё с сайтаПожаловаться Miele. Профессиональный ремонт стиральных машин. Работаем ежедневно с 9:00 до 21:00 Выезд специалиста бесплатно Гарантия. ... Москва и МО. Скидки пенсионерам. Ремонт стиральных машин Miele-service miele-servicebt.ru›ремонт-стиральных-машин-miele/ Сохранённая копияПоказать ещё с сайтаПожаловаться Ремонт стиральных машин Miele в Москве и Московской области с выездом на дом к клиентам, к юридическим и физическим лицам тел: 8 (495) ... Если Вам нужен качественный ремонт стиральной машины Miele на дому, обращайтесь в наш СЦ! Ремонт стиральных машин ПОДОЛЬСК! / stiralkin.net Рекламаstiralkin.net Жители города Подольск, Климовск для Вас приятные цены! Вежливые мастера. Контактная информация +7 (968) 492-25-05 пн-вс 9:00-22:00 Ремонт стиральных машин – Сломалась стиральная машина? Рекламаremont-techniki.biz Починим! Ремонт от 800 руб. Звоните! Контактная информация +7 (968) 773-88-48 пн-вс 10:00-21:00 Ремонт стиральных машин Miele / remstirmash24.ru Рекламаremstirmash24.ru Сегодня скидка на ремонт 20%. Выезд мастера за 1 час. Гарантия от 6 мес.. Контактная информация +7 (495) 755-36-60 круглосуточно MIELE ремонт? Выезжаем к Вам! / remontmile.ru Рекламаremontmile.ru Ремонт - через 40 мин после звонка! Диагностика = 0 руб., Сегодня - акция! Гарантия Цены Акции_скидки Заказать_диагностику_бесплатно Контактная информация +7 (499) 346-76-01 пн-вс 8:00-22:00 м. Алтуфьево")){
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



    public void start(){
        ArrayList<String> queries = getQueries();
        for (String query: queries){
            mouseMove(338, 134);
            mouse1Press(338, 134);
            clearText();
            input(query);
            inputChar(KeyEvent.VK_ENTER); //13.Enter
            //ur.input("ABCDEFGHIJKLMNOPQRSTYVWXYZ");

            ArrayList<Point> points = getPoints(query);
            for (Point p: points){
                sleep(1000);
                open(p);
            }

        }
    }
}
