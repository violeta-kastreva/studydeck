import "../styles/Login.css";

function Login() {
  return (
    <div className = 'wrapper'>
        <div className = "page" id = "login-page">
            <div id = "login-left">
                <div id = "login-top">
                    <a href = "/">Study Deck</a>
                </div>

                <div id = "login-form">
                    <label id = "login-title">Log In</label>
                    <input placeholder = "Email"></input>
                    <input placeholder = "Password"></input>
                    <label id = "login-error">Wrong password or email</label>
                    <button>Login</button>
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
