import React from 'react';
import axios from 'axios';
import LoginRecep from "../components.login/LoginRecep";

class BookRoom extends React.Component {
    constructor(){
        super();
        this.state = {
            numeClient: '',
            nrCamera: '',
            dataSosire:'',
            dataPlecare: '',
            price:''
        };
    }

    handleChange = event => {
        const state = this.state;
        state[event.target.name] = event.target.value;
        this.setState(state);
    };

    handleSubmit = event => {
        event.preventDefault();
        const  idUser = localStorage.getItem('myId');
        const {numeClient,nrCamera,dataSosire,dataPlecare} = this.state;
        localStorage.setItem('myClient', numeClient);
        localStorage.setItem('myCamera', nrCamera);
        localStorage.setItem('mySosire', dataSosire);
        localStorage.setItem('myPlecare', dataPlecare);
        axios.post(`http://localhost:8085/spring/recep/Booking`, {idUser,numeClient,nrCamera,dataSosire,dataPlecare})
            .then(res => {
                console.log(res);
                console.log(res.data);
            });
        alert("Rezervarea a fost realizata!");
    };

    render() {
        const {numeClient,nrCamera,dataSosire,dataPlecare} = this.state;
        return (
            <div>
                <LoginRecep/>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <h1 align = "center">Realizati rezervarea:</h1>
                    </div>
                    <h3 align = "center">
                        <label>
                            <li>Nume client</li>
                            <input type="text" name="numeClient" value={numeClient} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Numar camera</li>
                            <input type="text" name="nrCamera" value={nrCamera} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Data sosire</li>
                            <input type="text" name="dataSosire" value={dataSosire} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <label>
                            <li>Data plecare</li>
                            <input type="text" name="dataPlecare" value={dataPlecare} onChange={this.handleChange} />
                        </label>
                    </h3>
                    <h3 align = "center">
                        <button type="submit">Rezervare</button>
                    </h3>
                </form>
            </div>

        )
    }
}

export default BookRoom;