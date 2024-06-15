package br.edu.unicesumar.perguntou.controller.question;

import br.edu.unicesumar.perguntou.domain.question.Question;
import br.edu.unicesumar.perguntou.domain.question.QuestionService;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/v0/question")
@RestController
public class QuestionRestController {

    private final QuestionService questionService;


    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> create(QuestionDTO questionDTO) {
        QuestionValidate.validate(questionDTO);
        Question question = new Question(questionDTO.question());
        question.addAllAnswers(questionDTO.answer());
        question.setCorrectAnswer(questionDTO.correctAnswer());
        QuestionDTO saved = questionService.save(question);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> findById(Long id) {
        Question question = questionService.findById(id);
        return new ResponseEntity<>(new QuestionDTO(question.getQuestion(), question.getAnswers(), question.getCorrectAnswer()), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<QuestionDTO>> findAll(){
        List<Question> questions = questionService.findAll();
        List<QuestionDTO> questionsDTO = questions.stream().map(q -> new QuestionDTO(q.getQuestion(), q.getAnswers(), q.getCorrectAnswer())).collect(Collectors.toList());
        return new ResponseEntity<>(questionsDTO, HttpStatus.OK);
    }
}
