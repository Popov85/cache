package test;

import java.util.*;

/**
 * Created by Andrey on 17.03.2017.
 */
public class User {
        private int n;
        private Long scenario;
        private Set<Question> questions;

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

        public Set<Question> getQuestions() {
                return questions;
        }

        public void setQuestions(Set<Question> questions) {
                this.questions = questions;
        }

        public void randomize(Integer m) {
                long startShuffleTime = System.currentTimeMillis();
                questions = FloydShuffler.shuffleComposite(ContainerComposite.getCache().get(1), n, m);
                //questions = FloydShuffler.shuffle(Container.getCache().get(1), n);
                long endShuffleTime = System.currentTimeMillis();
                long totalShuffleTime = endShuffleTime - startShuffleTime;
                System.out.println("Shuffle: " + totalShuffleTime + " ms" + " User: " + this);
        }
        
        public void goThrough() {
                /*System.out.println("User: "+this);
                StringBuilder sb = new StringBuilder();
                for (Question question : questions) {
                        sb.append(question).append(" | ");
                }
                System.out.println(sb.toString());*/
        }

        @Override
        public String toString() {
                return Integer.toString(this.hashCode());
        }
}
