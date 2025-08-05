package multiThread.sec03;

import java.awt.*;

// thread 클래스 상속 - 객체 인스턴스
public class BeepThread extends Thread{
    @Override
    public void  run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for(int i=0; i<5; i++){
            toolkit.beep();
            try{Thread.sleep(500);} catch(Exception e){}
        }

    }
}
