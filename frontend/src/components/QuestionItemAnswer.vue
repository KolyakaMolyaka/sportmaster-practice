<template>
    <button
    class="btn btn-primary d-block w-50 text-start p-3 ps-5 fs-5 mt-3 rounded-pill mx-auto"
    @click="handleAnswer"
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
        }
    }, 
    methods: {
        handleAnswer() {
            if (answer.isCorrect) {
                // console.log('wrongAnswer');
                // this.$emit('wrongAnswer', this.answer);
            } else {
                console.log('rightAnswer');
                // this.$emit('rightAnswer', this.answer);
            }
        }
    }

}

</script>


<style>
</style>