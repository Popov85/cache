package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Andrey on 17.03.2017.
 */
public class Runner {

        public static void main(String[] args) throws InterruptedException {
                long startPopulateTime = System.currentTimeMillis();
                // m - number of elements in Question list
                populateCollection(30000);
                long endPopulateTime = System.currentTimeMillis();
                long totalPopulateTime = endPopulateTime - startPopulateTime;
                System.out.println("Populating time: "+totalPopulateTime+" ms");

                // n - number of concurrent users
                launchTestSession(100);
                Thread.sleep(30000);
                System.out.println("Timings");
                final ConcurrentHashMap<String, Long> timing = LoadEmulator.timing;
                for (Long aLong : timing.values()) {
                        System.out.println(aLong+" ms");
                }
        }

        private static void launchTestSession(int n) {
                for (int i = 0; i < n; i++) {
                        LoadEmulator le = new LoadEmulator();
                        le.start();
                }
        }

        private static void populateCollection(Integer n) {
                List<Question> questions = new ArrayList<Question>(n);
                Random r = new Random();
                for (Long i = 0l; i < n; i++) {
                        questions.add(
                                new Question(i, generateString(r, "qwertyuiopasdfgjklzxcvbnm", 50), generateString(r, "qwertyuiopasdfgjklzxcvbnm", 20))
                        );
                }
                Container.addScenario(1, questions);
        }

        public static String generateString(Random rng, String characters, int length) {
                char[] text = new char[length];
                for (int i = 0; i < length; i++) {
                        text[i] = characters.charAt(rng.nextInt(characters.length()));
                }
                return new String(text);
        }
}
