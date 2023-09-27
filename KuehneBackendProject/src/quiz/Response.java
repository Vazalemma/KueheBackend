package quiz;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private long id;

    private String text;
    private boolean value;
    
    public Response() {
    }

    public Response(String text, boolean value) {
        this.text = text;
        this.value = value;
    }
    
    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "[" + value + "] " + text;
    }
}
