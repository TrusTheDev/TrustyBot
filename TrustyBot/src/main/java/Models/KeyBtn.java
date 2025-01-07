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

    public void pressBtn(Robot robot) throws InterruptedException {
        holdBtn(robot);
        robot.delay(pressTime);
        releaseBtn(robot);
    }

    public void holdBtn(Robot robot) throws InterruptedException {
        robot.keyPress(keycode);
    }

    public void releaseBtn(Robot robot) throws InterruptedException {
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
