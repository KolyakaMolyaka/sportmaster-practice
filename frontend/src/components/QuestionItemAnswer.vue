<template>
    <button
    class="btn btn-primary d-block w-50 text-start p-3 ps-5 fs-5 mt-3 rounded-pill mx-auto"
    @click="activateChoice"
    >
        {{ answer.text }}
    </button>


</template>

<script>
export default {
    props: {
        answer: {
            type: Object,
            required: true
        },
        questionId: {
            // type: Integer
            required: true
        }
    }, 
    methods: {
        activateChoice(event) {
            if (this.answer.isCorrect) {
                event.target.classList.toggle('btn-success');
            } else {
                event.target.classList.toggle('btn-danger');

            }
            this.$emit('handleAnswer', this.answer, this.questionId);
        }
    }
}

</script>
<style scoped>

.btn-danger {
    background: red !important;
    color: white;
}

.btn-success {
    background: green !important;
    /* color: white; */
}

</style>