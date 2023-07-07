<template>
    <h2 class="mt-5 text-center w-50 mx-auto fw-bolder">
        <div class="d-flex">Вопрос #<slot name="index"></slot></div>
    </h2>
    <div class="card fs-5 mt-3 w-50 mx-auto"> {{ question.text }} </div>
    <div class="fs-3 mt-3 text-center fw-medium w-50 mx-auto">
        <div class="d-flex fw-bold">Варианты ответа </div>
    </div>
    <div class="question-answers mt-4">
        <QuestionItemAnswer 
        v-for="answer in question?.answers" 
        :answer="answer" 
        :questionId="question.id"
        :key="answer.id"
        @handleAnswer="handler"
        />
    </div>
</template>

<script>
import QuestionItemAnswer from './QuestionItemAnswer.vue';
export default {
    components: { QuestionItemAnswer },
    props: {
        question: {
            type: Object,
            required: true
        }
    },
    methods: {
        handler(answer, questionId) {
            console.log('answer is: ' + answer);
            if (answer.isCorrect) {
            } else {

            }
        }
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