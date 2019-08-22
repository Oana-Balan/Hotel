import React from 'react';
import axios from 'axios';
import LoginAdmin from "../components.login/LoginAdmin";

class UpdateUser extends React.Component {
    constructor(){
        super();
        this.state = {
            nr:'',
        };
    }

    handleChange = event => {
        const state = this.state;
        state[event.target.name] = event.target.value;
        this.setState(state);
    };

    handleSubmit = event => {
        event.preventDefault();

        const {nr} = this.state;

        axios.post(`http://localhost:8085/spring/admin/raport/${nr}`)
            .then(res => {
                console.log(res);
                console.log(res.data);
            });
    };

    render() {
        const {nr} = this.state;
        return (
            <div>
                <LoginAdmin/>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <h1 align = "center">Introduceti numarul de inchirieri pentru care se doreste un raport:</h1>
                    </div>
                    <h3 align = "center">
                        <label>
                            <li>Numar</li>
                            <input type="text" name="nr" value={nr} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <button type="submit">Creare raport</button>
                    </h3>
                </form>
            </div>
        )
    }
}

export default UpdateUser;