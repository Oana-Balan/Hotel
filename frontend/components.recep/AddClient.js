import React from 'react';
import axios from 'axios';
import LoginRecep from "../components.login/LoginRecep";

class AddClient extends React.Component {
    constructor(){
        super();
        this.state = {
            nume: '',
            prenume: '',
            telefon:'',
            adresa: '',
            camereInchiriate:''
        };
    }

    handleChange = event => {
        const state = this.state;
        state[event.target.name] = event.target.value;
        this.setState(state);
    };

    handleSubmit = event => {
        event.preventDefault();
        const {nume,prenume,telefon,adresa,camereInchiriate} = this.state;

        axios.post(`http://localhost:8085/spring/recep/insertClient`, {nume,prenume,telefon,adresa,camereInchiriate})
            .then(res => {
                console.log(res);
                console.log(res.data);
            });
        alert("Clientul a fost introdus!");
    };

    render() {
        const {nume,prenume,telefon,adresa} = this.state;
        return (
            <div>
                <LoginRecep/>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <h1 align = "center">Introduceti datele clientului pentru inserare:</h1>
            </div>
                    <h3 align = "center">
                        <label>
                            <li>Nume client</li>
                            <input type="text" name="nume" value={nume} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Prenume client</li>
                            <input type="text" name="prenume" value={prenume} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                    <label>
                        <li>Telefon client</li>
                        <input type="text" name="telefon" value={telefon} onChange={this.handleChange} />
                    </label>
                     </h3>
                    <h3 align = "center">
                        <label>
                            <li>Adresa client</li>
                            <input type="text" name="adresa" value={adresa} onChange={this.handleChange} />
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

export default AddClient;