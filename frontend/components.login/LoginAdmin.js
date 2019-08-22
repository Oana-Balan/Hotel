import React from 'react';
import axios from "axios/index";
import logo2 from '../components.login/logo2.jpg';
import './LoginAdmin.css';

class LoginAdmin extends React.Component {
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
                        <a href="/adduser">Adaugare utilizator</a>
                        <a href="/updateuser">Editare utilizator</a>
                        <a href="/listusers">Lista utilizatori</a>
                        <a href="/addcam">Adaugare camera</a>
                        <a href="/listcams">Lista camere</a>
                        <a href="/raport">Raport clienti</a>
                        <a style={style} href="/logout">Delogare</a>
                    </div>
                    <div>
                        <h1 align ="center">Administratorul {this.state.id}</h1>
                    </div>
                </div>


        )
    }

}

export default LoginAdmin;