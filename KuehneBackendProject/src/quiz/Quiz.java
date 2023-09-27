package quiz;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private long id;

    private List<Question> questions;
    
    public Quiz() {
    }

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        String quiz = "";
        for (Question question : questions) {
            quiz += question + "\n";
        }
        return quiz;
    }
}
