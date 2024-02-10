import React from 'react';
import '../styles/FriendTable.css'; 
import guest from '../assets/guest.png'; 

const FriendTable = ({ userNames, buttonText, onRemoveCell, onAcceptRequest}) => {
    const cells = Array.from({ length: 20 }, (_, index) => index + 1);

    return (
        <div id='friend-middle-table'>
        {userNames.map((userName, index) => (
            <div key={index} className='cell'>
                <div className='friend-table-user'>
                    <img src={guest} alt={guest} />
                    <div className='friend-table-user-content'>
                        <div className='friend-table-user-name'>{userName}</div>
                    </div>
                </div>
                <div id='friend-table-invite'>
                        {buttonText === 'Remove' ? (
                            <div onClick={() => onRemoveCell(index)}>{buttonText}</div>
                        ) : (
                            <div onClick={() => onAcceptRequest(index)}>{buttonText}</div>
                        )}
                    </div>
            </div>
        ))}
    </div>
    );
};

export default FriendTable;
