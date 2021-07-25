import React from 'react';
import AuthHoc from "./AuthHoc";
class AuthComponent extends React.Component{

    componentDidMount() {
        window.location = "/home"
    }

    render(){
        return(<div/>)
    }

}

export default AuthHoc(AuthComponent);
