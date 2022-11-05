import './SigninPage.css'
import {useDispatch, useSelector} from "react-redux";
import {useEffect, useState} from "react";
import {Form} from "../../UI/Form/Form";
import {Input} from "../../UI/Input/Input";
import {Button} from "../../UI/Button/Button";
import {login} from "../../redux/asyncActions/authAsyncActions";
import {Ellipse} from "../../UI/Ellipse/Ellipse";
import {NavLink, useNavigate} from "react-router-dom";

// import photo from '../../assets/img/authPages/loginPage.png'

export const SigninPage = () => {
    const dispatch = useDispatch()
    const {user, token} = useSelector(state => state.auth)
    const navigate = useNavigate()

    const [form, setForm] = useState({
        email: '',
        password: ''
    })

    const inputs = [
        {
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
        dispatch(login(form))
    }

    useEffect(() => {
        if (token){
            navigate('/')
        }
    }, [])


    return (
        <div className="signinPage" id="signinPage">
            <div className="container">
                <div className="signinLeft">
                    <h1>Login to the site</h1>
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
                            <NavLink to={'/resetPassword'}>Forgot?</NavLink>
                            <NavLink to={'/registration'}>Register</NavLink>
                        </div>
                        <Button type={'submit'}>
                            Sign In
                        </Button>
                    </Form>
                </div>
                <div className="signinRight">
                    <Ellipse
                        size={'xl'}
                    />
                </div>
            </div>
        </div>
    )
}