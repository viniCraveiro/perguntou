package br.edu.unicesumar.perguntou.domain.question;

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

        return new QuestionDTO(saved.getQuestion(), saved.getAnswers(), saved.getCorrectAnswer());

    }

    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Question not found."));
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
