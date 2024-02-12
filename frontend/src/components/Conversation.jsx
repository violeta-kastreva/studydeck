import React, { useState , useEffect } from 'react';
import { useParams , useNavigate } from 'react-router-dom';
import '../styles/Conversation.css';
import Message from './Message';

const Conversation = () => {
    const navigate = useNavigate();

    const { title } = useParams();
    const [messages, setMessages] = useState([]);
    const [newMessage, setNewMessage] = useState('');


    const [jwt, setJwt] = useState('');

    useEffect(() => {
        setJwt(sessionStorage.getItem("jwt"));
    }, []);

    useEffect(() => {
        if (!jwt){
            navigate("/");
            return;
        }
            updateData();
    }, [jwt]); 


    const updateData = () => {
        const url = `http://192.168.150.51:8080/forum/${title}`; 

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
                setMessages([...data])
            })
            .catch(error => {
                console.error('Error fetching forum data:', error);
            });
    }


    const handleInputChange = (event) => {
        setNewMessage(event.target.value);
    };

    const handleAddMessage = () => {
        if (newMessage.trim() !== '') {
            setMessages(prevMessages => [
                ...prevMessages,
                { userName: "Guest", content: newMessage }
            ]);
            // Clear the input
            setNewMessage('');


            if (!jwt) return;

        const url = `http://192.168.150.51:8080/forum/${title}/comment`; 

          

        const requestOptions = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${jwt}`,
            },
            body: JSON.stringify({ username: "Guest", content: newMessage }),
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
                // console.log(data)
                updateData();
            })
            .catch(error => {
                console.error('Error fetching forum data:', error);
            });
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
                                    userName={message.username}
                                    content={message.content}
                                    backgroundColor={index % 2 === 0 ? '#ec8fff' : '#ff8fe7'}
                                />
                            ))}
                            {newMessage.trim() !== '' && (
                                <Message username="Guest" content={newMessage} backgroundColor="#517ffc" />
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
