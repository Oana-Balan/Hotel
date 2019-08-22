import React from 'react';
import axios from 'axios';
import LoginAdmin from "../components.login/LoginAdmin";

class AddUser extends React.Component {
    constructor(){
        super();
        this.state = {
            nume: '',
            prenume: '',
            email: '',
            parola:'',
            utilizator:''
        };
    }

    handleChange = event => {
        const state = this.state;
        state[event.target.name] = event.target.value;
        this.setState(state);
    };

    handleSubmit = event => {
        event.preventDefault();
        alert("Utilizatorul a fost introdus!");
        const {nume,prenume,email,parola,utilizator} = this.state;

        axios.post(`http://localhost:8085/spring/admin/insertUser`, { nume,prenume,email,parola,utilizator})
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
    };

    render() {
        const {nume,prenume,email,parola,utilizator} = this.state;
        return (
            <div>
                <LoginAdmin/>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <h1 align = "center">Introduceti datele utilizatorului pentru inserare:</h1>
                    </div>
                    <h3 align = "center">
                        <label>
                            <li>Nume utilizator</li>
                            <input type="text" name="nume" value={nume} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Prenume utilizator</li>
                            <input type="text" name="prenume" value={prenume} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Email utilizator</li>
                            <input type="text" name="email" value={email} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Parola utilizator</li>
                            <input type="text" name="parola" value={parola} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Tip utilizator</li>
                            <input type="text" name="utilizator" value={utilizator} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <button type="submit">Insereaza</button>
                    </h3>
                </form>
            </div>
        )
    }
}

export default AddUser;