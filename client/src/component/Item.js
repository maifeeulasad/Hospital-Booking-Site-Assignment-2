import React from 'react'
import http from "../network/http";
import UserDetails from "./UserDetails";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import CardActions from "@material-ui/core/CardActions";
import {Button, TextField} from "@material-ui/core";

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
            <div>
                <Card>
                    <CardContent>
                        <TextField
                            disabled
                            id="datetime-local"
                            label="Starting Time"
                            type="datetime-local"
                            defaultValue={this.props.item["startTime"].substr(0,16)}
                            InputLabelProps={{
                                shrink: true,
                            }}
                        />
                        <TextField
                            disabled
                            id="datetime-local"
                            label="Ending Time"
                            type="datetime-local"
                            defaultValue={this.props.item["endTime"].substr(0,16)}
                            InputLabelProps={{
                                shrink: true,
                            }}
                        />
                    </CardContent>
                    {
                        !this.props.isAdmin &&
                        <CardActions>
                            <Button
                                onClick={()=>{
                                    this.onClick(this.props.item["timeSlotId"])
                                }}
                                size="small">
                                Book
                            </Button>
                        </CardActions>
                    }
                </Card>
                {this.props.isAdmin && <UserDetails user={this.props.item["user"]}/>}
            </div>
        )
    }

}

export default Item;
