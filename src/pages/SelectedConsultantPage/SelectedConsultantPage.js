import './SelectedConsultantPage.css'
import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import {useSelector} from "react-redux";
import {Button} from "../../UI/Button/Button";

export const SelectedConsultantPage = () => {
    const {user, token} = useSelector(state => state.auth)
    const {id, consultandId} = useParams()

    const [consultant, setConsultant] = useState(null)

    useEffect(() => {
        axios.get(`https://hackathon-2022-app.herokuapp.com/api/users/cosmetologist/${consultandId}`, {
            headers: {
                'Authorization': `Bearer ${token.accessToken}`
            }
        })
            .then(res => {
                setConsultant(res.data)
            })
    }, [])

    return(
        <div className="selectedConsultantPage" id="selectedConsultantPage">
            <div className="container">
                <div className="consultantInfo">
                    <h1>{consultant?.name} {consultant?.surname}</h1>
                    <div className="consultantSpheres">
                            {
                                consultant?.spheres?.map(el => (
                                    <div key={el.id} className={'consultantSphere'}>
                                        <h3>{el?.state}</h3>
                                        <h5>{el?.price}</h5>
                                        <div className="consultantTime">
                                            {
                                                el?.time?.map(time => (
                                                    <Button
                                                        data-color={'purple'}
                                                        data-outline={true}
                                                    >
                                                        {time.time}
                                                    </Button>
                                                ))
                                            }
                                        </div>
                                    </div>
                                ))
                            }
                    </div>
                </div>
            </div>
        </div>
    )
}