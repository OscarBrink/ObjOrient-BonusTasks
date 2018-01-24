package bonusTasks;

import java.util.concurrent.TimeUnit;

public class Stopwatch {

    private boolean started;
    private long currentTime;
    private long startTime;
    
    public static void main(String[] args) {
        Stopwatch s = new Stopwatch();
        System.out.println(s.isStarted());
        System.out.println(s.time());
        s.start();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(s.time());
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(s.time());
        
        s.stop();
        s.reset();
        s.start();
        for (int i = 0; i < 5; i++) {
            System.out.print(s.time());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.print(" " + s.time() + "\n");
            //s.reset();
        }
        s.stop();
    }
    
    public Stopwatch() {
        started = false;
        currentTime = 0;
    }
    
    public void start() {
        if (isStarted()) {
            return;
        }
        System.out.println("test");
        startTime = System.currentTimeMillis();
        started = true;
    }
    
    public void stop() {
        if (!isStarted()) {
            return;
        }
        currentTime += System.currentTimeMillis() - startTime;
        startTime = 0;
        started = false;
    }
    
    public void reset() {
        if (isStarted()) {
            /* If the watch is on, it will reset to 0, but keep running. */
            startTime = System.currentTimeMillis();
        }
        currentTime = 0;
    }
    
    public boolean isStarted() {
        return started;
    }
    
    public long time() {
        if (startTime != 0) {
            currentTime += System.currentTimeMillis() - startTime;
        }
        
        if (isStarted()) {
            startTime = System.currentTimeMillis();
        } else {
            startTime = 0;
        }
        return currentTime;
    }
    
}
