import React from 'react';
import axios from 'axios';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import './Table11.css';

import LoginRecep from "../components.login/LoginRecep";

class ListClients extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            clients: []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8085/spring/recep/allClients").then((response) => {
            const clients = response.data;
            this.setState({clients});
        })
    }

    render() {


        return (
            <div>
                <LoginRecep/>
                <BootstrapTable data={this.state.clients}>
                    <TableHeaderColumn isKey
                                       dataField='nume'
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
                        NUME
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='prenume'
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
                        PRENUME
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='telefon'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="200"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={
                                           {
                                               backgroundColor:'white'}}>
                        Telefon
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='adresa'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="250"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={
                                           {
                                               backgroundColor:'white'}}>
                        Adresa
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='camereInchiriate'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="250"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={
                                           {
                                               backgroundColor:'white'}}>
                        Camere inchiriate
                    </TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}

export default ListClients;