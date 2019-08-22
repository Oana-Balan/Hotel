import React from 'react';
import axios from 'axios';
import LoginAdmin from "../components.login/LoginAdmin";

class UpdateUser extends React.Component {
    constructor(){
        super();
        this.state = {
            nume:'',
            email:'',
            id:''
        };
    }

    handleChange = event => {
        const state = this.state;
        state[event.target.name] = event.target.value;
        this.setState(state);
    };

    handleSubmit = event => {
        event.preventDefault();

        const {nume, email, id} = this.state;

        axios.put(`http://localhost:8085/spring/admin/User/${nume}/${email}/${id}`)
            .then(res => {
                console.log(res);
                console.log(res.data);
            });
        alert("Utilizatorul a fost editat!");
    };

    render() {
        const {nume,email,id} = this.state;
        return (
            <div>
                <LoginAdmin/>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <h1 align = "center">Introduceti id-ul utilizatorului pentru care se face editarea:</h1>
                    </div>
                    <h3 align = "center">
                        <label>
                            <li>Id utilizator</li>
                            <input type="text" name="id" value={id} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <div>
                        <h1 align = "center">Introduceti datele noi pentru editare:</h1>
                    </div>
                    <h3 align = "center">
                        <label>
                            <li>Nume nou</li>
                            <input type="text" name="nume" value={nume} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Email nou</li>
                            <input type="text" name="email" value={email} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <button type="submit">Editare</button>
                    </h3>
                </form>
            </div>
        )
    }
}

export default UpdateUser;