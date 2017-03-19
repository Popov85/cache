package test;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrey on 3/18/2017.
 */
public final class ContainerComposite {
        /**
         * 1-st Integer - Scenario's Id
         * 2-nd Integer - Theme's Id
         */
        private static HashMap<Integer, HashMap<Integer, List<Question>>> cache = new HashMap<>();

        public static HashMap<Integer, HashMap<Integer, List<Question>>> getCache() {
                return cache;
        }

        public static void setCache(HashMap<Integer, HashMap<Integer, List<Question>>> cache) {
                ContainerComposite.cache = cache;
        }

        public static void addScenario(Integer key, HashMap<Integer, List<Question>> theme) {
                ContainerComposite.cache.put(key, theme);
        }

        public static void removeScenario(Integer key) {
                ContainerComposite.cache.remove(key);
        }

        public static void addTheme(Integer scenario, Integer theme, List<Question> questions) {
                ContainerComposite.cache.get(scenario).put(theme, questions);
        }

        public static void removeTheme(Integer scenario, Integer theme, List<Question> questions) {
                ContainerComposite.cache.get(scenario).remove(theme, questions);
        }
}
