import './ConsultationCostPage.css'
import {Ellipse} from "../../UI/Ellipse/Ellipse";
import {Form} from "../../UI/Form/Form";
import {Input} from "../../UI/Input/Input";
import {NavLink, useNavigate} from "react-router-dom";
import {Button} from "../../UI/Button/Button";
import s from "../../UI/Question/Question.module.css";
import {useSelector} from "react-redux";
import {useState} from "react";
import axios from "axios";

export const ConsultationCostPage = () => {
    const {user, token} = useSelector(state => state.auth)
    const navigate = useNavigate()

    const [consultationCost, setConsultationCost] = useState(null)

    const consultationCosts = [
        {
            id: 1,
            costDollar: 100,
            costTg: 45000,
            date: 'Year'
        }, {
            id: 2,
            costDollar: 10,
            costTg: 4500,
            date: 'Month'
        }
    ]

    const handleSubmitConsultationer = async () => {
        await axios.post('https://hackathon-2022-app.herokuapp.com/api/users/subscription', {}, {
            headers: {
                'Authorization': `Bearer ${token.accessToken}`
            }
        })
            .then(res => {
                // console.log(res)
            })
        navigate(`/user/${user.id}/consultation`)
    }

    const handleConsultationCostSelect = (e) => {
        setConsultationCost(e.target.value)
    }

    return (
        <div className="consultationCostPage" id="consultationCostPage">
            <div className="container">
                <div className="consultationCostPageLeft">
                    <Ellipse
                        size={'xl'}
                    />
                </div>
                <div className="consultationCostPageRight">
                    <h1>Consultation cost</h1>
                    <div className="consultationCosts">
                        {
                            consultationCosts?.map(cost => (
                                <div
                                    key={cost.id}
                                >
                                    <input
                                        id={cost.id}
                                        type={'radio'}
                                        value={cost.id}
                                        onChange={handleConsultationCostSelect}
                                        name={'consultationCost'}
                                    />
                                    <label htmlFor={cost.id}>{cost.costDollar}$ / {cost.costTg}tg - {cost.date}</label>
                                </div>
                            ))
                        }
                    </div>
                    <div className="consultationBtns">
                        {
                            consultationCost && <Button
                                onClick={handleSubmitConsultationer}
                            >
                                Select
                            </Button>
                        }
                    </div>
                </div>
            </div>
        </div>
    )
}