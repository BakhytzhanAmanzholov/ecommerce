import './ConsultationPage.css'
import axios from "axios";
import {useEffect, useState} from "react";
import {useSelector} from "react-redux";
import {Button} from "../../UI/Button/Button";
import {useNavigate} from "react-router-dom";

export const ConsultationPage = () => {
    const {user, token} = useSelector(state => state.auth)
    const navigate = useNavigate()

    const [experts, setExperts] = useState([])
    const [selectedExpert, setSelectedExpert] = useState(null)

    useEffect(() => {
        axios.get('https://hackathon-2022-app.herokuapp.com/api/users/cosmetologist', {
            headers: {
                'Authorization': `Bearer ${token.accessToken}`
            }
        })
            .then(res => {
                setExperts(res.data)
            })
    }, [])

    const handleSelectExpert = (id) => {
        setSelectedExpert(id)
    }

    const handleExpertSubmit = () => {
        navigate(`/user/${user?.id}/consultation/${selectedExpert}`)
    }

    return (
        <div className="consultationPage" id="consultationPage">
            <div className="container">
                <h1>Online consultation</h1>
                <div className="consultationList">
                    <div className="consultationer">
                        <div className="consultationLeft">
                            <h3>Select an expert</h3>
                        </div>
                        <div className="consultationRight">
                            <div className="expertsList">
                                {
                                    experts?.map(expert => (
                                        <div
                                            key={expert.id}
                                            className="expertItem"
                                            data-selected={expert.id === selectedExpert}
                                            onClick={() => handleSelectExpert(expert.id)}
                                        >
                                            <h3>{expert?.name} {expert?.surname}</h3>
                                            <h5>{expert?.email}</h5>
                                        </div>
                                    ))
                                }
                            </div>
                            <div className="consultationerBtns">
                                <Button
                                    onClick={handleExpertSubmit}
                                >Select</Button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}