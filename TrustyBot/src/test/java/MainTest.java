import Models.KeyBtn;
import repository.keycodeRepository;

import java.awt.*;

public class MainTest {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        keycodeRepository keycodeRepository = new keycodeRepository();
        int keycode = keycodeRepository.getKeycode("A");
        double time = Double.POSITIVE_INFINITY;
        KeyBtn key = new KeyBtn(5000,keycode,5000, "Default");

            for(int i=0; i < time; i++){
            key.pressbtn(robot);
            key.await(robot);
            }


    }
}
