package test;

import java.util.*;

/**
 * Created by Andrey on 3/18/2017.
 */
public class FloydShuffler {
        /**
         * @param items
         * @param m - subset size
         * @param <T>
         * @return
         */
        public static <T> Set<T> shuffle(List<T> items, int m){
                HashSet<T> res = new HashSet<T>(m);
                Random rnd = new Random();
                int n = items.size();
                for(int i=n-m;i<n;i++){
                        int pos = rnd.nextInt(i+1);
                        T item = items.get(pos);
                        if (res.contains(item))
                                res.add(items.get(i));
                        else
                                res.add(item);
                }
                return res;
        }

        /**
         *
         * @param items
         * @param m - subset size for each Theme (may vary)
         * @param n - total number of questions in a composite scenario
         * @param <T>
         * @return
         */
        public static <T> Set<T> shuffleComposite(HashMap<Integer, List<T>> items, int m, int n){
                HashSet<T> res = new HashSet<T>(n);
                for (List<T> ts : items.values()) {
                        Set<T> subset = shuffle(ts, m);
                        res.addAll(subset);
                }
                return res;
        }
}
