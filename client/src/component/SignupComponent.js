import React from 'react'

import Signup from 'react-mua-signup'

import 'react-mua-signup/dist/index.css'
import http from "../network/http";

class SignupComponent extends React.Component{

    render() {
        return <Signup onSignup={(username,password)=>{
            http
                .http
                .post("/auth/signup",{
                    username:username,
                    password:password
                })
                .then((res)=>{
                    console.log(res)
                    if(res.data===false){
                        alert("Join failed")
                    }else{
                        window.location = "/login"
                    }
                })
        }
        }/>
    }

}

export default SignupComponent;
