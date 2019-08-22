import React from 'react';
import Home from '../components.home/Home';
import {Route} from 'react-router-dom';

class Logout extends React.Component{
    render(){
        return(
            <div>
                <Home/>
                <Route path='/home' component={Home} />
            </div>
        )
    }
}

export default Logout;