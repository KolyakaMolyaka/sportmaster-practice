<script>
import TopLogo from './components/TopLogo.vue';
import QuizzesList from './components/QuizzesList.vue';

const testAPIUrl = 'https://jsonplaceholder.typicode.com/todos?_limit=10'
const getQuizzesAPIUrl = 'http://127.0.0.1:8080/quizzes'
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
      ],
    }
  },
  methods: {
    fetchQuizzes() {
      fetch(getQuizzesAPIUrl)
      .then(response => response.json())
      .then(json => this.quizzes = json);
    },
    
  }
}

</script>

<template>
  <button @click="fetchQuizzes">Загрузить викторины</button>
  <div class="col-md-10 mx-auto">
    <TopLogo/>
    <QuizzesList :quizzes="quizzes"/>
  </div>
</template>

<style scoped>

</style>
