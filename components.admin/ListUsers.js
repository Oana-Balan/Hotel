import React from 'react';
import axios from 'axios';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import './Table1.css';

import LoginAdmin from "../components.login/LoginAdmin";

function onDeleteRow(rowKey) {
    alert('You deleted: ' + rowKey);
    axios.post(`http://localhost:8085/spring/admin/deleteUser/${rowKey}`)
        .then(res => {
            console.log(res);
            console.log(res.data);
        })
}

class ListUsers extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8085/spring/admin/allUsers").then((response) => {
            const users = response.data;
            this.setState({users});
        })
    }

    render() {
        const options = {
            afterDeleteRow: onDeleteRow
        };

        // To delete rows you be able to select rows
        const selectRowProp = {
            mode: 'checkbox'
        };


        return (
            <div>
                <LoginAdmin/>
                <BootstrapTable data={this.state.users}
                                deleteRow={true}
                                selectRow={selectRowProp}
                                options={options}>
                    <TableHeaderColumn isKey
                                       dataField='id'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="150"
                                       tdStyle={
                                           {backgroundColor: 'green'}}>
                        ID
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='nume'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="150"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white',
                                           }}
                                       tdStyle={
                                           {backgroundColor: 'white'}} >
                        Nume
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='prenume'
                                       dataAlign='center'
                                       headerAlign="center"
                                       width="150"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }}
                                       tdStyle={
                                           {backgroundColor: 'white'}}>
                        Prenume
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='email'
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
                                           {backgroundColor: 'green'}}>
                        Email
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='parola'
                                       dataAlign='center'
                                       headerAlign="right"
                                       width="260"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={
                                           {backgroundColor: 'white'}}>
                        Parola
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='utilizator'
                                       dataColor='green'
                                       dataAlign='center'
                                       headerAlign="right"
                                       width="260"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={
                                           {backgroundColor: 'green'}}>
                        Utilizator
                    </TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}

export default ListUsers;