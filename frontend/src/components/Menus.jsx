import "../styles/Menus.css";
import myCards from '../assets/my-cards.png';
import forum from '../assets/forum.png';
import friends from '../assets/friends.png';


function Menus(props) {
  const menus = [{name: "My Cards" , path: "/dashboard" , img: myCards} , {name: "Friends" , path: "/friends" , img: friends} , {name: "Forum" , path: "/forum" , img: forum}]

  return (
    <div id="dashboard-menus-wrapper">
        {menus.map((menu , index) => (
            <div key = {index} className="dashboard-menus-row" style = {{
                backgroundColor: (props.menuIndex === index) ? '#272530' : 'transparent' ,
                border: (props.menuIndex === index) ? ' 1px solid #ebe8f0' : 'none'
            }}>
                <img src = {menu.img}></img>
                <a href = {menu.path}>{menu.name}</a>
            </div>
        ))}
    </div>
  );
}

export default Menus;
