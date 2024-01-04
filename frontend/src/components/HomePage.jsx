import React, { Component } from 'react';
import '../styles/HomePage.css';

// import HomeCard from "./HomeCard";

import search from '../assets/search.png';
import magnifying_glass from '../assets/magnifying-glass.png';
import contract from '../assets/contract.png';
import friend from '../assets/friend.png';



export default class HomeComponent extends Component {
    render() {
        return (
            <div className = 'wrapper'>
                <div id = "home-page">
                    <div id = "home-top">
                        <label>Study Deck</label>
                        <div>Log in</div>
                    </div>
                    <div id = "home-middle">
                        <div id = "home-main-text">
                            <label>Master your studies with personalized flashcards</label>                        
                        </div>
                        <div id = "search-bar-wrapper">
                            <div id = "search-bar">
                                <img id = "search-bar-img" src = {search}></img>
                            </div>
                            <input placeholder = "Search for cards"></input>
                        </div>
                    </div>
                    <div id = "home-bottom">
                        <div className = 'card'>
                            <img className = "card-image card-image-magnifying" src = {magnifying_glass}></img>
                            <div className = 'home-layer'></div>
                            <label className = 'card-title'>Discover a world of knowledge!</label>
                            <label className = 'card-content'>Dive into a treasure trove of knowledge as you explore our vast collection of meticulously crafted study cards, each designed to cater to diverse learning objectives and elevate your educational experience.</label>
                        </div>

                        <div className = 'card'>
                            <img className = "card-image card-image-contract" src = {contract}></img>
                            <div className = 'home-layer'></div>
                            <label className = 'card-title'>Sign in to start making your own flash cards</label>
                            <button id = 'sign-in'>Sign In</button>
                        </div>

                        <div className = 'card'>
                            <img className = "card-image card-image-friend" src = {friend}></img>
                            <div className = 'home-layer'></div>
                            <label className = 'card-title'>Invite your friends!</label>
                            <label className = 'card-content'>Share your personalized study cards, engage in friendly competition, and collectively elevate your mastery of subjects in a collaborative and empowering community</label>
                            
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}