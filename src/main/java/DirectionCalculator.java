import java.util.Random;

public class DirectionCalculator implements Runnable {
    private final String route = generateRoute("RLRFR", 100);

    @Override
    public void run() {
        Long count = route.chars().filter(x -> x == 'R').count();
        synchronized (Main.sizeToFreq) {
            Main.sizeToFreq.merge(count.intValue(), 1, Integer::sum);
            Main.sizeToFreq.notify();
        }
    }
    public static String generateRoute(String letters, int length) {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();
    }
}
