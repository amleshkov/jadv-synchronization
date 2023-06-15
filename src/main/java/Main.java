import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new MaxLogger());
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new DirectionCalculator());
        }
        executorService.shutdown();
    }
}
