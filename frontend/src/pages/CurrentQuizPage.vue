<template>
    <div>
        <h1 class="text-center mt-5 fw-bold">{{ quiz?.title }}</h1>
        <div class="card fs-5 mt-3 w-50 mx-auto">{{ quiz?.description }}</div>
    </div>
    <!-- questions -->
    <div>
        <div v-for="(question, index) in questions">
                <h2 class="mt-5 text-center w-50 mx-auto fw-bolder">
                    <div class="d-flex">Вопрос #{{ index+1 }}</div>
                </h2>
                <div class="card fs-5 mt-3 w-50 mx-auto"> {{ question.text }} </div>
                <div class="fs-3 mt-3 text-center fw-medium w-50 mx-auto">
                    <div class="d-flex fw-bold"> Варианты ответа </div>
                </div>
                <div class="question-answers mt-4">
                    {{  question.answers }}
                    <button v-for="answer in [{text: 'answer #1', isCorrect: false}, {text: 'answer #2', isCorrect: true}]"
                        class="answer-card btn btn-primary d-block w-50 text-start p-3 ps-5 fs-5 mt-3 rounded-pill mx-auto">
                        {{ answer.text }}, isCorrect?: {{ answer.isCorrect }}
                    </button>
                </div>
        </div>
    </div>
    
</template>

<script>
const API = 'http://localhost:8080/quizzes/';
const AnswersAPI = 'http://localhost:8080/questions/'

export default {
    data() {
        return {
            quiz: null,
            questions: null,
            quizId: this.$route.params.id 
        }
    },
    methods: {
        fetchQuizInfo() {
            fetch(API + this.quizId)
            .then(response => response.json())
            .then(json => this.quiz = json);
        },
        fetchQuestionsInfo() {
            fetch(API + this.quizId + '/questions')
            .then(response => response.json())
            .then(json => this.questions = json);
        }
    },
    mounted() {
        this.fetchQuestionsInfo();
        this.fetchQuizInfo();
    }
}
</script>

<style>
.card {
    background-color: #fefefe;
    border-radius: 9px;
    border: 1px solid var(--text-color);
    padding: 20px 15px;
    box-shadow: 0px 12px 28px 4px rgba(0, 0, 0, 0.3);
    color: #737380;
}
</style>