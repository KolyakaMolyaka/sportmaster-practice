<template>

    <CurrentQuizItemQuestionItem
    v-if="questions !== null"
    v-for="(question, index) in questions"
    :question="question"
    :key="question.id"
    > 
        <template #index> {{index+1}} </template>
    </CurrentQuizItemQuestionItem>

</template>

<script>
import CurrentQuizItemQuestionItem from '@/components/CurrentQuizItemQuestionItem.vue';
const questionsAPI = 'http://localhost:8080/quizzes/'
export default {
    components: { CurrentQuizItemQuestionItem },
    props: {
        quizId: {
            required: true
        }
    },
    data() {
        return {
            questions: null,
        }
    },
    methods: {
        fetchQuestionsInfo() {
            fetch(questionsAPI + this.quizId + '/questions')
            .then(response => response.json())
            .then(json => this.questions = json);
        },
    },
    mounted() {
        this.fetchQuestionsInfo();
        this.$store.commit('resetScore');
    }

}
</script>

<style scoped>

</style>