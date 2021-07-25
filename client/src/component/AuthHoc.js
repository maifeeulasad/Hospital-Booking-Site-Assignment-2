import React from 'react';
import http from "../network/http";

let AuthHoc = ComposedComponent => class extends React.Component {

    componentDidMount() {
        if(localStorage.getItem("jwt")===undefined
            || localStorage.getItem("jwt")===null){
            window.location = "/login"
        }else{
            http
                .http
                .get("/auth/check")
                .then((res)=>{
                    if(res.data){
                        window.location = "/home"
                    }else{
                        window.location = "/login"
                    }
                })
                .catch(()=>{
                    window.location = "/login"
                })
        }
    }

    render() {
        return <ComposedComponent {...this.props} {...this.state} />;
    }
};

export default AuthHoc;
