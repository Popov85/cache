package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Andrey on 3/18/2017.
 */
public class GeneratorComposite {

        /**
         * Populates ContainerComposite
         * @param n - quantity of Themes in the scenario (10-30 themes per scenario)
         * @param m - quantity of Questions per theme (2000)
         */
        public static void populate(Integer n, Integer m) {
                //List<Question> questions = new ArrayList<Question>(n);
                HashMap<Integer, List<Question>> scenario = new HashMap<>();
                for (int i = 0; i < n; i++) {
                        List<Question> theme = Generator.populate(m);
                        scenario.put(i, theme);
                }
                ContainerComposite.addScenario(1, scenario);
        }
}
