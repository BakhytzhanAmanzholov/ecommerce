const initialState = {
    user: {
        id: null,
        name: '',
        surname: '',
        email: ''
    },
    token: null
}

const SET_CREDENTIALS = 'SET_CREDENTIALS'
const LOG_OUT = 'LOG_OUT'

export const authReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_CREDENTIALS:
            return {user: action.payload.user, token: action.payload.token}
        case LOG_OUT:
            return {user: null, token: null}
        default:
            return state
    }
}

export const setCredentialsAction = payload => ({type: SET_CREDENTIALS, payload})
export const logOutAction = () => ({type: LOG_OUT})