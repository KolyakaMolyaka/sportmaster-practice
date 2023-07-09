<template>
    <div class="h-100 d-flex justify-content-evenly align-items-center mt-5">
        <div class="quiz-card mt-3 alert alert-color">
            <h1 class="mt-3 fw-bold text-white">Правильных ответов:  
                {{ $store.getters.scores }} / {{ $store.getters.fullScores }}
            </h1>
            <div class="card fs-5 mt-3 mb-3 mx-auto">
                <span v-if="$store.getters.scores == $store.getters.fullScores">{{ advices['fullScore'] }}</span>
                <span v-else-if="$store.getters.scores / $store.getters.fullScores < 0.5">{{ advices['ltHalf'] }}</span>
                <span v-else="$store.getters.scores / $store.getters.fullScores > 0.5">{{ advices['gtHalf'] }}</span>
                
                
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            advices: {
                'ltHalf': 'Вам есть куда стремиться. Попробуйте играть чаще и тогда вы улучшите свой результат!',
                'gtHalf': 'Вы набрали половину правильных ответов, так держать!',
                'fullScore': 'Вы прекрасно разбираетесь в теме.'

            }
        }
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

.quiz-card {
    width: 650px;
    padding: 10px;
    background-color: #505e86;
    border-radius: 9px;
}
</style>