package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Andrey on 17.03.2017.
 */
public class LoadEmulator extends Thread {

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
                // x - quantity of randomly selected questions per theme
                // y - scenario ID
                User user = new User(50, 1l);
                // z - total number of randomised question in the user's scenario
                user.randomize(50*ContainerComposite.getCache().get(1).get(1).size());
                user.goThrough();
        }
}
