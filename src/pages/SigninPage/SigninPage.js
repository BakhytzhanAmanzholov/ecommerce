import './SigninPage.css'
import {useDispatch, useSelector} from "react-redux";
import {useState} from "react";
import {Form} from "../../UI/Form/Form";
import {Input} from "../../UI/Input/Input";
import {Button} from "../../UI/Button/Button";
import {login} from "../../redux/asyncActions/authAsyncActions";

export const SigninPage = () => {
    const dispatch = useDispatch()
    const {user, token} = useSelector(state => state.auth)

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
        dispatch(setForm({[e.target.name]: e.target.value}))
    }

    async function handleFormSubmit(e) {
        e.preventDefault()
        dispatch(login(form))
    }


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
                        <Button type={'submit'}>
                            Sign In
                        </Button>
                    </Form>
                </div>
                <div className="signinRight">
                    <h1>Right</h1>
                </div>
            </div>
        </div>
    )
}