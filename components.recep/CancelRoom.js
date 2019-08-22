import React from 'react';
import axios from 'axios';
import LoginRecep from '../components.login/LoginRecep';

class CancelRoom extends React.Component {
    state = {
        nume: '',
        numar:''
    };

    handleChange = event => {
        this.setState({ nume: event.target.value,
            numar: event.target.value});
    };

    handleSubmit = event => {
        event.preventDefault();
        alert("Rezervarea a fost stearsa!");
        axios.post(`http://localhost:8085/spring/recep/Cancel/${this.state.nume}/${this.state.numar}`)
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
    };

    render() {
        return (
            <div>
                <LoginRecep/>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <h1 align = "center">Introduceti numele clientului care a facut rezervarea si numarul camerei:</h1>
                    </div>
                    <h3 align="center">
                        <label>
                            <li>Nume client</li>
                            <input type="text" name="nume" onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align="center">
                        <label>
                            <li>Numar camera</li>
                            <input type="text" name="numar" onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align="center">
                        <button type="submit">Anulare</button>
                    </h3>
                </form>
            </div>
        )
    }
}

export default CancelRoom;