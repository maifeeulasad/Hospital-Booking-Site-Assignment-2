import React from 'react'
import http from "../network/http";
import UserDetails from "./UserDetails";

class Item extends React.Component{

    onClick = (id) => {
        http
            .http
            .post("/timeslot/book",{
                timeSlotId: id
            })
            .then((res)=>{
                this.props.onUpdate();
                if(res.data===false){
                    alert("Booking failed")
                }
            })
        this.props.onClick(true);
    }

    render() {
        return(
            <div
                onClick={()=>{
                    this.onClick(this.props.item["timeSlotId"])
                }}>
                <div>{this.props.item["startTime"]+"~"+this.props.item["endTime"]}</div>
                {this.props.isAdmin && <UserDetails user={this.props.item["user"]}/>}
            </div>
        )
    }

}

export default Item;
