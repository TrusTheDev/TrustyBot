package Controllers.InitMode;

import Controllers.Timers.Timer;
import Models.KeyBtn;
import repository.btnRepository;
import java.awt.*;

public class secuencialModeController extends Thread{
    public static void init(int timeLimit) throws InterruptedException, AWTException {
        Timer timer = new Timer(timeLimit, true);
        sleep(3000);
        timer.start();
        Robot trustyBot = new Robot();

        while (timer.isFinishedFlag()) {
            for( int i = 0; i < btnRepository.keyListSize(); i++){
                KeyBtn key = btnRepository.getKey(i);
                key.pressBtn(trustyBot);

            }
            sleep(1000);
        }
        System.out.println("Finalizado");
        timer.interrupt();
    }
}
