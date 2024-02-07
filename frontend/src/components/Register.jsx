import "../styles/Register.css";

function Register() {
  return (
    <div className = 'wrapper'>
        <div className = "page" id = "register-page">
            <div id = "register-left">
                <div id = "register-top">
                    <a href = "/">Study Deck</a>
                </div>

                <div id = "register-form">
                    <label id = "register-title">Create an account</label>
                    <input placeholder = "Username"></input>
                    <input placeholder = "Email"></input>
                    <input placeholder = "Password"></input>
                    <input placeholder = "Repeat password"></input>
                    <label id = "register-error">Passwords do not match</label>
                    <button>Sign Up</button>
                    <a href = "/login">Already have an account? Log in Here</a>
                </div>
            </div>

            <div id = "register-right">

            </div>
        </div>
    </div>
  );
}

export default Register;
