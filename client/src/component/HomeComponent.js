import React from 'react';
import Item from "./Item";
import http from "../network/http";

import './common.css'

class HomeComponent extends React.Component{

    constructor(props) {
        super(props);
        this.state={
            list:[],
            disable:false,
            update:false,
            isAdmin:false
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

    render() {
        return(
            <div>
                <h1>home</h1>
                <div className={this.state.disable ? "disabled" : ""}>
                    {this.renderList()}
                </div>
            </div>
        )
    }
}

export default HomeComponent;
