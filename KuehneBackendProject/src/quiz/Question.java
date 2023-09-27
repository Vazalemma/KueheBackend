package quiz;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private long id;

    private String topic;
    private int difficulty;
    private String content;
    private List<Response> responses;

    public Question() {
    }

    public Question(String topic, int difficulty, String content, List<Response> reponses) {
        this.topic = topic;
        this.difficulty = difficulty;
        this.content = content;
        this.responses = reponses;
    }

    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getContent() {
        return content;
    }

    public List<Response> getResponses() {
        return responses;
    }

    @Override
    public String toString() {
        String answers = "";
        for (int i = 0; i < responses.size(); i++) {
            Response r = responses.get(i);
            answers += " [" + i + "] " + r.getText();
        }
        return content + answers;
    }
}
