import axios from 'axios'
import qs from 'qs'

let url = "http://localhost:8080"

function parseError (messages) {
    if (messages) {
        if (messages instanceof Array) {
            return Promise.reject({ messages: messages })
        } else {
            return Promise.reject({ messages: [messages] })
        }
    } else {
        return Promise.reject({ messages: ["--error--"] })
    }
}

function parseBody (response) {
    if (response.status === 200) {
        return response
    } else {
        return this.parseError(response.data.messages)
    }
}

let http = axios.create({
    baseURL: url,
    paramsSerializer: function (params) {
        return qs.stringify(params, { indices: false })
    }
})

http.interceptors.request.use((config) => {
    let jwt = localStorage.getItem("jwt");
    if(jwt!==null && jwt!==undefined){
        config.headers = { 'Authorization': 'Bearer '+jwt}
    }
    return config
}, error => {
    return Promise.reject(error)
})

http.interceptors.response.use((response) => {
    return parseBody(response)
}, error => {
    console.warn('Error status', error.response)
    if (error.response) {
        return parseError(error.response)
    } else {
        return Promise.reject(error)
    }
})

const exp = {
    http
}

export default exp
