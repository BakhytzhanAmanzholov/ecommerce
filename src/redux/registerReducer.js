const initialState = {
    name: '',
    surname: '',
    email: '',
    password: '',
    loading: false,
    success: null,
    message: ''
}

const CHANGE_REGISTER_DATA = 'CHANGE_REGISTER_DATA'
const REGISTER = 'REGISTER'
const LOGIN = 'LOGIN'

export const registerReducer = (state = initialState, action) => {
    switch (action.type) {
        case CHANGE_REGISTER_DATA:
            return {...state, ...action.payload}
        default:
            return state
    }
}


export const changeRegisterData = payload => ({type: CHANGE_REGISTER_DATA, payload})