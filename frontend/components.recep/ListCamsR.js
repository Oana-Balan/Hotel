import React from 'react';
import axios from 'axios';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import './Table11.css';

import LoginRecep from "../components.login/LoginRecep";

class ListCamsR extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            cams: []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8085/spring/admin/allCams").then((response) => {
            const cams = response.data;
            this.setState({cams});
        })
    }

    render() {


        return (
            <div>
                <LoginRecep/>
                <BootstrapTable data={this.state.cams}>
                    <TableHeaderColumn isKey
                                       dataField='numar'
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
                                           {fontWeight: 'lighter',
                                               color: 'blue',
                                               backgroundColor:'white'}}>
                        NUMAR
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='tip'
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
                                           {fontWeight: 'lighter',
                                               color: 'blue',
                                               backgroundColor:'white'}}>
                        Tip
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='pret'
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
                                           {fontWeight: 'lighter',
                                               color: 'blue',
                                               backgroundColor:'white'}}>
                        Pret pe o noapte
                    </TableHeaderColumn>
                    <TableHeaderColumn dataField='disponibilitate'
                                       dataAlign='center'
                                       headerAlign="right"
                                       width="150"
                                       thStyle={
                                           {
                                               fontWeight: 'lighter',
                                               color: 'white'
                                           }
                                       }
                                       tdStyle={
                                           {fontWeight: 'lighter',
                                               color: 'blue',
                                               backgroundColor:'white'}}>
                        Disponibilitate
                    </TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}

export default ListCamsR;