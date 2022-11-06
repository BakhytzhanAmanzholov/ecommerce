import {NavLink, useParams} from "react-router-dom";
import {Button} from "../../UI/Button/Button";
import {useDispatch, useSelector} from "react-redux";
import {logOutAction} from "../../redux/authReducer";
import {Ellipse} from "../../UI/Ellipse/Ellipse";
import {Footer} from "../../components/Footer/Footer";

import 'chart.js/auto';
import {Pie, Bar} from "react-chartjs-2";
import axios from "axios";
import {useEffect, useState} from "react";

import('./UserPage.css')

export const UserPage = () => {
    const dispatch = useDispatch()
    const {user, token} = useSelector(state => state.auth)
    const [messageToPartners, setMessageToPartners] = useState('')

    const {id} = useParams()

    const handleLogout = () => {
        dispatch(logOutAction())
    }

    const [analysis, setAnalysis] = useState(null)

    const randomColor = () => '#' + Math.floor(Math.random() * 16777215).toString(16)

    useEffect(() => {
        axios.get('https://hackathon-2022-app.herokuapp.com/api/users/analysis', {
            headers: {
                'Authorization': `Bearer ${token.accessToken}`
            }
        }).then(res => {
            setAnalysis({
                labels: res.data.categories?.map(el => el?.title || ''),
                datasets: res?.data?.categories?.map((el, i) => (
                    {
                        data: [el?.totalAmount || 0],
                        label: res.data.categories[i].title,
                        backgroundColor: [randomColor()]
                    }
                ))
            })
        })
    }, [])

    const handlePartnersSubmit = () => {
        axios.post('https://hackathon-2022-app.herokuapp.com/api/request/seller', {
            description: messageToPartners
        }, {
            headers: {
                'Authorization': `Bearer ${token.accessToken}`
            }
        })
            .then(res => {
                console.log(res.data)
            })
    }

    const handleMessageChange = e => {setMessageToPartners(e.target.value)}

    return (
        <div className="userPage" id="userPAge">
            <div className="container">
                <h1>Profile</h1>
                <section className={'accountData'}>
                    <div className="accountInfo">
                        <div className="accountInfoHead">
                            <Ellipse
                                size={'lg'}
                            />
                            <h1>{`${user?.name} ${user?.surname}` || 'Name'}</h1>
                            <p>{user?.email || 'Account'}</p>
                        </div>
                        <div className="accountInfoBtns">
                            <Button data-outline={true} onClick={handleLogout}>Logout</Button>
                            <Button data-outline={true} onClick={handleLogout}>Delete account</Button>
                        </div>
                    </div>
                    <div className="accountAnalyse">
                        {
                            analysis && <Bar
                                type="bar"
                                width={10}
                                height={10}
                                options={{
                                    title: {
                                        display: true,
                                        text: "Analysis",
                                        fontSize: 15
                                    },
                                    legend: {
                                        display: true,
                                        position: "bottom"
                                    },
                                    maintainAspectRatio: false
                                }}
                                data={analysis}
                            />
                        }
                    </div>
                </section>
                <section className={'siteAdditions'}>
                    <div className="sideAdditionLeft">
                        <ul>
                            <li><NavLink to={'/questions'}>Analyse your skin</NavLink></li>
                            <li><NavLink to={'/about'}>About</NavLink></li>
                            <li><NavLink to={'/shipment'}>Shipment</NavLink></li>
                        </ul>
                    </div>
                    <div className="sideAdditionRight">
                        <h1>Partners</h1>
                        <textarea
                            name="Message"
                            id="messageToPartners"
                            cols="30" rows="10"
                            value={messageToPartners}
                            onChange={handleMessageChange}
                        >
                        </textarea>
                        <div className="pertnersBtns">
                            <Button
                                onClick={handlePartnersSubmit}
                            >
                                Send
                            </Button>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    )
}