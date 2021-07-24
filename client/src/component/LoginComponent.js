import React from 'react'

import Login from 'react-mua-login'

import 'react-mua-login/dist/index.css'
import http from "../network/http";


class LoginComponent extends React.Component{

    render() {
        return <Login onLogin={(username,password)=>{
            http
                .http
                .post("/auth/login",{
                    username:username,
                    password:password
                })
                .then((res)=>{
                    if(res.data===""){
                        alert("Login failed")
                    }else{
                        localStorage.setItem("jwt",res.data)
                        window.location = "/home"
                    }
                })
        }
        }/>
    }

}

export default LoginComponent;
