import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter,Switch, Route, Redirect} from 'react-router-dom'

import reportWebVitals from './reportWebVitals';
import LoginComponent from "./component/LoginComponent";
import SignupComponent from "./component/SignupComponent";
import HomeComponent from "./component/HomeComponent";
import AuthComponent from "./component/AuthComponent";

ReactDOM.render(
  <React.StrictMode>
          <BrowserRouter>
              <Switch>
                  <Route exact path="/" component={AuthComponent}/>
                  <Route path="/login" component={LoginComponent}/>
                  <Route path="/signup" component={SignupComponent}/>
                  <Route path="/home" component={HomeComponent}/>
                  <Route path="*">
                      <Redirect to={"/home"}/>
                  </Route>
              </Switch>
          </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

reportWebVitals();
