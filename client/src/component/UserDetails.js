import React from 'react'

class UserDetails extends React.Component{

    render() {
        return(
            <div>
                <h4>{(this.props.user===undefined || this.props.user===null) ? "" : "Booked by:"}</h4>
                <div>{(this.props.user===undefined || this.props.user===null) ? "Available" : this.props.user["userId"]}</div>
            </div>
        )
    }

}

export default UserDetails;
