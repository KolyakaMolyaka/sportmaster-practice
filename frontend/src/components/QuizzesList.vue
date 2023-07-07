<template>
    <div class="d-flex flex-wrap mt-5 justify-content-center">
        <div
        class="quiz-card mt-3 me-5 alert alert-color"
        v-for="quiz in quizzes"> 

        <QuizItem :quiz="quiz"/>
        </div>
    </div>
</template>

<script>
import QuizItem from './QuizItem.vue';

export default {
    components: { QuizItem },
    props: {
        quizzes: {
            type: Array,
            required: true
        }
    }
}
</script>

<style scoped>
.quiz-card {
    width: 650px;
    padding: 10px;
}

.alert-color {
    background-color: #505e86 !important;
    border-radius: 9px;
}

</style>