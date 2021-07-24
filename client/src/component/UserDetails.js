import React from 'react'

class UserDetails extends React.Component{

    render() {
        console.log(this.props.user)
        return(
            <div>
                <h4>User details</h4>
                <div>{(this.props.user===undefined || this.props.user===null) ? "Available" : this.props.user["userId"]}</div>
            </div>
        )
    }

}

export default UserDetails;
