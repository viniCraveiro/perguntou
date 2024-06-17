package br.edu.unicesumar.perguntou.controller.question;

import br.edu.unicesumar.perguntou.controller.answer.AnswerDTO;
import br.edu.unicesumar.perguntou.domain.answer.Answer;
import br.edu.unicesumar.perguntou.domain.question.Question;
import br.edu.unicesumar.perguntou.domain.question.QuestionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v0/question")
@RestController
public class QuestionRestController {

    private final QuestionService questionService;


    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> create(@RequestBody QuestionDTO questionDTO) {
        QuestionValidate.validate(questionDTO);
        Question question = new Question(questionDTO.question());
        List<Answer> list = questionDTO.answer().stream().map(answerDTO -> new Answer(answerDTO.text(), answerDTO.alternative())).toList();
        question.addAllAnswers(list);
        question.setCorrectAnswer(questionDTO.correctAnswer());
        QuestionDTO saved = questionService.save(question);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/list")
    public ResponseEntity<String> createList(@RequestBody List<QuestionDTO> questionDTO) {
        questionDTO.forEach(this::create);
        return new ResponseEntity<>("Questions created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> findById(@PathVariable Long id) {
        Question question = questionService.findById(id);
        List<AnswerDTO> answerList = question.getAnswers().stream().map(answer -> new AnswerDTO(answer.getText(), answer.getOption())).toList();
        return new ResponseEntity<>(new QuestionDTO(question.getQuestion(), answerList, question.getCorrectAnswer()), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<QuestionDTO>> findAll() {
        List<Question> questions = questionService.findAll();
        List<AnswerDTO> answerList = new ArrayList<>();
        List<QuestionDTO> questionsDTO =
                questions.stream().map(q -> new QuestionDTO(q.getQuestion(), q.getAnswers().stream().map(a -> new AnswerDTO(a.getText(),
                        a.getOption())).toList(), q.getCorrectAnswer())).toList();
        return new ResponseEntity<>(questionsDTO, HttpStatus.OK);
    }
}
