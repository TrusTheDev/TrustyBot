package Models;

import java.awt.*;

public class KeyBtn {
    int pressTime;

    public void pressbtn(int keycode, int pressTime) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(keycode);
        robot.keyRelease(pressTime);
    }

    public int getPressTime() {
        return pressTime;
    }

    public void setPressTime(int pressTime) {
        this.pressTime = pressTime;
    }


}
