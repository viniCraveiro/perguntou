package br.edu.unicesumar.perguntou.controller.answer;

import br.edu.unicesumar.perguntou.domain.Alternative;

public record AnswerDTO(String text, Alternative alternative) {
}