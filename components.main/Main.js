import React from 'react';
import { Switch, Route } from 'react-router-dom';

import Header from '../components.header/Header';
import Login from '../components.login/Login';
import Home from '../components.home/Home';

import LoginAdmin from '../components.login/LoginAdmin';
import LoginRecep from '../components.login/LoginRecep';
import Logout from '../components.login/Logout';

import AddUser from '../components.admin/AddUser';
import ListUsers from '../components.admin/ListUsers';
import UpdateUser from '../components.admin/UpdateUser';

import AddCam from '../components.admin/AddCam';
import ListCams from '../components.admin/ListCams';

import BookRoom from '../components.recep/BookRoom';
import CancelRoom from '../components.recep/CancelRoom';
import AddClient from '../components.recep/AddClient';
import Bookings from '../components.recep/Bookings';
import ListClients from '../components.recep/ListClients';

import ListCamsR from '../components.recep/ListCamsR';

import Img from '../components.gallery/Img';
import Contact from '../components.contact/Contact';
import Details from '../components.details/Details';

import Raport from '../components.admin/Raport';

const Main = () => (
    <main>
        <Switch>
            <Route exact path='/header' component={Header}/>
            <Route exact path='/home' component={Home}/>
            <Route exact path='/login' component={Login}/>
            <Route exact path='/loginadmin' component={LoginAdmin}/>
            <Route exact path='/loginrecep' component={LoginRecep}/>
            <Route exact path='/logout' component={Logout}/>
            <Route exact path='/adduser' component={AddUser}/>
            <Route exact path='/listusers' component={ListUsers}/>
            <Route exact path='/updateuser' component={UpdateUser}/>
            <Route exact path='/addcam' component={AddCam}/>
            <Route exact path='/listcams' component={ListCams}/>
            <Route exact path='/book' component={BookRoom}/>
            <Route exact path='/cancel' component={CancelRoom}/>
            <Route exact path='/addclient' component={AddClient}/>
            <Route exact path='/bookings' component={Bookings}/>
            <Route exact path='/listclients' component={ListClients}/>
            <Route exact path='/listcamsR' component={ListCamsR}/>
            <Route exact path='/img' component={Img}/>
            <Route exact path='/contact' component={Contact}/>
            <Route exact path='/details' component={Details}/>
            <Route exact path='/raport' component={Raport}/>
        </Switch>
    </main>
);

export default Main;
