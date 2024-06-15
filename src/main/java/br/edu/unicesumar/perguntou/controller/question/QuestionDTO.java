package br.edu.unicesumar.perguntou.controller.question;

import br.edu.unicesumar.perguntou.controller.answer.AnswerDTO;
import br.edu.unicesumar.perguntou.domain.Alternative;

import java.util.List;

public record QuestionDTO(
        String question,
        List<AnswerDTO> answer,
        Alternative correctAnswer
) {
}
