import axios from "axios"
import {setCredentialsAction} from "../authReducer"
import {changeRegisterData} from "../registerReducer";
import {changeLoginData} from "../loginReducer";

export const register = payload =>
    dispatch => {
        dispatch(changeRegisterData({loading: true}))
        return axios.post('http://localhost:5000/api/auth/register', {
            name: payload.name,
            surname: payload.surname,
            email: payload.email,
            password: payload.password
        })
            .then(res => {
                if (res.status !== 200 && res.status !== 201) return
                dispatch(changeRegisterData({
                    name: '',
                    surname: '',
                    email: '',
                    password: '',
                    success: true,
                    loading: false,
                    message: res.statusText
                }))
            })
            .catch(e => {
                dispatch(changeRegisterData({success: false, loading: false, message: e.message}))
                throw e
            })
    }

export const login = payload =>
    dispatch => {
        dispatch(changeLoginData({loading: true}))
        axios.post('http://localhost:5000/api/auth/login', {
            email: payload.email,
            password: payload.password
        })
            .then(res => {
                if (res.status !== 200) return
                dispatch(changeLoginData({
                    email: '',
                    password: '',
                    success: true,
                    loading: false,
                    message: res.statusText
                }))

                const data = {
                    user: {
                        id: res.data.userId,
                        name: res.data.name,
                        surname: res.data.surname,
                        email: payload.email,
                        password: payload.password,
                    },
                    token: res.data.token
                }
                dispatch(setCredentialsAction({...data}))
            })
            .catch(e => {
                dispatch(changeLoginData({success: false, loading: false, message: e.message}))
                throw e
            })
    }