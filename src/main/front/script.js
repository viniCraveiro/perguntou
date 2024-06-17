const listItens = async () => {
    const questions = await fetch('http://localhost:8080/api/v0/question');
    const questionsJson = await questions.json();

    console.log(questionsJson);
    // fetch('http://localhost:8080/api/v0/question', {
    //     method: 'GET',
    //     mode: 'cors',
    //     headers: {
    //         'Content-Type': 'application/json',
    //     },

    // });
    return questionsJson;
};

listItens();
