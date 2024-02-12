import React, { useState } from 'react';
import '../styles/AllFlashCards.css';
import { useNavigate } from 'react-router-dom';
import left from '../assets/left-chevron.png';
import right from '../assets/right-chevron.png';
import exit from '../assets/cancel.png';
import FlashCard from './FlashCard';
import { useLocation } from 'react-router-dom';
const AllFlashCards = () => {
    const location = useLocation();
    const data = location.state?.data;
    const flashCardsData = data;
    // const flashCardsData = [
    //     { question: "What is React?", answer: "A JavaScript library for building user interfaces." },
    //     { question: "What is a component?", answer: "An independent, reusable piece of UI." },
    //     { question: "What is JSX?", answer: "A syntax extension for JavaScript that looks similar to XML." },
    // ];

    const navigate = useNavigate();
    const [currentIndex, setCurrentIndex] = useState(0);

    const handleNext = () => {
        const nextIndex = currentIndex === flashCardsData.length - 1 ? 0 : currentIndex + 1;
        setCurrentIndex(nextIndex);
    };

    const handlePrevious = () => {
        const prevIndex = currentIndex === 0 ? flashCardsData.length - 1 : currentIndex - 1;
        setCurrentIndex(prevIndex);
    };

    const handleExit = () => {
        navigate('/dashboard'); 
    };

    return (
        <div className='allflash-all'>
            <div className='allflash-top' onClick={handleExit}>
                <img src={exit} alt="Exit" />
            </div>
            <div className='allflash-wrapper'>
            <div className='allflash-left' onClick={handlePrevious}>
                <img src={left} alt="Previous" />
            </div>
            <FlashCard 
                key={currentIndex} 
                question={flashCardsData[currentIndex].question} 
                answer={flashCardsData[currentIndex].answer} 
            />
            <div className='allflash-right' onClick={handleNext}>
                <img src={right} alt="Next" />
            </div>
            </div>
        </div>
    );
};

export default AllFlashCards;
