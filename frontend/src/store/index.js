import {createStore} from 'Vuex';

export default createStore ({
    state: {
        fullScore: 0,
        score: 0
    },
    getters: {
        fullScores(state) {
            return state.fullScore;
        },
        scores(state) {
            return state.score;

        }

    },
    mutations: {
        incrementScore() {
            this.state.score += 1;
        },
        resetScore() {
            this.state.score = 0;
        },
        setFullScore(newFullScore) {
            this.state.fullScore = newFullScore;
        }

    },
})
