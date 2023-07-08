<template>
    <h1 class="text-center mt-5 fw-bold text-white"> {{ quiz.title }} </h1>
    <div class="card fs-5 mt-3 mx-auto ps-4 pe-4" style="text-align: justify;"> 
        {{ quiz.description }} 
        <span class="d-inline-flex justify-content-end fs-6 mt-2 "><em>Дата создания: {{ quiz.created_at }}</em></span>
    </div>

    <div class="d-flex mt-4">
        <div class="d-flex align-items-start flex-column">
            <div class="btn btn-info text-white fw-bold">
                Категория: {{quiz.category}}
            </div>
            <div v-if="quiz.difficulty == 'Легкий'" class="btn btn-success mt-2 fw-bold text-white">Уровень сложности: {{  quiz.difficulty }}</div>
            <div v-else-if="quiz.difficulty == 'Средний'" class="btn btn-warning mt-2 fw-bold">Уровень сложности: {{  quiz.difficulty }}</div>
            <div v-else class="btn btn-danger mt-2 fw-bold text-white">Уровень сложности: {{  quiz.difficulty }}</div>
        </div>
        <button 
        style="background-color: #cb585d !important;"
        @click="$router.push(`/quiz/${quiz.id}`)" class="btn btn-primary fw-bold ps-4 pe-4 pt-3 pb-3 ms-auto">Пройти</button>
    </div>
</template>

<script>
export default {
    props: {
        quiz: {
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