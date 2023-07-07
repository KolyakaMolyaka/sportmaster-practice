<template>
    <div class="h-100 d-flex justify-content-evenly align-items-center mt-5">
        <div class="quiz-card mt-3 alert alert-color">
            <h1 class="mt-3 fw-bold text-white">Правильных ответов:  {{ $route.query.score }} </h1>
            <div class="card fs-5 mt-3 mb-3 mx-auto">
                Вам есть куда стремиться. Попробуйте играть чаще и тогда вы улучшите свой результат!
            </div>
        </div>
    </div>
</template>

<script>
export default {

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