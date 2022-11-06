import {NavLink, useParams} from "react-router-dom";
import {Button} from "../../UI/Button/Button";
import {useDispatch, useSelector} from "react-redux";
import {logOutAction} from "../../redux/authReducer";
import {Ellipse} from "../../UI/Ellipse/Ellipse";
import {Footer} from "../../components/Footer/Footer";

import 'chart.js/auto';
import { Pie } from "react-chartjs-2";

import('./UserPage.css')

export const UserPage = () => {
    const dispatch = useDispatch()
    const {user, token} = useSelector(state => state.auth)

    const {id} = useParams()

    const handleLogout = () => {
        dispatch(logOutAction())
    }


    const pieChartData = {
        labels: ["October", "November", "December"],
        datasets: [{
            data: [8137119, 9431691, 10266674],
            label: "Infected People",
            backgroundColor: ["#2FDE00", "#00A6B4", "#ff6600"],
            hoverBackgroundColor: ["#175000", "#003350", "#993d00"]
        }]
    };


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
                        <Pie
                            type="pie"
                            width={10}
                            height={10}
                            options={{
                                title: {
                                    display: true,
                                    text: "COVID-19 Cases of Last 3 Months",
                                    fontSize: 15
                                },
                                legend: {
                                    display: true, //Is the legend shown?
                                    position: "top" //Position of the legend.
                                },
                                maintainAspectRatio: false
                            }}
                            data={pieChartData}
                        />
                    </div>
                </section>
                <section className={'siteAdditions'}>
                    <div className="sideAdditionLeft">
                        <ul>
                            <li><NavLink to={'/questions'}>Questionare</NavLink></li>
                            <li><NavLink to={'/about'}>About</NavLink></li>
                            <li><NavLink to={'/shipment'}>Shipment</NavLink></li>
                            <li><NavLink to={'/analyseMySkin'}>Analyse your skin</NavLink></li>
                        </ul>
                    </div>
                    <div className="sideAdditionRight">
                        <h1>Partners</h1>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium adipisci at,
                            blanditiis deserunt dolor esse expedita facilis illo iste, maxime mollitia nam
                            necessitatibus, neque nihil nulla reiciendis sequi sunt!</p>
                        <Button>
                            Send
                        </Button>
                    </div>
                </section>
            </div>
        </div>
    )
}