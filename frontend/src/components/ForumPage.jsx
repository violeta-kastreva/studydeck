import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/ForumPage.css';
import Thread from "./Thread";
import Menus from "./Menus";

const ForumPage = () => {
    const [jwt, setJwt] = useState('');
    const [forumData, setForumData] = useState({
        statistics: { threads: 0, messages: 0, members: 0 },
        threads: []
    });

    const navigate = useNavigate();

    const handleClick = (title) => {
        navigate(`/forum/conversation/${title}`);
    };

    useEffect(() => {
        setJwt(sessionStorage.getItem("jwt"));
    }, []);

    useEffect(() => {
        if (!jwt){
            navigate("/");
            return;
        }
        const url = 'http://192.168.150.51:8080/forum'; 

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
                console.log(data)
                setForumData(data);
            })
            .catch(error => {
                console.error('Error fetching forum data:', error);
            });
    }, [jwt]); 


    return (
        <div className = 'wrapper'>
            <div className = "page">
                <div id = "forum-top">
                    <div id ='forum-label'>Study Deck</div>
                </div>
                <div id = "forum-middle">
                    <div id = "forum-middle-left">
                        <div id = "forum-statistics">
                        <div id="forum-statistics-title">Forum statistics:</div>
                            <label> Threads: {forumData.statistics.threads}</label>
                            <label> Messages: {forumData.statistics.messages}</label>
                            <label> Members: {forumData.statistics.members}</label>
                        </div>
                        <div id = "forum-navigation">
                            <Menus menuIndex = {2}></Menus>
                        </div>
                    </div>
                    <div id = "forum-middle-right">
                        {forumData.threads.map((thread, index) => (
                            <div key={index} onClick={() => {handleClick(thread.title)}} style={{'width': '100%'}}>
                                <Thread
                                    title={thread.title}
                                    rowTitle={thread.rowTitle}
                                    commentsCount={thread.commentsCount}
                                    userName={thread.userName}
                                    userCreatedAt={thread.userCreatedAt}
                                />
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ForumPage;