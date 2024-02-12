import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import HomeComponent from "./components/HomePage";
import CreateComponent from "./components/CreatePage";
import Login from "./components/Login";
import Register from "./components/Register";
import Dashboard from "./components/Dashboard";
import ForumPage from "./components/ForumPage";
import Conversation from "./components/Conversation";
import Friends from "./components/FriendsPage"
import AllFlashCards from "./components/AllFlashCards";


// import React, { useEffect , useState } from 'react';

function App() {
  return (
    <Router>
      <div id = "black-rect"></div>
      <div id = "page">
        <Routes>
          <Route exact path="/" element={<HomeComponent />} />
          <Route exact path="/flashcards/create" element={<CreateComponent />} />
          <Route exact path="/login" element={<Login />}></Route>
          <Route exact path="/register" element={<Register />}></Route>
          <Route exact path="/dashboard" element={<Dashboard />}></Route>
          <Route exact path="/friends" element={<Friends />}></Route>
          {/* <Route exact path="/flashcards" element={<AllFlashCards />}></Route> */}
          <Route exact path="/forum" element={<ForumPage />}></Route>
          <Route path="/forum/conversation/:title" element={<Conversation />} />
          <Route path="/dashboard/:title" element={<AllFlashCards />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
