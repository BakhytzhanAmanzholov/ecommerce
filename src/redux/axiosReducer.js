const initialState = {
    status: null,
    loading: false,
    message: '',
}

const SET_LOADING_TRUE = 'SET_LOADING_TRUE'
const SET_LOADING_FALSE = 'SET_LOADING_FALSE'
const SET_DATA = 'SET_DATA'
const SET_INITIAL = 'SET_INITIAL'

export const axiosReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_LOADING_TRUE:
            return {...state, loading: true}
        case SET_LOADING_FALSE:
            return {...state, loading: false}
        case SET_DATA:
            return {...state, loading: false, status: action.payload.status, message: action.payload.message}
        case SET_INITIAL:
            return {status: null, loading: false, message: ''}
        default:
            return state
    }
}

export const setLoadingTrue = () => ({type: SET_LOADING_TRUE})
export const setLoadingFalse = () => ({type: SET_LOADING_FALSE})
export const setData = payload => ({type: SET_DATA, payload})
export const setInitial = () => ({type: SET_INITIAL})