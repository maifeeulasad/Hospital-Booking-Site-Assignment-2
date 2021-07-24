import React from 'react'

class Item extends React.Component{

    onClick = (id) => {
        console.log(id)
        this.props.onClick(true);
    }

    render() {
        return(
            <div
                onClick={()=>{
                    this.onClick(this.props.item["timeSlotId"])
                }}>
                <div>{this.props.item["startTime"]+"~"+this.props.item["endTime"]}</div>
            </div>
        )
    }

}

export default Item;
