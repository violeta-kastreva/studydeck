import React from 'react';
import '../styles/Message.css';
import guest from '../assets/guest.png';

const Message = ({ userName, content, backgroundColor }) => {
    return (
        <div className='message' style={{ backgroundColor }}>
            <div className='message-user'>
                <img src={guest} alt={guest} />
                <div className='message-user-name'>{userName}</div>
            </div>
            <div className='message-content'>
                {content}
            </div>
        </div>
    );
};

export default Message;
