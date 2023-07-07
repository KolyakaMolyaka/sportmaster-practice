<template>
    <h1 class="text-center mt-5 fw-bold text-white"> {{ quiz.title }} </h1>
    <div class="card fs-5 mt-3 mx-auto"> {{ quiz.description }} </div>
    <div class="d-flex justify-end justify-content-end mt-4">
        <router-link to="/quiz" class="btn btn-primary fw-bold ps-4 pe-4 pt-3 pb-3">Пройти</router-link>
        <!-- <a href="#" class="btn btn-primary fw-bold ps-4 pe-4 pt-3 pb-3">Пройти</a> -->
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