import React, { Component } from 'react';
import '../styles/FriendsPage.css';
import guest from '../assets/guest.png';
import FriendTable from './FriendTable';



export default class FriendsPageComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            activeTab: 'Friends',
            friendsUserNames: [], 
            requestsUserNames: [], 
        };
    }

    componentDidMount() {
        this.fetchFriendsAndRequests();
    }

    fetchFriendsAndRequests = () => {
        const jwt = sessionStorage.getItem("jwt");
        if (!jwt) return;

        const url = 'http://192.168.254.51:8080/friends'; 

        const requestOptions = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${jwt}`,
            },
            mode: 'cors',
            credentials: 'include',
        };

        fetch(url, requestOptions)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {

                this.setState({
                    friendsUserNames: data.friendsUserNames,
                    requestsUserNames: data.requestsUserNames,
                });
            })
            .catch(error => {
                console.error('Error fetching friends and requests:', error);
            });
    }


    handleTabChange = (tabName) => {
        this.setState({ activeTab: tabName });
    }

    handleRemoveCell = (index) => {
        const { activeTab } = this.state;
        const newArray = activeTab === 'Friends' ? [...this.state.friendsUserNames] : [...this.state.requestsUserNames];
        newArray.splice(index, 1);
        activeTab === 'Friends' ? this.setState({ friendsUserNames: newArray }) : this.setState({ requestsUserNames: newArray });
    }

    handleAcceptRequest = (index) => {
        const { requestsUserNames, friendsUserNames } = this.state;
        const newRequestsArray = [...requestsUserNames];
        const newFriendsArray = [...friendsUserNames];
        const acceptedUser = newRequestsArray.splice(index, 1)[0];
        newFriendsArray.push(acceptedUser);
        this.setState({
            requestsUserNames: newRequestsArray,
            friendsUserNames: newFriendsArray
        });
    }

    render() {
        const buttonText = this.state.activeTab === 'Friends' ? 'Remove' : 'Accept';
        const userNames = this.state.activeTab === 'Friends' ? this.state.friendsUserNames : this.state.requestsUserNames;
        const friendsTabStyle = {
            backgroundColor: this.state.activeTab === 'Friends' ? '#967dc5' : '#272530',
            color: this.state.activeTab === 'Friends' ? '#272530' : 'white',
        };
        const requestsTabStyle = {
            backgroundColor: this.state.activeTab === 'Requests' ? '#967dc5' : '#272530',
            color: this.state.activeTab === 'Requests' ? '#272530' : 'white',
        };

        return (
            <div className = 'wrapper' style = {{height : "100%"}}>
                <div className = "page">
                    <div id = "friend-head">
                        <div id ='friend-head-label'>Study Deck</div>
                    </div>
                    <div id='friend-main'>
                        <div id = "friend-top">
                            <div id='friend-top-first'></div>
                            <div id='friend-top-second'>
                                <div id='friend-top-user'>
                                    <img src={guest} alt={guest} />
                                    <div id='friend-top-user-content'>
                                        <div id='friend-top-user-name'>Guest</div>
                                        <div id='friend-top-user-number'>{this.state.friendsUserNames.length} Friends</div>
                                    </div>
                                </div>
                                <div id='friend-top-edit'>
                                    <label>Edit profile</label>
                                </div>
                            </div>
                        </div>
                        <div id = "friend-middle">
                            <div id='friend-middle-top'>                               
                                 <div id='friend-middle-top-fr' onClick={() => this.handleTabChange('Friends')} style={friendsTabStyle} >Friends</div>
                                <div id='friend-middle-top-req' onClick={() => this.handleTabChange('Requests')} style={requestsTabStyle}>Requests</div>
                            </div>
                            <FriendTable userNames={userNames}  buttonText={buttonText} onRemoveCell={this.handleRemoveCell}  onAcceptRequest={this.handleAcceptRequest} />
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}