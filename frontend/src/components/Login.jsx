import React, { useState, useEffect } from 'react';
import "../styles/Login.css";

function Login() {
    // const handleSubmit = (e) => {
    //     e.preventDefault();
    //     console.log('Submitted value:', emailValue);
    // };
    // useEffect(() => {
    //     fetch('http://192.168.154.51:8080/api/users/logi')
    //         .then(response => response.text())
    //         .then(text => {
    //             console.log(text);
    //         })
    //         .catch(error => {
    //             console.error('There was an error fetching the filters:', error);
    //         });
    // }, []);
    const login = () => {
        const email = document.getElementById('login-mail').value;
        const password = document.getElementById('login-pass').value;

        console.log(email , password);

        const url = 'http://192.168.154.51:8080/api/users/login'; // Replace with your API endpoint

        const dataToSend = {
            username: email ,
            password
        };

        const requestOptions = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(dataToSend),
            mode: 'cors',
            credentials: 'include'
        };

        fetch(url, requestOptions)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                console.log('POST request successful:', data);
            })
            .catch(error => {
                console.error('Error making POST request:', error);
            });
    }
    return (
        <div className = 'wrapper'>
            <div className = "page" id = "login-page">
                <div id = "login-left">
                    <div id = "login-top">
                        <a href = "/">Study Deck</a>
                    </div>

                    <div id = "login-form">
                        <label id = "login-title">Log In</label>
                        <input id = "login-mail" placeholder = "Email"></input>
                        <input id = "login-pass" placeholder = "Password"></input>
                        <label id = "login-error">Wrong password or email</label>
                        <button onClick = {() => {login()}}>Login</button>
                        <a href = "/register">Don't have an account? Register Here</a>
                    </div>
                </div>

                <div id = "login-right">

                </div>
            </div>
        </div>
    );
}

export default Login;
