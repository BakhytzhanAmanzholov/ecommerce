import axios from "axios"
import {setCredentialsAction} from "../authReducer"
import {changeRegisterData} from "../registerReducer";
import {changeLoginData} from "../loginReducer";
import {setData, setInitial, setLoadingFalse, setLoadingTrue} from "../axiosReducer";

export const register = payload =>
    dispatch => {
        console.log(payload)
        dispatch(setLoadingTrue())
        return axios.post('https://hackathon-2022-app.herokuapp.com/api/registration', {
            name: payload.name,
            surname: payload.surname,
            email: payload.email,
            password: payload.password
        })
            .then(res => {
                if (res.status !== 200 && res.status !== 201) return dispatch(setData({
                    status: res.status,
                    message: res.data.message,
                    loading: false
                }))
                console.log(res.data)
                dispatch(setLoadingFalse())
            })
            .catch(e => {
                dispatch(setData({status: e.status, message: e.message, loading: false}))
                throw e
            })
    }

export const login = payload =>
    dispatch => {
        dispatch(setLoadingTrue())
        axios.post('https://hackathon-2022-app.herokuapp.com/api/auth/token', new URLSearchParams({
            email: payload.email,
            password: payload.password
        }), {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        })
            .then(res => {
                if (res.status !== 200) return dispatch(setData({
                    status: res.status,
                    message: res.data.message,
                    loading: false
                }))
                console.log(res.data)

                dispatch(setLoadingFalse())

                const data = {
                    user: {
                        id: res.data.id,
                        name: res.data.name,
                        surname: res.data.surname,
                        email: payload.email,
                        // password: payload.password,
                    },
                    token: res.data.token
                }
                dispatch(setCredentialsAction(data))
            })
            .catch(e => {
                dispatch(setData({status: e.status, loading: false, message: e.message}))
                throw e
            })
    }