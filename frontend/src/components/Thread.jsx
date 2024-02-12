import React from 'react';
import '../styles/Thread.css';
import guest from '../assets/guest.png';

const Thread = ({ title, rowTitle, commentsCount, userName, userCreatedAt }) => {
    return (
        <div className='thread'>
            <div className='thread-title'>
                {title}
            </div>
            <div className='thread-row'>
                <div className='thread-row-title'>{rowTitle}</div>
                <div className='thread-row-right'>
                    <div className='thread-row-comments'>Comments: {commentsCount}</div>
                    <div className='thread-row-user'>
                        <img src={guest} alt={guest} />
                        <div className='thread-row-user-content'>
                            <div className='thread-row-user-content-name'>{userName}</div>
                            <label>created: {userCreatedAt}</label>
                        </div>
                    </div>
                </div>
            </div>
            {/* Additional empty thread rows */}
            <div className='thread-row2'></div>
            <div className='thread-row2'></div>
            {/* Add as many empty thread rows as needed */}
        </div>
    );
};

export default Thread;
