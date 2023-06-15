import java.util.Collections;
import java.util.Map;

public class MaxLogger extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Main.sizeToFreq) {
                try {
                    Main.sizeToFreq.wait();
                } catch (InterruptedException e) {
                    return;
                }
                Main.sizeToFreq.entrySet()
                        .stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .limit(1)
                        .forEach(System.out::println);
            }
        }
    }
}
