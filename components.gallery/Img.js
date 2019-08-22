import React, { Component } from "react";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

import './Img.css';

class Img extends Component {

    render() {
        const settings = {
            dots: true,
            infinite: true,
            slidesToShow: 1,
            slidesToScroll: 1,
            arrows: false,
        };

        return (
            <div>
                <Slider {...settings}>
                    <div>
                        <h2> Locația hotelului </h2>
                        <div className="slide-0">
                        </div>
                    </div>
                    <div>
                        <h2> Piscina exterioară </h2>
                        <div className="slide-1">
                        </div>
                    </div>
                    <div>
                        <h2> Piscina interioară </h2>
                        <div className="slide-2">
                        </div>
                    </div>
                    <div>
                        <h2> Foișorul din deal ideal pentru o cină romantică</h2>
                        <div className="slide-3">
                        </div>
                    </div>
                    <div>
                        <h2> Terenul de tenis</h2>
                        <div className="slide-4">
                        </div>
                    </div>
                    <div>
                        <h2> Hotelul iarna</h2>
                        <div className="slide-5">
                        </div>
                    </div>
                    <div>
                        <h2> Priveliștea de la piscină pe timpul iernii</h2>
                        <div className="slide-6">
                        </div>
                    </div>
                    <div>
                        <h2>Cameră dublă cu living</h2>
                        <div className="slide-7">
                        </div>
                    </div>
                    <div>
                        <h2>Cameră dublă</h2>
                        <div className="slide-8">
                        </div>
                    </div>
                    <div>
                        <h2>Cameră dublă</h2>
                        <div className="slide-9">
                        </div>
                    </div>
                    <div className="slide-10">
                    </div>
                </Slider>
            </div>
        );
    }
}

export default Img;