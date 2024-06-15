package br.edu.unicesumar.perguntou.domain.question;

import br.edu.unicesumar.perguntou.controller.answer.AnswerDTO;
import br.edu.unicesumar.perguntou.controller.question.QuestionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionDTO save(Question question) {

        Question saved = questionRepository.save(question);
        List<AnswerDTO> listAnswer = saved.getAnswers().stream().map(answer -> new AnswerDTO(answer.getText(), answer.getOption())).toList();
        return new QuestionDTO(saved.getQuestion(), listAnswer, saved.getCorrectAnswer());

    }

    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Question not found."));
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
