import {createStore, combineReducers, applyMiddleware} from 'redux'
import {composeWithDevTools} from "redux-devtools-extension"
import {authReducer} from "./authReducer"
import thunk from "redux-thunk"
import {axiosReducer} from "./axiosReducer";
import {productsReducer} from "./productsReducer";

const rootReducer = combineReducers({
    auth: authReducer,
    api: axiosReducer,
    products: productsReducer
})

export const store = createStore(rootReducer, composeWithDevTools(applyMiddleware(thunk)))