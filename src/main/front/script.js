let questions = [];
const displayedQuestions = new Set();

const listItens = async () => {
    const questions = await fetch('http://localhost:8080/api/v0/question');
    return await questions.json();;
};

const displayRandomQuestion = async () => {
    const questions = await listItens();
    const arrayLength = questions.length;
    const randomIndex = Math.floor(Math.random() * arrayLength);
    const randomQuestion = questions[randomIndex];

    const h1Element = document.getElementById('question-title');
    h1Element.textContent = randomQuestion.question;

    randomQuestion.answer.forEach(answer => {
        const button = document.getElementById(`answer-${answer.alternative}`);
        if (button) {
            button.textContent = `${answer.alternative}. ${answer.text}`;
            button.onclick = () => checkAnswer(randomQuestion.correctAnswer, answer.alternative);
        }
    });

};

const checkAnswer = (correctAnswer, selectedAnswer) => {
    const feedbackElement = document.getElementById('feedback');
    if (selectedAnswer === correctAnswer) {
        feedbackElement.textContent = "Resposta correta!";
        feedbackElement.style.color = "green";
    } else {
        feedbackElement.textContent = `Resposta incorreta. A resposta correta é ${correctAnswer}.`;
        feedbackElement.style.color = "red";
    }
};



displayRandomQuestion();
