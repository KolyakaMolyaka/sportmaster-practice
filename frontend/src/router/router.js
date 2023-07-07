import { createRouter, createWebHistory } from "vue-router"

import QuizzesPage from "@/pages/QuizzesPage.vue"
import CurrentQuizPage from "@/pages/CurrentQuizPage.vue"


const routes = [
    {
        path: '/',
        component: QuizzesPage
    },
    {
        path: '/quiz',
        component: CurrentQuizPage
    }
]

const router = createRouter({
    routes,
    history: createWebHistory(),
})

export default router;