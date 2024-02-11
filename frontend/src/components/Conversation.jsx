import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import '../styles/Conversation.css';
import Message from './Message';

const Conversation = () => {
    const { title } = useParams();
    const [messages, setMessages] = useState([
        { userName: "Ivan Ivanov", content: "Здравейте, имам въпрос относно Алгебра?" },
        { userName: "John Doe", content: "Hello, I have a question about Calculus." },
        { userName: "Jane Smith", content: "Hi there! Can anyone help me with Physics?" }
    ]);
    const [newMessage, setNewMessage] = useState('');

    const handleInputChange = (event) => {
        setNewMessage(event.target.value);
    };

    const handleAddMessage = () => {
        if (newMessage.trim() !== '') {
            // Add the new message to the messages array
            setMessages(prevMessages => [
                ...prevMessages,
                { userName: "Guest", content: newMessage }
            ]);
            // Clear the input
            setNewMessage('');
        }
    };

    return (
        <div className='wrapper'>
            <div className='page'>
                <div id='conversation-top'>
                    <div id='conversation-label'>Study Deck</div>
                </div>
                <div id='conversation-middle'>
                    <div id='conversation-middle-left'>
                        <div id='conversation-navigation'></div>
                    </div>
                    <div id='conversation-middle-right'>
                        <div id='conversation-title'>{title}</div>
                        <div id='conversation-thread'>
                            {messages.map((message, index) => (
                                // Specify the background color for each message
                                <Message
                                    key={index}
                                    userName={message.userName}
                                    content={message.content}
                                    backgroundColor={index % 2 === 0 ? '#ec8fff' : '#ff8fe7'}
                                />
                            ))}
                            {newMessage.trim() !== '' && (
                                <Message userName="Guest" content={newMessage} backgroundColor="#517ffc" />
                            )}
                        </div>
                        <div id='conversation-input'>
                            <textarea
                                value={newMessage}
                                onChange={handleInputChange}
                                placeholder="Type your message..."
                            />
                            <button onClick={handleAddMessage}>Send</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Conversation;
