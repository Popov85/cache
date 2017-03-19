package test;

/**
 * Created by Andrey on 17.03.2017.
 */
public class Runner {

        public static void main(String[] args) throws InterruptedException {
                long startPopulateTime = System.currentTimeMillis();
                /*// m - number of elements in Question list
                Generator.populate(10000);*/

                // x - number of themes per scenario
                // y - number of questions in each theme (total)
                GeneratorComposite.populate(15, 2000);
                long endPopulateTime = System.currentTimeMillis();
                long totalPopulateTime = endPopulateTime - startPopulateTime;
                System.out.println("Populating time: "+totalPopulateTime+" ms");
                // n - number of concurrent users
                launchTestSession(200);
        }

        private static void launchTestSession(int n) {
                for (int i = 0; i < n; i++) {
                        LoadEmulator le = new LoadEmulator();
                        le.start();
                }
        }

}
