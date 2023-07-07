<script>
import TopLogo from './components/TopLogo.vue';
import QuizzesList from './components/QuizzesList.vue';
export default {
  components: { TopLogo, QuizzesList },
  data() {
    return {
      quizzes: [
        {id: 1, title: 'Quiz #1', description: 'Quiz #1 description'},
        {id: 2, title: 'Quiz #2', description: 'Quiz #2 description'},
        {id: 3, title: 'Quiz #3', description: 'Quiz #3 description'},
        {id: 4, title: 'Quiz #4', description: 'Quiz #4 description'},
        {id: 5, title: 'Quiz #5', description: 'Quiz #5 description'},
      ]
    }
  }
}

</script>

<template>
  <div class="col-md-10 mx-auto">
    <TopLogo/>
    <QuizzesList :quizzes="quizzes"/>
  </div>
</template>

<style scoped>

</style>
