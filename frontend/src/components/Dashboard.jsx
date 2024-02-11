import "../styles/Dashboard.css";
import Menus from "./Menus";
import Stack from "./Stack";
import React, { useEffect , useState } from 'react';


function Dashboard() {
  const [jwt, setJwt] = useState();
  const [stacks, setStacks] = useState([]);

  useEffect(() => {
    setJwt(sessionStorage.getItem("jwt"));
  }, []);
  
  useEffect(() => {
    if(!jwt)return;
    const url = 'http://192.168.254.51:8080/dashboard'; // Replace with your API endpoint

    const requestOptions = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${jwt}`,
        },
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
            setStacks(data);
            console.log('Get request successful:', data);
        })
        .catch(error => {
            console.error('Error making GET request:', error);
        });
  }, [jwt]);

  return (
    <div className = 'wrapper'>
      <div className = "page" id = "dashboard-page">
        <div id="dashboard-top">
          <a href = "/">Study Deck</a>
        </div>
        <div id="dashboard-bottom">
          <div id="dashboard-left">
            <button onClick={() => window.location.href = '/flashcards/create'}>+ Create</button>
            <div>
              <Menus menuIndex = {0}></Menus>
            </div>
          </div>
          <div id="dashboard-right">
            {
              stacks.map((stack , index) => (
                <div key = {index}>
                  <label className="stack-title">{stack.title}</label>
                  <div className="dashboard-stack-row">
                  {
                    stack.decks.map((deck , index) => (
                      <Stack key = {index} deck = {deck}/>
                    ))
                  }
                  </div>
                </div>
              ))
            }
          </div>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
