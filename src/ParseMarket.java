import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by Максим on 26.03.2016.
 */
public class ParseMarket {
    public static void main(String[] args){
        try {
            //downloadFiles("https://yandex.ru/search/?text=miele%20aaa%20%D1%80%D0%B5%D0%BC%D0%BE%D0%BD%D1%82%20%D1%81%D1%82%D0%B8%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D1%85%20%D0%BC%D0%B0%D1%88%D0%B8%D0%BD%20miele&lr=213&rstr=-1&rnd=82767","e:/direct.html",100);
            //downloadFiles("https://yandex.ru/search/?text=miele%20aaa%20%D1%80%D0%B5%D0%BC%D0%BE%D0%BD%D1%82%20%D1%81%D1%82%D0%B8%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D1%85%20%D0%BC%D0%B0%D1%88%D0%B8%D0%BD%20miele&lr=213","e:/direct.html",100);
            //downloadFiles2("https://yandex.ru/search/?text=miele%20aaa%20ремонт%20стиральных%20машин%20miele%20");
            //String url = "https://yandex.ru/search/?text=miele aaa ремонт стиральных машин miele";
            //Document doc = Jsoup.connect(url).get();

            File input = new File("e:/direct2.html");
            Document doc = Jsoup.parse(input, "utf8", "http://example.com/");

            System.out.println(doc.text());
            for (Element mainDiv : doc.select("div[class=serp-list]")) { //this will work if your doc contains only one table element
                //System.out.println("elem");
                for (Element div : mainDiv.select("div")) {
                    String text = div.text();
                    if (text.equals("Сервис MIELE в Москве. / miele-m.ru Рекламаmiele-m.ru Ремонт и сервис, оригинальные комплектующие. Гарантия. Москва и МО. духовые шкафы варочные панели холодильники стиральные машины Контактная информация 8 (800) 333-50-83 пн-вс 9:00-21:00 Ремонт стиральных машин MIELE? / remont-obsluzhivanie.ru Рекламаremont-obsluzhivanie.ru Диагностика = 0 руб. при сложном ремонте. Выезд Москва и МО сразу. Звоните! Гарантия Цены Скидки и акции Заказать выезд мастера Контактная информация +7 (499) 404-20-01 пн-вс 8:00-23:00 Официальный сервисный центр Miele / miele.ru Рекламаmiele.ru Гарантийный и послегарантийный ремонт бытовой техники Miele. Подключение. Заявка Запрос запчастей Ремонт Контакты Контактная информация +7 (495) 745-89-90 пн-пт 8:00-20:00, сб-вс 9:00-19:00 Ремонт Miele («Мили») в Москве | Ремонт бытовой... moscow-miele.ru Сохранённая копияПоказать ещё с сайтаПожаловаться Стоимость ремонта стиральных машин Miele. Вызвать мастера по ремонту техники Miele в Москве. Вы можете вызвать мастера по ремонту бытовой техники Miele в Москве у нас и тем самым - Вы получаете лучший сервис с гарантией высшего... Цены на ремонт стиральных машин Miele » Сервисный... miele-servis.ru›Цены на услуги›Прейскуранте Сохранённая копияПоказать ещё с сайтаПожаловаться Сервисный центр ремонт Miele в Москве. ... Ремонт стиральных машин ВЫЗОВ МАСТЕРА Ремонт бытовой техники Запчасти Установка/подключение Цены на услуги Полезное Контакты Отзывы. Miele-m - Ремонт и сервисное обслуживание miele-m.ru Сохранённая копияПоказать ещё с сайтаПожаловаться Ремонт стиральных машин Miele. ... Если Вам нужен качественный ремонт стиральной машины Miele на дому, обращайтесь в наш СЦ! ... Ежедневно, включая выходные и праздники, 365 дней в году по всей Москве и Московской области. Ремонт стиральных машин Miele | Сервис Miele. +7 495... moscow-servis-miele.ru›Услуги›Ремонт стиральных машин Miele Сохранённая копияПоказать ещё с сайтаПожаловаться Ремонт стиральной машины Miele в Москве Московской области, зависит от профессионализма мастера, какой мастер такой и ремонт. В нашем случаи мы гарантируем Вам, качество, своевременную сдачу работы и чистоту. Ремонт стиральных машин Miele на дому | СЦ МастерБюро masterburo.ru›remont-stiralnyh-mashin/miele/ Сохранённая копияПоказать ещё с сайтаПожаловаться МастерБюро осуществляет ремонт стиральных машин Miele (Миле) любых моделей за пару часов. Наши специалисты выезжают на дом и ремонтируют, не забирая машину в сервис центр. Устранение протечки стиральной машины Miele servis-gold.ru›ustranenie-protechki-stiralnoy-mash Сохранённая копияПоказать ещё с сайтаПожаловаться Итак, течет стиральная машина Miele. Помните - такой ремонт иногда можно сделать своими руками. Сервисный центр Золотые руки - ремонт бытовой техники в Москве и Московской области, диагностика и ремонт стиральных машин, диагностика и... Ремонт стиральных машин Miele / Миле на дому... rembitteh.ru›remont-stiralnyh-mashin-miele/ Сохранённая копияПоказать ещё с сайтаПожаловаться О марке стиральных машин MIELE / Миле: Стиральные машинки Miele (Миле) — это популярная немецкая бытовая техника премиум-класса. ... Мы выезжаем в города Московской области Ремонт стиральных машин Miele в Москве и Московской... ls-servis.ru›miele-stiralnye-mashiny Сохранённая копияПоказать ещё с сайтаПожаловаться Ремонт стиральных машин Miele. Немецкая техника Miele известна сегодня каждому. ... Работаем в Москве и Подмосковье. Ремонт стиральных машин Miele на дому. Выезд мастера... remdial.ru›miele.html Сохранённая копияПоказать ещё с сайтаПожаловаться Miele. Профессиональный ремонт стиральных машин. Работаем ежедневно с 9:00 до 21:00 Выезд специалиста бесплатно Гарантия. ... Москва и МО. Скидки пенсионерам. Ремонт стиральных машин Miele-service miele-servicebt.ru›ремонт-стиральных-машин-miele/ Сохранённая копияПоказать ещё с сайтаПожаловаться Ремонт стиральных машин Miele в Москве и Московской области с выездом на дом к клиентам, к юридическим и физическим лицам тел: 8 (495) ... Если Вам нужен качественный ремонт стиральной машины Miele на дому, обращайтесь в наш СЦ! Ремонт стиральных машин ПОДОЛЬСК! / stiralkin.net Рекламаstiralkin.net Жители города Подольск, Климовск для Вас приятные цены! Вежливые мастера. Контактная информация +7 (968) 492-25-05 пн-вс 9:00-22:00 Ремонт стиральных машин – Сломалась стиральная машина? Рекламаremont-techniki.biz Починим! Ремонт от 800 руб. Звоните! Контактная информация +7 (968) 773-88-48 пн-вс 10:00-21:00 Ремонт стиральных машин Miele / remstirmash24.ru Рекламаremstirmash24.ru Сегодня скидка на ремонт 20%. Выезд мастера за 1 час. Гарантия от 6 мес.. Контактная информация +7 (495) 755-36-60 круглосуточно MIELE ремонт? Выезжаем к Вам! / remontmile.ru Рекламаremontmile.ru Ремонт - через 40 мин после звонка! Диагностика = 0 руб., Сегодня - акция! Гарантия Цены Акции_скидки Заказать_диагностику_бесплатно Контактная информация +7 (499) 346-76-01 пн-вс 8:00-22:00 м. Алтуфьево")){
                        System.out.println("Наш");
                    }
                    //String title = div.attr("aria-label");
                    //System.out.println("ARIA-LABEL "+title);
                    //System.out.println(div.text());
                    /*
                    for (Element div2 : div.select("div[class=serp-item__greenurl serp-url i-bem]")) {
                        for (Element div3 : div2.select("div[class=label label_color_yellow serp-adv-item__label]")) {
                            System.out.println("LABEL="+div3.text());
                        }

                        for (Element span : div2.select("span[class=serp-url__item path]")) {
                            System.out.println("SPAN="+span.text());
                        }



                    }

                    if (title.equals("Реклама")){
                        System.out.println(title);
                    }

                    //Elements cont = div.select("div");
                    */

                }
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
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

    public static void downloadFiles2(String address){
        try {
            URL url = new URL(address);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
