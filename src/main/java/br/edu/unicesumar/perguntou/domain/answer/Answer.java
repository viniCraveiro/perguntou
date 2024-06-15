package br.edu.unicesumar.perguntou.domain.answer;

import br.edu.unicesumar.perguntou.domain.Alternative;
import br.edu.unicesumar.perguntou.domain.Entidade;
import br.edu.unicesumar.perguntou.domain.question.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Entity
@Getter
@Setter
@Table(name = "ANSWER")
public class Answer extends Entidade {

    @ManyToOne
    @JoinColumn(name = "QUESTION_FK")
    private Question question;

    private String text;

    private Alternative option;

    protected Answer() {
    }

    public Answer(String text, Alternative option) {
        this.text = text;
        this.option = option;
    }

    public Answer(Long id, Question question, String text, Alternative option) {
        super(id);
        this.question = question;
        this.text = text;
        this.option = option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Answer answer = (Answer) o;
        return Objects.equals(question, answer.question) && Objects.equals(text, answer.text) && option == answer.option;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
