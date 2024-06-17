package br.edu.unicesumar.perguntou.domain.question;

import br.edu.unicesumar.perguntou.domain.Alternative;
import br.edu.unicesumar.perguntou.domain.Entidade;
import br.edu.unicesumar.perguntou.domain.answer.Answer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Entity
@DynamicUpdate
@Table(name = "QUESTION")
public class Question extends Entidade {

    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    @Setter
    private Alternative correctAnswer;

    protected Question() {
    }

    public Question(String question) {
        this.question = question;
    }

    public Question(Long id, String question) {
        super(id);
        this.question = question;
    }

    public void addAnswer(Answer answer) {
        answer.setQuestion(this);
        this.answers.add(answer);
    }

    public void removeAnswer(Answer answer) {
        this.answers.remove(answer);
    }

    public void addAllAnswers(List<Answer> answers) {
        answers.forEach(op -> {
            op.setQuestion(this);

        });
        this.answers.addAll(answers);
    }

    public void removeAllAnswers() {
        this.answers.clear();
        this.correctAnswer = null;
    }


}
