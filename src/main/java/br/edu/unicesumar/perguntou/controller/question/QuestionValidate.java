package br.edu.unicesumar.perguntou.controller.question;

public class QuestionValidate {

        public static void validate(QuestionDTO questionDTO) {
            if (questionDTO.question().length() < 10) {
                throw new IllegalArgumentException("Question must have at least 10 characters");
            }
            if (questionDTO.answer().size() < 4) {
                throw new IllegalArgumentException("Question must have at least 4 answers");
            }
            if (questionDTO.correctAnswer() == null) {
                throw new IllegalArgumentException("Question must have a correct answer");
            }
        }
}
