import React, { Component } from 'react';
import '../styles/Search.css';

import search from '../assets/search.png';


export default class Search extends Component {

    render() {
        const default_text = this.props.defaultText;
        return (
            <div className = "search-bar-wrapper">
                <div className = "search-bar">
                    <img className = "search-bar-img" src = {search}></img>
                </div>
                <input placeholder = {default_text}></input>
            </div>
        );
    }
}