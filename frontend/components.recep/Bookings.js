import React from 'react';
import axios from 'axios';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import'./Table11.css';
import LoginRecep from "../components.login/LoginRecep";

class Bookings extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            bookings: []
        }
    }

    componentDidMount() {
        const  id = localStorage.getItem('myId');
        axios.get(`http://localhost:8085/spring/recep/all/${id}`).then((response) => {
            const bookings = response.data;
            this.setState({bookings});
        })
    }

    render() {


        return (
            <div>
                <LoginRecep/>
                <BootstrapTable data={this.state.bookings}>
                    <TableHeaderColumn isKey
                                       dataField='numeClient'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="150"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={{
                                               backgroundColor:'white'}}>
                        Client
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='nrCamera'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="150"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={
                                           {
                                               backgroundColor:'white'}}>
                        Camera
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='dataSosire'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="150"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={
                                           {
                                               backgroundColor:'white'}}>
                        Sosire
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='dataPlecare'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="150"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={
                                           {
                                               backgroundColor:'white'}}>
                        Plecare
                    </TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}

export default Bookings;