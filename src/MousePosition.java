import java.awt.*;

/**
 * Created by Максим on 27.03.2016.
 */
public class MousePosition {
    public static void main(String[] args){
        UserRobot ur = new UserRobot();
        while (true){
            Point location = MouseInfo.getPointerInfo().getLocation();
            double x = location.getX();
            double y = location.getY();
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            ur.sleep(500);
        }
    }
}
