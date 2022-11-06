const initialState = [
    {}
]

const SET_PRODUCTS = 'SET_PRODUCTS'

export const productsReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_PRODUCTS:
            return [...action.payload]
        default:
            return state
    }
}

export const setProducts = payload => ({type: SET_PRODUCTS, payload})