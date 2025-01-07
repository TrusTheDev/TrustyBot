import java.awt.*;

import static java.lang.Thread.sleep;

public class press {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        sleep(3000);
        for(int i=0; i < 1000; i++) {
            sleep(3000);
            robot.keyPress(32);
            robot.keyRelease(32);
            System.out.println("Pressed");
        }
        sleep(3000);
 

    }
}
