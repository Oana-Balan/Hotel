import React from 'react';
import './Header.css';
import logo2 from '../components.header/logo2.jpg';

class Header extends React.Component {
    render() {
        const style = {
            margin: 0,
            top: 80,
            right: 60,
            bottom: 616,
            left: 'auto',
            position: 'fixed',
        };

        return (
            <div>
                <div className="logo">
                    <div className="logo2"/>
                </div>
            <div className="navbar">
                <img src={logo2} width="45" height="45" align="left"/>
                <a href="/home">Acasa</a>
                <a href="/img">Galerie</a>
                <a href="/details">Detalii</a>
                <a href="/contact">Contact</a>
                <a style={style} href="/login">Logare</a>
            </div>
            </div>
        )
    }
}

export default Header;