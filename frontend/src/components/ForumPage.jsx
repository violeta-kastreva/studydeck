import React, { useState, useEffect } from 'react';
import '../styles/ForumPage.css';
import Thread from "./Thread";

const ForumPage = () => {
    const [jwt, setJwt] = useState('');
    const [forumData, setForumData] = useState({
        forumStatistics: { threads: 0, messages: 0, members: 0 },
        threads: []
    });

    useEffect(() => {
        const jwtToken = sessionStorage.getItem("jwt");
        setJwt(jwtToken);
    }, []);

    useEffect(() => {
        if (!jwt) return;
        const url = 'http://192.168.254.51:8080/forum'; 

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
                            <label> Threads: {forumData.forumStatistics.threads}</label>
                            <label> Messages: {forumData.forumStatistics.messages}</label>
                            <label> Members: {forumData.forumStatistics.members}</label>
                        </div>
                        <div id = "forum-navigation"></div>
                    </div>
                    <div id = "forum-middle-right">
                        {forumData.threads.map((thread, index) => (
                            <Thread
                                key={index}
                                title={thread.title}
                                rowTitle={thread.rowTitle}
                                commentsCount={thread.commentsCount}
                                userName={thread.userName}
                                userCreatedAt={thread.userCreatedAt}
                            />
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ForumPage;