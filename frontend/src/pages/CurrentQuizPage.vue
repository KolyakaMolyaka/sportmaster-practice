<template>
    <div>
        <CurrentQuizItem :quizId="quizId" :key="quizId"/>
        <div class="text-center">
            <button
            @click="$router.push({path: '/quiz_results', query: {score: $store.state.score}})" 
            class="btn btn-primary btn-color rounded-3 p-3 m-5 fs-4">Закончить прохождение</button>
        </div>
    </div>
    
</template>

<script>
import CurrentQuizItem from '@/components/CurrentQuizItem.vue';

export default {
    components: { CurrentQuizItem },
    data() {
        return {
            questions: null,
            quizId: this.$route.params.id,
        }
    }
}
</script>

<style scoped >
.alert-color {
    background-color: #505e86 !important;
    border-radius: 9px;
}

</style>