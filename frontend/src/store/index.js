import {createStore} from 'Vuex';

export default createStore ({
    state: {
        score: 0
    },
    mutations: {
        incrementScore() {
            this.state.score += 1;
        },
        resetScore() {
            this.state.score = 0;
        }

    },
})
