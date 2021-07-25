import React from 'react';
import Item from "./Item";
import http from "../network/http";
import {TextField,Button} from "@material-ui/core";

import './common.css'

class HomeComponent extends React.Component{

    constructor(props) {
        super(props);
        this.state={
            list:[],
            disable:false,
            update:false,
            isAdmin:false,
            startTime:'',
            endTime:'',
        }
    }

    fetchList = () => {
        http
            .http
            .get("/timeslot/available")
            .then((res)=>{
                this.setState({
                    list:res.data,
                    disable:false
                })
            })
    }

    checkAdmin = () => {
        http
            .http
            .get("/user/isadmin")
            .then((res)=>{
                this.setState({
                    isAdmin:res.data
                })
            })
    }

    fetchDetailedList = () => {
        http
            .http
            .get("/timeslot/detailed")
            .then((res)=>{
                this.setState({
                    list:res.data,
                    disable:false
                })
            })
    }

    componentDidMount() {
        this.checkAdmin();
        this.fetchList();
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if(this.state.update!==prevState.update){
            this.fetchList();
        }
        if(this.state.isAdmin===true && prevState.isAdmin===false){
            this.fetchDetailedList();
        }
    }

    renderList = () => {
        return this.state.list.map((item)=>{
            return <Item
                isAdmin={this.state.isAdmin}
                item={item}
                key={item["timeSlotId"]}
                onUpdate={()=>{this.setState({update:!this.state.update})}}
                onClick={()=>{this.setState({disable:true})}}/>
        })
    }

    renderTimePicker = () => {
        return(
            <div>
                <TextField
                    id="datetime-local"
                    label="Starting Time"
                    type="datetime-local"
                    defaultValue={""}
                    InputLabelProps={{
                        shrink: true,
                    }}
                    onChange={(e)=>{
                        this.setState({
                            startTime:e.target.value+":00.000000"
                        })
                    }}
                />
                <TextField
                    id="datetime-local"
                    label="End Time"
                    type="datetime-local"
                    defaultValue={""}
                    InputLabelProps={{
                        shrink: true,
                    }}
                    onChange={(e)=>{
                        this.setState({
                            endTime:e.target.value+":00.000000"
                        })
                    }}
                />
                <Button onClick={()=>{
                    let startTime = this.state.startTime
                    let endTime = this.state.endTime
                    if(startTime && endTime){
                        http
                            .http
                            .post("/timeslot/create",{
                                startTime:startTime,
                                endTime:endTime
                            })
                            .then((res)=>{
                                if(res.data===true){
                                    this.setState({
                                        update:!this.state.update
                                    })
                                }else{
                                    alert("Creation failed")
                                }
                            })
                    }
                }
                }>
                    Create
                </Button>
            </div>
        )
    }

    render() {
        return(
            <div>
                <h1>home</h1>
                <div className={this.state.disable ? "disabled" : ""}>
                    {this.renderList()}
                    {this.state.isAdmin && this.renderTimePicker()}
                </div>
            </div>
        )
    }
}

export default HomeComponent;
