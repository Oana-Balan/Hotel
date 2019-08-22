import React from 'react';
import axios from 'axios';
import LoginAdmin from "../components.login/LoginAdmin";

class AddCam extends React.Component {
    constructor(){
        super();
        this.state = {
            numar: '',
            tip: '',
            disponibilitate:'',
            pret: ''
        };
    }

    handleChange = event => {
        const state = this.state;
        state[event.target.name] = event.target.value;
        this.setState(state);
    };

    handleSubmit = event => {
        event.preventDefault();
        const {numar,tip,disponibilitate,pret} = this.state;

        axios.post(`http://localhost:8085/spring/admin/insertCamera`, { numar,tip,disponibilitate,pret})
            .then(res => {
                console.log(res);
                console.log(res.data);
            });
        alert("Camera a fost introdusa!");
    };

    render() {
        const {numar,tip,pret} = this.state;
        return (
            <div>
                <LoginAdmin/>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <h1 align = "center">Introduceti datele camerei pentru inserare:</h1>
                    </div>
                    <h3 align = "center">
                        <label>
                            <li>Numar camera</li>
                            <input type="text" name="numar" value={numar} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Tip camera</li>
                            <input type="text" name="tip" value={tip} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Pret camera</li>
                            <input type="text" name="pret" value={pret} onChange={this.handleChange} />
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

export default AddCam;