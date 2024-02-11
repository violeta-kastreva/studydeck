import "../styles/Stack.css";

function Stack(props) {
  return (
    <div className = "stack-note-wrapper">
        <div className="inner-note-title">{props.deck.name}</div>
        <div className="inner-note-description">
            <div>
                <div className="dot"></div>
            </div>
            <div>
                <div className="dot"></div>            
            </div>
            <div>
                <div className="dot"></div>
            </div>
            <div>
                <div className="dot"></div>
            </div>
            <div>
                <div className="dot"></div>
                {
                    props.deck.filters.map((filter , index) => (
                        <div key = {index} className="filter">{filter}</div>
                    ))
                }
            </div>
            <div></div>
            <label>{props.deck.description}</label>
        </div>
        
    </div>
  );
}

export default Stack;