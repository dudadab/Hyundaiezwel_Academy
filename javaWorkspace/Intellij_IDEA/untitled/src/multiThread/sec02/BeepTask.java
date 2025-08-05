package multiThread.sec02;

import java.awt.*;

public class BeepTask implements Runnable {
    // beep음 출력담당 - Runnable을 구현

    @Override
    public void  run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // 비프음 출력 - 작업 1
        for(int i=0; i<5; i++){
            toolkit.beep(); // 비프음 발생
            try{Thread.sleep(500);} catch(Exception e){} // 0.5초 지연
        }

    }
}
