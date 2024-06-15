package br.edu.unicesumar.perguntou.domain.answer;

import br.edu.unicesumar.perguntou.domain.Alternative;
import br.edu.unicesumar.perguntou.domain.Entidade;
import br.edu.unicesumar.perguntou.domain.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@ToString
@Entity
@Getter
@Table(name = "ANSWER")
public class Answer extends Entidade {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    private String text;

    private Alternative option;

    protected Answer() {
    }

    public Answer(Question question, String text, Alternative option) {
        this.question = question;
        this.text = text;
        this.option = option;
    }

}
