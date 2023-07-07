<!-- Компонент для отображения викторины, которую проходит пользователь,
     отображаемой после запроса GET /quizzes/{quizId}
-->

<template>
    <div>
        <h1 class="text-center mt-5 fw-bold">{{ quiz?.title }}</h1>
        <div class="card fs-5 mt-3 w-50 mx-auto">{{ quiz?.description }}</div>
        <CurrentQuizItemQuestions :quizId="quizId"/>
    </div>
</template>

<script>
import CurrentQuizItemQuestions from './CurrentQuizItemQuestions.vue';
const getQuizInfoApi = 'http://localhost:8080/quizzes/';
export default {
    components: { CurrentQuizItemQuestions },
    data() {
        return {
            quiz: null,
        }
    },
    props: {
        quizId: {
            required: true
        }
    }, 
    methods: {
        fetchQuizInfo() {
            fetch(getQuizInfoApi + this.quizId)
            .then(response => response.json())
            .then(json => this.quiz = json);
        },
    },
    mounted() {
        this.fetchQuizInfo();
    }
}
</script>

<style scoped>
.card {
    background-color: #fefefe;
    border-radius: 9px;
    border: 1px solid var(--text-color);
    padding: 20px 15px;
    box-shadow: 0px 12px 28px 4px rgba(0, 0, 0, 0.3);
    color: #737380;
}
</style>