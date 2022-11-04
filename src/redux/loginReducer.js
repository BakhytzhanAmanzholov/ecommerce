const initialState = {
    loading: false,
    success: null,
    message: ''
}

const CHANGE_LOGIN_DATA = 'CHANGE_LOGIN_DATA'

export const loginReducer = (state = initialState, action) => {
    switch (action.type) {
        case CHANGE_LOGIN_DATA:
            return {...state, ...action.payload}
        default:
            return state
    }
}


export const changeLoginData = payload => ({type: CHANGE_LOGIN_DATA, payload})