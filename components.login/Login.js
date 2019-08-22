import React from "react";
import { Button, FormGroup, FormControl, ControlLabel } from "react-bootstrap";
import axios from 'axios';
import "./Login.css";

class Login extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: "",
            user: ""
        };
    }
    validateForm() {
        return this.state.email.length > 0 && this.state.password.length > 0;
    }

    handleChange = event => {
        this.setState({
            [event.target.id]: event.target.value
        });
    };

    handleSubmit = event => {
        event.preventDefault();
        const { email, password } = this.state;
        localStorage.setItem('myEmail', email);
        localStorage.setItem('myPassword', password);
        axios.get(`http://localhost:8085/spring/user/User/Email/${email}/Parola/${password}`).then((response) => {
            const user = response.data;
            this.setState({ user });
            localStorage.setItem('myUser', response.data);
                    if(user === "recep"){
                        this.props.history.push('/loginrecep');
                    }else if(user === "admin") {
                        this.props.history.push('/loginadmin');
                    }else{
                        alert("Datele introduse sunt invalide!");
                        this.props.history.push('/home');
                    }
        })
    };

    render() {
        return (
            <div>
            <div className="Login">
                <form onSubmit={this.handleSubmit}>
                    <h3 align="center">
                        <FormGroup controlId="email" bsSize="large">
                            <ControlLabel>Cont</ControlLabel>
                            <FormControl
                                autoFocus
                                type="email"
                                value={this.state.email}
                                onChange={this.handleChange}
                            />
                        </FormGroup>
                    </h3>
                    <h3 align="center">
                        <FormGroup controlId="password" bsSize="large">
                            <ControlLabel>Parola </ControlLabel>
                            <FormControl
                                value={this.state.password}
                                onChange={this.handleChange}
                                type="password"
                            />
                        </FormGroup>
                    </h3>
                    <h3 align="center">
                        <Button block bsSize="large" disabled={!this.validateForm()}  type="submit" >
                            Login
                        </Button>
                    </h3>
                </form>
            </div>
            </div>
        );
    }
}

export default Login;