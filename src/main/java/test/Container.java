package test;

import java.util.HashMap;
import java.util.List;

/**
 * Holds cache of scenarios and questions in it
 * Created by Andrey on 17.03.2017.
 */
public final class Container {

        private static HashMap<Integer, List<Question>> cache = new HashMap<>();

        public static HashMap<Integer, List<Question>> getCache() {
                return cache;
        }

        public static void setCache(HashMap<Integer, List<Question>> cache) {
                Container.cache = cache;
        }

        public static void addScenario(Integer key, List<Question> question) {
                Container.cache.put(key, question);
        }

        public static void removeScenario(Integer key) {
                Container.cache.remove(key);
        }
}
