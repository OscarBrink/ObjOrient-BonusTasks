package bonusTasks;

import java.util.concurrent.TimeUnit;

/**
 * The program creates a stopwatch that tracks time in milliseconds.
 *
 * @version 1.0 2018-01-24
 * @author Oscar Brink
 */
public class Stopwatch {

    private boolean started;
    private long currentTime;
    private long startTime;
    
    public static void m1ain(String[] args) {
        /* try catch required for TimeUnit.MILLISECONDS.sleep() */
        try {
            Stopwatch s = new Stopwatch();

            /* Check that watch is off and time is 0 at start. */
            System.out.println(
                    "isStarted: " + s.isStarted() + " time: " + s.time()
            );
            /* Check that boolean started has changed */
            s.start();
            System.out.println("isStarted: " + s.isStarted() + "\n");

            /* Wait 3 seconds and check if time is 3000 ms. */
            TimeUnit.MILLISECONDS.sleep(3000);
            System.out.println("pre reset: " + s.time());
            /* Stop and reset, check if time is now 0. */
            s.stop();
            s.reset();
            System.out.println("post reset: " + s.time() + "\n");

            /* counts up 5 seconds and prints out the time. */
            s.start();
            for (int i = 1; i <= 5; i++) {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.print(i + " seconds: " + s.time() + "\n");
            }
            s.stop();

        }
        catch (InterruptedException e) {}
    }
    
    public Stopwatch() {
        started = false;
        currentTime = 0;
    }
    
    public void start() {
        if (isStarted()) {
            return;
        }
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

    public boolean isStarted() {
        return started;
    }

    public void reset() {
        if (isStarted()) {
            /* If the watch is on, it will reset to 0, but keep running. */
            startTime = System.currentTimeMillis();
        }
        currentTime = 0;
    }

    public long time() {
        /* if the watch is started it has to calculate the new time first. */
        if (isStarted()) {
            currentTime += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
        }
        return currentTime;
    }
    
}
