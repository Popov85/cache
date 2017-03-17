package test;

/**
 * Created by Andrey on 17.03.2017.
 */
public class Question {
        private Long id;
        private String question;
        private String answer;

        public Question(Long id, String question, String answer) {
                this.id = id;
                this.question = question;
                this.answer = answer;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getQuestion() {
                return question;
        }

        public void setQuestion(String question) {
                this.question = question;
        }

        public String getAnswer() {
                return answer;
        }

        public void setAnswer(String answer) {
                this.answer = answer;
        }

        @Override
        public String toString() {
                return "Question{" +
                        "id=" + id +
                        ", question='" + question + '\'' +
                        ", answer='" + answer + '\'' +
                        '}';
        }
}