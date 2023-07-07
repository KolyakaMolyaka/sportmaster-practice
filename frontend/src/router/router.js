import { createRouter, createWebHistory } from "vue-router"

import QuizzesPage from "@/pages/QuizzesPage.vue"
import CurrentQuizPage from "@/pages/CurrentQuizPage.vue"
import QuizResultsPage from "@/pages/QuizResultsPage.vue"


const routes = [
    {
        path: '/',
        component: QuizzesPage
    },
    {
        path: '/quiz',
        component: CurrentQuizPage
    },
    {
        path: '/quiz_results',
        component: QuizResultsPage
    }
]

const router = createRouter({
    routes,
    history: createWebHistory(),
})

export default router;