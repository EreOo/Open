package util;

/**
 * Created Vladimir Shekhavtsov.
 * Simple time out. Work with milliseconds.
 */
public class TimeOut {
    public void timeOut(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
