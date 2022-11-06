const initialState = [
    {}
]

const SET_QUESTIONS = 'SET_QUESTIONS'

export const questionsReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_QUESTIONS:
            return [...action.payload]
        default:
            return state
    }
}

export const setQuestions = payload => ({type: SET_QUESTIONS, payload})