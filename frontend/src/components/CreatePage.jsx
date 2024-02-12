import React, { useState , useEffect} from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/CreatePage.css';
import Profile from './Profile';

const CreateComponent = () => {
  const navigate = useNavigate();

  const [jwt, setJwt] = useState();
  const [qna, setQna] = useState([]);
  const [cards , setCards] = useState([])
  const [stack , setStack] = useState([]);

  const [categories, setCategories] = useState([
    { name: "Math", active: false },
    { name: "Biology", active: false },
    { name: "History", active: false },
    { name: "Physics", active: false },
    { name: "IT", active: false },
    { name: "Chemistry", active: false },
  ]);

  const [isQ , setisQ] = useState(true);

  useEffect(() => {
    setJwt(sessionStorage.getItem("jwt"));
  }, []);

  const addQuestion = () => {
    const question_el = document.getElementById('create-card-question');
    const answer_el = document.getElementById('create-card-answer');
    
    const question = question_el.value;
    const answer = answer_el.value;

    const error_qna = document.getElementById('error-enter-qna');
    const error_question = document.getElementById('error-enter-question');
    const error_answer = document.getElementById('error-enter-answer');

    const overlay_question = document.getElementById('create-card-question');
    const overlay_answer = document.getElementById('create-card-answer');

    error_qna.style.display = 'none';
    error_question.style.display = "none";
    error_answer.style.display = "none";

    overlay_question.style.boxShadow = 'none';
    overlay_answer.style.boxShadow = 'none';

    if (/^\s*$/.test(question) && /^\s*$/.test(answer)) {
        error_qna.style.display = 'block';
        overlay_question.style.boxShadow = '0 0 10px 2px red';
        overlay_answer.style.boxShadow = '0 0 10px 2px red';
        return;
    }else if(/^\s*$/.test(question)){
        error_question.style.display = "block";
        console.log(error_question)
        overlay_question.style.boxShadow = '0 0 10px 2px red';
        return;
    }else if(/^\s*$/.test(answer)){
        error_answer.style.display = "block";
        overlay_answer.style.boxShadow = '0 0 10px 2px red';
        return;
    }else{
        const update_qna = [...qna , {question , answer}];

        question_el.value = "";
        answer_el.value = "";
        
        setQna(update_qna);
    }
  };

  const changeQNA = (arg) => {
    const is_question = !arg;
    setisQ(is_question);
  }


  const addCard = () => {
    const title_el = document.getElementById('create-card-title');
    const description_el = document.getElementById('create-card-description');
    
    const title = title_el.value;
    const description = description_el.value;

    const error_tnd = document.getElementById('error-enter-title-and-description');
    const error_title = document.getElementById('error-enter-title');
    const error_description = document.getElementById('error-enter-description');

    const overlay_title = title_el;
    const overlay_description = description_el;

    error_tnd.style.display = 'none';
    error_title.style.display = "none";
    error_description.style.display = "none";

    overlay_title.style.boxShadow = 'none';
    overlay_description.style.boxShadow = 'none';

    if (/^\s*$/.test(title) && /^\s*$/.test(description)) {
        error_tnd.style.display = 'block';
        overlay_title.style.boxShadow = '0 0 10px 2px red';
        overlay_description.style.boxShadow = '0 0 10px 2px red';
        return;
    }else if(/^\s*$/.test(title)){
        error_title.style.display = "block";
        overlay_title.style.boxShadow = '0 0 10px 2px red';
        return;
    }else if(/^\s*$/.test(description)){
        error_description.style.display = "block";
        overlay_description.style.boxShadow = '0 0 10px 2px red';
        return;
    }else{
        title_el.value = "";
        description_el.value = "";

        const filters = categories.filter(category => category.active).map(category => category.name);
        
        setCards(prevCards => [
          ...prevCards,
          {
            name: title,
            description,
            filters,
            data: qna
          }
        ]);

        setQna([]);

        resetFilters();
    }
    
  }

  const resetFilters = () => {
    setCategories([
      { name: "Math", active: false },
      { name: "Biology", active: false },
      { name: "History", active: false },
      { name: "Physics", active: false },
      { name: "IT", active: false },
      { name: "Chemistry", active: false },
    ]);
  }

  const selectCategory = (index) => {
    const new_categories = [...categories];
    new_categories[index].active = !new_categories[index].active;
    setCategories(new_categories);
  };

  const addStack = () => {
    const title_el = document.getElementById('create-stack-title');
    const title = title_el.value;
    const error_title = document.getElementById('error-enter-stack-title');
    const overlay_title = document.getElementById("add1");

    error_title.style.display = 'none';
    overlay_title.style.boxShadow = 'none';

    if(/^\s*$/.test(title)){
      error_title.style.display = "block";
      overlay_title.style.boxShadow = '0 0 10px 2px red';
      return;
    }

    const new_stack = [...stack , {title , decks: cards}];
    setStack([]);
    setCards([]);
    setQna([]);

    const url = 'http://192.168.150.51:8080/api/decks/create';

    console.log(...new_stack)
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${jwt}`,
        },
        body: JSON.stringify(...new_stack),
        mode: 'cors',
        credentials: 'include'
    };

    console.log(requestOptions.body)

    fetch(url, requestOptions)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
          // setStack([]);
          goToDashboard();
          console.log('Get request successful:', data);
        })
        .catch(error => {
            // console.error('Error making GET request:', error);
        });
  }

  const goToDashboard = () => {
    navigate("/dashboard");
  }

  return (
    <div className="wrapper">
      <div className="page">
        <div id="create">
          <div id="create-top">
            <a href="/">Study Deck</a>
            <div id="create-profile">
              <Profile />
            </div>
          </div>
          <div id="create-bottom">
            <div id="create-bottom-left">

            <div className="add" id="add2">
                <div className="add-top">
                  <label>Add Filters</label>
                  <label className="error-label" id="error-select-tags">
                    Please select tags
                  </label>
                </div>
                <div className="category-wrapper">
                  {
                    categories.map((category , index) => (
                      <div key = {index} style = {{backgroundColor: category.active ? "limegreen" : "#44434d"}} className="category-box" onClick = {() => selectCategory(index)}>{category.name}</div>
                    ))
                  }
                </div>
              </div>

              <div id="stack-title-wrapper">
                <div className="add" id="add1">
                  <input id="create-stack-title" placeholder="Stack title"></input>
                </div>

                <label className="error-label" id="error-enter-stack-title">
                  Enter title for stack
                </label>
              </div>

              <div id="add-deck-wrapper">
                <button id="add-deck" onClick = {() => {addStack()}}>Add Stack</button>
                <button id="cancel" onClick = {() => {goToDashboard()}}>Cancel</button>
              </div>
            </div>
            <div id="create-bottom-right">
              <input className="create-card-data" id="create-card-title" placeholder="Card title"></input>
              <input className="create-card-data" id="create-card-description" placeholder="Card description"></input>
              <label className="error-label" id="error-enter-title">
                Enter title
              </label>
              <label className="error-label" id="error-enter-description">
                Enter description
              </label>
              <label className="error-label" id="error-enter-title-and-description">
                Enter title and description
              </label>

              <div id="qna-wrapper">
                <div id="qna">
                  <input className="create-card-data" id="create-card-question" placeholder="Question"></input>
                  <input className="create-card-data" id="create-card-answer" placeholder="Answer"></input>
                </div>
                <div id="add-qna">
                  <button id="add-qna-button" onClick={() => addQuestion()}>
                    Add question +
                  </button>
                  <label className="error-label" id="error-enter-qna">
                    Enter question and answer
                  </label>
                  <label className="error-label" id="error-enter-question">
                    Enter question
                  </label>
                  <label className="error-label" id="error-enter-answer">
                    Enter answer
                  </label>
                </div>
              </div>

              <div id="all-qnas-wrapper">
                <div id="all-qnas">
                  <div id="all-questions" style = {{opacity: isQ ? 1 : 0.5}} onClick = {() => {changeQNA(false)}}>Questions</div>
                  <div id="all-answers" style = {{opacity: isQ ? 0.5 : 1}} onClick = {() => {changeQNA(true)}}>Answers</div>
                </div>
                <div id="all-qna-data">
                    <div style={{display: isQ ? "none" : "flex"}}>
                      {
                        qna.map((qna_data , index) => (
                          <label key = {index}>{`${index + 1}) ${qna_data.answer}`}</label>
                        ))
                      }
                    </div>
                  
                    <div style={{display: isQ ? "flex" : "none"}}>
                      {
                        qna.map((qna_data , index) => (
                          <label key = {index}>{`${index + 1}) ${qna_data.question}`}</label>
                        ))
                      }
                    </div>
                  </div>
                <button id="add-card" onClick = {() => {addCard()}}>Add Deck</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CreateComponent;
