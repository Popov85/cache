package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Andrey on 17.03.2017.
 */
public class LoadEmulator extends Thread {

        public static ConcurrentHashMap<String, Long> timing = new ConcurrentHashMap<>();

        @Override
        public void run() {
                try {
                        startSession();
                } catch (Throwable e) {
                        System.out.println("ERROR: "+e.getMessage()+" CAUSE: "+e.getClass());
                }
        }

        private void startSession() {
              // New User arrived
                User user = new User(200, 1l);
                user.randomize();
                user.goThrough();
        }
}
