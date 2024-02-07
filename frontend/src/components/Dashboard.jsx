import "../styles/Dashboard.css";
import Menus from "./Menus";
import Stack from "./Stack";

function Dashboard() {
  const stacks = [{
    title: "Latest Cards", 
    decks: [
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      }
    ]
  },
  {
    title: "Latest Cards", 
    decks: [
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      }
    ]
  },
  {
    title: "Latest Cards", 
    decks: [
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      } ,
      {
        name: "Linear Algebra",
        description: "FlashCards with linear algebra terms for you to study and easily memorize.",
        filters: ["Math" , "Algebra"],
        data:[{
          question: "Hi" ,
          answer: "Hi!"
        }]
      }
    ]
  }
]
  return (
    <div className = 'wrapper'>
      <div className = "page" id = "dashboard-page">
        <div id="dashboard-top">
          <a href = "/">Study Deck</a>
        </div>
        <div id="dashboard-bottom">
          <div id="dashboard-left">
            <button onClick={() => window.location.href = '/flashcards/create'}>+ Create</button>
            <div>
              <Menus menuIndex = {0}></Menus>
            </div>
          </div>
          <div id="dashboard-right">
            {
              stacks.map((stack , index) => (
                <div key = {index}>
                  <label className="stack-title">{stack.title}</label>
                  <div className="dashboard-stack-row">
                  {
                    stack.decks.map((deck , index) => (
                      <Stack key = {index} deck = {deck}/>
                    ))
                  }
                  </div>
                </div>
              ))
            }
          </div>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
