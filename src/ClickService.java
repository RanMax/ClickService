import java.awt.*;

/**
 * Created by Максим on 26.03.2016.
 */
public class ClickService {
    public static void main(String args[]){
        System.out.println("HelloWorld");
        Point startPoint = new Point(338,134);

        Point p1 = new Point(195,207);
        Point p2 = new Point(255,330);
        Point p3 = new Point(245,452);

        try {
            Robot r = new Robot();
            r.mouseMove(338, 134);
            UserRobot ur = new UserRobot();
            ur.mouse1Press(338,134);
            ur.input("MIELE ААА ремонт стиральных машин miele");

            ur.sleep(5000);
            r.mouseMove(200,300);

            while (true){
                Point location = MouseInfo.getPointerInfo().getLocation();
                double x = location.getX();
                double y = location.getY();
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                ur.sleep(1000);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
