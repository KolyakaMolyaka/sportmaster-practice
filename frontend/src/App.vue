<script>
import TopLogo from './components/TopLogo.vue';
import QuizzesList from './components/QuizzesList.vue';

const testAPIUrl = 'https://jsonplaceholder.typicode.com/todos?_limit=10'
const getQuizzesAPIUrl = 'http://127.0.0.1:8080/quizzes'
export default {
  components: { TopLogo, QuizzesList },
  data() {
    return {
      quizzes: [], 
    }
  },
  methods: {
    fetchQuizzes() {
      fetch(getQuizzesAPIUrl)
      .then(response => response.json())
      .then(json => this.quizzes = json);
    },
  },
  mounted() {
    this.fetchQuizzes();
  }
}

</script>

<template>
  <div class="col-md-10 mx-auto">
    <TopLogo/>

    <QuizzesList v-if="quizzes.length" :quizzes="quizzes"/>
    <div v-else class="alert alert-info mt-3 fs-3 text-lightblue">
      Викторины отсутствуют.
    </div>

  </div>
</template>

<style scoped>

</style>
