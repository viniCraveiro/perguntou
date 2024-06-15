package br.edu.unicesumar.perguntou.controller.question;

import br.edu.unicesumar.perguntou.domain.Alternative;
import br.edu.unicesumar.perguntou.domain.answer.Answer;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record QuestionDTO(
        @NotBlank String question,
        @NotBlank List<Answer> answer,
        @NotBlank Alternative correctAnswer
) {

}
