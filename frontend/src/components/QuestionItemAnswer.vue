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
            console.log(event.target.classList.toggle('btn-info'));
            this.$emit('handleAnswer', this.answer, this.questionId);
        }
    }
}

</script>
<style scoped>

.btn-info {
    background: lightcoral !important;
    color: white;
}
 

</style>