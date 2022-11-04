import {createStore, combineReducers, applyMiddleware} from 'redux'
import {composeWithDevTools} from "redux-devtools-extension"
import {authReducer} from "./authReducer"
import thunk from "redux-thunk"
import {registerReducer} from "./registerReducer"
import {loginReducer} from "./loginReducer"

const rootReducer = combineReducers({
    auth: authReducer,
    register: registerReducer,
    login: loginReducer,
})

export const store = createStore(rootReducer, composeWithDevTools(applyMiddleware(thunk)))