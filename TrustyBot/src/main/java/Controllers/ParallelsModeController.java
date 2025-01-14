package Controllers;

import Models.KeyBtn;
import repository.btnRepository;

public class ParallelsModeController extends Thread {

    public static void init(int timeLimit) throws InterruptedException {
        Timer timer = new Timer(timeLimit, true);
        System.out.println("Initializing parallelism mode");
        sleep(3000);
        timer.start();
        while(timer.isFinishedFlag()){
            for( int i = 0; i < btnRepository.keyListSize(); i++){
                KeyBtn key = btnRepository.getKey(i);
                key.pressThreadBtn(key);
            }
            sleep(1000);
        }
        System.out.println("Finished");
    }
}
