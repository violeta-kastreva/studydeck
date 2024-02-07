import React, { Component } from 'react';
import '../styles/ForumPage.css';
import Thread from "./Thread";



export default class ForumPageComponent extends Component {
    render() {
        const jsonData = {
            "forumStatistics": {
                "threads": 1312312,
                "messages": 4321,
                "members": 989809
            },
            "threads": [
                {
                    "title": "Algorithm",
                    "rowTitle": "Searching the fastest path to NBU",
                    "commentsCount": 268,
                    "userName": "Ivo Ivanov",
                    "userCreatedAt": "6.2.2024"
                },
                {
                    "title": "Another Title",
                    "rowTitle": "Another Thread Title",
                    "commentsCount": 150,
                    "userName": "John Doe",
                    "userCreatedAt": "7.2.2024"
                }
            ]
        };

        const { forumStatistics, threads } = jsonData;

        return (
            <div className = 'wrapper'>
                <div className = "page">
                    <div id = "forum-top">
                        <div id ='forum-label'>Study Deck</div>
                    </div>
                    <div id = "forum-middle">
                        <div id = "forum-middle-left">
                            <div id = "forum-statistics">
                                <div id = "forum-statistics-title">Forum statistics:</div>
                                <label> Threads: {forumStatistics.threads}</label>
                                <label> Messages: {forumStatistics.messages}</label>
                                <label> Member: {forumStatistics.members}</label>
                            </div>
                            <div id = "forum-navigation"></div>
                        </div>
                        <div id = "forum-middle-right">
                            {threads.map((thread, index) => (
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
}