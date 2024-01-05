import React, { Component } from 'react';
import '../styles/CreatePage.css';
import Profile from './Profile';



export default class CreateComponent extends Component {
    render() {
        return (
            <div className = 'wrapper'>
                <div className = 'page'>
                    <div id = 'create'>
                        <div id = "create-top">
                            <label>Study deck</label>
                            <div id = "create-profile">
                                <Profile />
                            </div>
                        </div>
                        <div id = "create-bottom">
                            <div id = "create-bottom-left">
                                <div className = "add" id = "add1">
                                    <div className = "add-top">
                                        <label>Add Category</label>
                                        <label className = "error-label" id = "error-select-category">Please select category</label>
                                    </div>
                                    <div className = "category-wrapper">
                                        <div className = 'category-box'>Math</div>
                                        <div className = 'category-box'>Physics</div>
                                        <div className = 'category-box'>Chemistry</div>
                                        <div className = 'category-box'>Languages</div>
                                    </div>
                                </div>

                                <div className = "add" id = "add2">
                                    <div className = 'add-top'>
                                        <label>Add Tags</label>
                                        <label className = "error-label" id = "error-select-tags">Please select tags</label>
                                    </div>
                                    <div className = "category-wrapper">
                                        <div className = 'category-box'>Algebra</div>
                                        <div className = 'category-box'>Computer Science</div>
                                        <div className = 'category-box'>Data Structures</div>
                                        <div className = 'category-box'>Discrete Mathematics</div>
                                        <div className = 'category-box'>Geometry</div>
                                        <div className = 'category-box'>Calculus</div>
                                    </div>
                                </div>

                                <div id = "add-card-wrapper">
                                    <button id = "add-card">Add Card</button>
                                    <button id = "cancel">Cancel</button>
                                </div>
                            </div>
                            <div id = "create-bottom-right">
                                <label className = "error-label" id = "error-enter-description">Enter description</label>
                                <input className = "create-card-data" id = "create-card-title" placeholder = "Card title"></input>
                                <input className = "create-card-data" id = "create-card-description" placeholder = "Card description"></input>

                                <div id = "qna-wrapper">
                                    <div id = "qna">
                                        <input className = "create-card-data" id = "create-card-question" placeholder = "Question"></input>
                                        <input className = "create-card-data" id = "create-card-answer" placeholder = "Answer"></input>
                                    </div>
                                    <div id = "add-qna">
                                        <button id = "add-qna-button">Add question +</button>
                                        <label className = "error-label" id = "error-enter-answer">Enter an answer</label>
                                    </div>
                                </div>

                                <div id = "all-qnas-wrapper">
                                    <div id = "all-qnas">
                                        <div id = "all-questions">Questions</div>
                                        <div id = "all-answers">Answers</div>
                                    </div>
                                    <div id = "all-qna-data"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}