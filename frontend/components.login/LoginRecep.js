import React from 'react';
import "./LoginAdmin.css";
import axios from "axios/index";
import logo2 from '../components.login/logo2.jpg';

class LoginRecep extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            id: ""
        };
    }

    componentDidMount() {
        const user = localStorage.getItem('myUser');
        const email = localStorage.getItem('myEmail');
        const pass = localStorage.getItem('myPassword');
        axios.get(`http://localhost:8085/spring/user/User/Email/${email}/Parola/${pass}/${user}`).then((response) => {
            const id = response.data;
            this.setState({id});
            localStorage.setItem('myId', id);
        })
    }

    render(){

        const style = {
            margin: 0,
            top: 80,
            right: 60,
            bottom: 616,
            left: 'auto',
            position: 'fixed',
        };
        return (

            <div>
                <div className="logo"/>
                <div className="navbarA">
                    <img src={logo2} width="45" height="45" align="left"/>
                    <a href="/addclient">Adaugare client</a>
                    <a href="/book">Rezervare camera</a>
                    <a href="/cancel">Anulare rezervare</a>
                    <a href="/bookings">Detalii rezervari</a>
                    <a href="/listcamsR">Lista camere</a>
                    <a href="/listclients">Lista clienti</a>
                    <a style={style} href="/logout">Delogare</a>
                </div>
                <h1 align ="center">Receptionistul {this.state.id}</h1>
            </div>

        )
    }

}

export default LoginRecep;