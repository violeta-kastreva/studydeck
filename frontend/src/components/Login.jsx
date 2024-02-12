import "../styles/Login.css";
import { useNavigate } from 'react-router-dom';

import login_img from '../assets/login.png';

function Login() {
    const navigate = useNavigate();

    const login = () => {
        const username = document.getElementById('login-username').value;
        const password = document.getElementById('login-pass').value;

        const empty_error = document.getElementById('empty-error');
        const wrong_error = document.getElementById('wrong-error');

        empty_error.style.display = "none";
        wrong_error.style.display = "none";

        if(/^\s*$/.test(username) || /^\s*$/.test(password)){
            empty_error.style.display = "block";
            return;
        }

        const url = 'http://192.168.150.51:8080/api/users/login'; // Replace with your API endpoint
        const dataToSend = {
            username ,
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
                sessionStorage.setItem("jwt" , data.jwt)
                navigate("/dashboard");
                // console.log('POST request successful:', data);
            })
            .catch(error => {
                wrong_error.style.display = "block";
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
                        <input id = "login-username" placeholder = "Username"></input>
                        <input id = "login-pass" placeholder = "Password" type = "password"></input>
                        <label className = "login-error" id = "empty-error">Cannot provide empty password or email</label>
                        <label className = "login-error" id = "wrong-error">Wrong password or email</label>
                        <button onClick = {() => {login()}}>Login</button>
                        <a href = "/register">Don't have an account? Register Here</a>
                    </div>
                </div>

                <div id = "login-right">
                    <img src = {login_img}></img>
                </div>
            </div>
        </div>
    );
}

export default Login;
