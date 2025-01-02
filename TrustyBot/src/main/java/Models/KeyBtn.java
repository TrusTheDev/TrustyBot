package Models;

import java.awt.*;

public class KeyBtn {
    String name;
    int pressTime;
    int keycode;
    int delay;

    public KeyBtn(int pressTime, int keycode, int delay, String name) {
        this.pressTime = pressTime;
        this.keycode = keycode;
        this.delay = delay;
        this.name = name;

    }

    public void pressbtn(Robot robot) throws InterruptedException {
        robot.keyPress(keycode);
        robot.wait(pressTime);
        robot.keyRelease(keycode);
    }

    public void await(Robot robot) throws InterruptedException {
        robot.delay(delay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPressTime() {
        return pressTime;
    }

    public void setPressTime(int pressTime) {
        this.pressTime = pressTime;
    }

    public int getKeycode() {
        return keycode;
    }

    public void setKeycode(int keycode) {
        this.keycode = keycode;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
