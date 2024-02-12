import "../styles/Register.css";
import { useNavigate } from 'react-router-dom';

import register_img from '../assets/register.png'


function Register() {
    const navigate = useNavigate();

    function isStrongPassword(password) {
        if (password.length < 8) {
          return false;
        }
      
        const hasCharacter = /[a-zA-Z]/.test(password);
        const hasNumber = /\d/.test(password);
        const hasSpecialSymbol = /[!@#$%^&*(),.?":{}|<>]/.test(password);
      
        return hasCharacter && hasNumber && hasSpecialSymbol;
    }

    function isValidEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }

    const register = () => {
        const username = document.getElementById('register-username').value;
        const email = document.getElementById('register-mail').value;
        const password = document.getElementById('register-password-1').value;
        const repeat_password = document.getElementById('register-password-2').value;

        const short_error = document.getElementById('short-password-error');
        const dont_match_error = document.getElementById('dont-match-password-error');
        const invalid_email_error = document.getElementById('invalid-email-type-error');

        short_error.style.display = "none";
        dont_match_error.style.display = "none";
        invalid_email_error.style.display = "none";

        if(!isValidEmail(email)){
            invalid_email_error.style.display = "block";
            return;
        }

        if(!isStrongPassword(password) && !isStrongPassword(repeat_password)){
            short_error.style.display = "block";
            return;
        }

        if(password !== repeat_password){
            dont_match_error.style.display = "block";
            return;
        }

        const url = 'http://192.168.150.51:8080/api/users/register'; // Replace with your API endpoint
        const dataToSend = {
            username ,
            email ,
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
                navigate('/dashboard');
                // console.log('POST request successful:', data);
            })
            .catch(error => {
                // console.error('Error making POST request:', error);
            });
    }
  return (
    <div className = 'wrapper'>
        <div className = "page" id = "register-page">
            <div id = "register-left">
                <div id = "register-top">
                    <a href = "/">Study Deck</a>
                </div>

                <div id = "register-form">
                    <label id = "register-title">Create an account</label>
                    <input id = "register-username" placeholder = "Username"></input>
                    <input id = "register-mail" placeholder = "Email"></input>
                    <input id = "register-password-1" placeholder = "Password" type = "password"></input>
                    <input id = "register-password-2" placeholder = "Repeat password" type = "password"></input>
                    <label className = "register-error" id = "short-password-error">Password should be at least 8 symbols containing one character 1 number and special symbol</label>
                    <label className = "register-error" id = "dont-match-password-error">Passwords do not match</label>
                    <label className = "register-error" id = "invalid-email-type-error">Invalid email type</label>
                    <label className = "register-error" id = "invalid-email-type-error">Invalid email type</label>
                    <button onClick = {() => {register()}}>Sign Up</button>
                    <a href = "/login">Already have an account? Log in Here</a>
                </div>
            </div>

            <div id = "register-right">
                <img src = {register_img}></img>
            </div>
        </div>
    </div>
  );
}

export default Register;
