import React, { useState } from 'react';
import '../styles/FlashCard.css';

const FlashCard = () => {
    const question = "Hey I have a question?";
    const answer = "That is it!!!";

    const [showAnswer, setShowAnswer] = useState(false);

    const toggleShowAnswer = () => {
        setShowAnswer(!showAnswer);
    };

    const cardClasses = `flashcard ${showAnswer ? 'flip' : ''}`;
    const contentCardClasses = `flashcard-content ${showAnswer ? 'flip' : ''}`;
    return (
        <div className='flashcard-field'>
            <div className={cardClasses} onClick={toggleShowAnswer}>
                <div className={contentCardClasses}> {showAnswer ? answer : question}</div>
            </div>
        </div>
    );
};

export default FlashCard;
