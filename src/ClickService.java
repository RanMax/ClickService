import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Максим on 26.03.2016.
 */
public class ClickService {
    public static void main(String args[]){
        System.out.println("HelloWorld");
        Point startPoint = new Point(338,134);

        try {
            UserRobot ur = new UserRobot();
            ur.start();
            Robot r = new Robot();
            /*
            ur.mouseMove(338, 134);

            ur.mouse1Press(338,134);
            ur.input("miele aaa ремонт стиральных машин miele");
            ur.inputChar(KeyEvent.VK_ENTER); //13.Enter
            //ur.input("ABCDEFGHIJKLMNOPQRSTYVWXYZ");

            for (Point p: points){
                ur.sleep(1000);
                ur.open(p);
            }


            while (true){
                Point location = MouseInfo.getPointerInfo().getLocation();
                double x = location.getX();
                double y = location.getY();
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                ur.sleep(1000);
            }
            */


        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
