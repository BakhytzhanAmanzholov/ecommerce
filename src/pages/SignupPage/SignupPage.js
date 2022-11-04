import './SignupPage.css'
import {Form} from "../../UI/Form/Form";
import {useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {Input} from "../../UI/Input/Input";
import {Button} from "../../UI/Button/Button";
import {register} from "../../redux/asyncActions/authAsyncActions";

export const SignupPage = () => {
    const dispatch = useDispatch()
    const {user, token} = useSelector(state => state.auth)

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
        dispatch(setForm({[e.target.name]: e.target.value}))
    }

    async function handleFormSubmit(e) {
        e.preventDefault()
        dispatch(register(form))
    }

    return (
        <div className="signupPage" id="signupPage">
            <div className="container">
                <div className="signupLeft">
                    <h1>Left</h1>
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
                        <Button type={'submit'}>
                            Sign Up
                        </Button>
                    </Form>
                </div>
            </div>
        </div>
    )
}