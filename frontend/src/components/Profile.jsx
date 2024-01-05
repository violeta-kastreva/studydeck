import React, { Component } from 'react';
import '../styles/Profile.css';

import guest from '../assets/guest.png';

export default class Profile extends Component {
    render() {
        return (
            <div id = "profile-wrapper">
                <img id = "profile-img" src = {guest}></img>
            </div>
        );
    }
}