import java.awt.*;
import java.awt.event.InputEvent;
import java.util.HashSet;

/**
 * Created by Максим on 26.03.2016.
 */
public class UserRobot {
    HashSet<Character> engSum = new HashSet<Character>();

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
    }
    public void input(String text){
        try {
            char[] arr = text.toCharArray();
            byte[] bytes = text.getBytes("UTF-8");
            for (int i = 0; i < text.length(); i++) {
                String symbol = text.substring(i, i + 1);
                //String c = new String(arr[i]);
                int num = symbol.getBytes()[0];
                if (num < 0) num = num + 255;
                inputChar(num);
                System.out.println(arr[i]);
                System.out.println(bytes[i]);
                System.out.println(num);
                sleep(1000);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void sleep(int millis){
        try {
            Thread.sleep(1000);
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

    public void mouse1Press(int x, int y){
        try {
            Robot r = new Robot();
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public int getCode(char symbol){
        if (this.engSum.contains(symbol)){
            //int num = symbol.getBytes()[0];
            //if (num < 0) num = num + 255;
        }
        return 0;

    }
}
