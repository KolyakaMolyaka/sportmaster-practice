<template>
    <h2 class="mt-5 text-center w-50 mx-auto fw-bolder">
        <div class="d-flex">Вопрос #<slot name="index"></slot></div>
    </h2>
    <div class="card fs-5 mt-3 w-50 mx-auto"> {{ question.text }} </div>
        <div class="fs-3 mt-3 text-center fw-medium w-50 mx-auto">
            <div class="d-flex fw-bold"> Варианты ответа </div>
        </div>
        <div class="question-answers mt-4">
            <button v-for="answer in question.answers"
                class="answer-card btn btn-primary d-block w-50 text-start p-3 ps-5 fs-5 mt-3 rounded-pill mx-auto">
                {{ answer.text }}, isCorrect?: {{ answer.isCorrect }}
            </button>
    </div>
</template>

<script>
export default {
    props: {
        question: {
            type: Object,
            required: true
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