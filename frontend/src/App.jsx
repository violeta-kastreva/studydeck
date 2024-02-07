import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import HomeComponent from "./components/HomePage";
import CreateComponent from "./components/CreatePage";
import Login from "./components/Login";
import Register from "./components/Register";
import ForumPage from "./components/ForumPage";


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
          <Route exact path="/forum" element={<ForumPage />}></Route>
          {/* <Route exact path="/yachts/:id" element={<YachtComponent />} />
          <Route exact path="/services" element={<AgencyComponent />} />
          <Route exact path="/contacts" element={<ContactsComponent />} /> */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
