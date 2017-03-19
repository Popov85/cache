package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Andrey on 3/18/2017.
 */
public class Generator {

        private static final String ALPHABET = "qwertyuiopasdfgjklzxcvbnm";

        /**
         *
         * @param n - questions in theme/scenario
         * @return
         */
        public static List<Question> populate(Integer n) {
                List<Question> questions = new ArrayList<Question>(n);
                Random r = new Random();
                for (Long i = 0l; i < n; i++) {
                        questions.add(
                                new Question(i, generateString(r, ALPHABET, 50), generateString(r, ALPHABET, 20))
                        );
                }
                Container.addScenario(1, questions);
                return questions;
        }

        private static String generateString(Random rng, String characters, int length) {
                char[] text = new char[length];
                for (int i = 0; i < length; i++) {
                        text[i] = characters.charAt(rng.nextInt(characters.length()));
                }
                return new String(text);
        }
}
