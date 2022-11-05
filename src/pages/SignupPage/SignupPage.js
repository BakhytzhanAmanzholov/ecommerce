import './SignupPage.css'
import {Form} from "../../UI/Form/Form";
import {useEffect, useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {Input} from "../../UI/Input/Input";
import {Button} from "../../UI/Button/Button";
import {NavLink, useNavigate} from "react-router-dom";
import {Ellipse} from "../../UI/Ellipse/Ellipse";
import {register} from "../../redux/asyncActions/authAsyncActions";

export const SignupPage = () => {
    const dispatch = useDispatch()
    const {user, token} = useSelector(state => state.auth)
    const navigate = useNavigate()

    const [form, setForm] = useState({
        name: '',
        surname: '',
        email: '',
        password: ''
    })

    const inputs = [
        {
            label: 'Name',
            type: 'text',
            name: 'name',
            value: form?.name,
            onChange: handleInputChange,
            id: 'registerName',
            autoComplete: 'off'
        }, {
            label: 'Surname',
            type: 'text',
            name: 'surname',
            value: form?.surname,
            onChange: handleInputChange,
            id: 'registerSurname',
            autoComplete: 'off'
        }, {
            label: 'Email',
            type: 'email',
            name: 'email',
            value: form?.email,
            onChange: handleInputChange,
            id: 'registerEmail',
            autoComplete: 'off'
        }, {
            label: 'Password',
            type: 'password',
            name: 'password',
            value: form?.password,
            onChange: handleInputChange,
            id: 'registerPassword',
            autoComplete: 'off'
        }
    ]

    function handleInputChange(e) {
        setForm(prevForm => ({...prevForm, [e.target.name]: e.target.value}))
    }

    function handleFormSubmit(e) {
        e.preventDefault()
        dispatch(register(form))
    }
    
    useEffect(() => {
        if (token){
            navigate('/')
        }
    }, [])

    return (
        <div className="signupPage" id="signupPage">
            <div className="container">
                <div className="signupLeft">
                    <Ellipse
                        size={'xl'}
                    />
                </div>
                <div className="sighupRight">
                    <h1>Create Account</h1>
                    <Form onSubmit={handleFormSubmit}>
                        {
                            inputs?.map(input => (
                                <Input
                                    key={input.id}
                                    props={input}
                                />
                            ))
                        }
                        <div className="additionLinks">
                            <NavLink to={'/login'}>Already have an account?</NavLink>
                        </div>
                        <Button type={'submit'} data-color={'purple'}>
                            Sign Up
                        </Button>
                    </Form>
                </div>
            </div>
        </div>
    )
}