package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 17.03.2017.
 */
public class User {
        private int n;
        private Long scenario;
        private List<Question> questions;

        public User(int quantity, Long scenario) {
                this.n = quantity;
                this.scenario = scenario;
        }

        public int getN() {
                return n;
        }

        public void setN(int n) {
                this.n = n;
        }

        public Long getScenario() {
                return scenario;
        }

        public void setScenario(Long scenario) {
                this.scenario = scenario;
        }

        public List<Question> getQuestions() {
                return questions;
        }

        public void setQuestions(List<Question> questions) {
                this.questions = questions;
        }

        public void randomize() {
                long startCopyTime = System.currentTimeMillis();
                List<Question> copy = new LinkedList<Question>(Container.getCache().get(1));
                long endCopyTime = System.currentTimeMillis();
                long totalCopyTime = endCopyTime - startCopyTime;
                System.out.println("Copying: "+totalCopyTime+" ms"+" User: "+this);

                long startShuffleTime = System.currentTimeMillis();
                Collections.shuffle(copy);
                questions = copy.subList(0, n);
                long endShuffleTime = System.currentTimeMillis();
                long totalShuffleTime = endShuffleTime - startShuffleTime;
                System.out.println("Shuffle: "+totalShuffleTime+" ms"+" User: "+this);

                // Save time to list
                LoadEmulator.timing.put(Thread.currentThread().getName(), totalShuffleTime);
        }
        
        public void goThrough() {
                for (Question question : questions) {
                        //System.out.println("User: "+this);
                        //System.out.println("Question: "+question);
                }
        }

        @Override
        public String toString() {
                return Integer.toString(this.hashCode());
        }
}
