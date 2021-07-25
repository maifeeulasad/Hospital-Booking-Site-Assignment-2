# Hospital-Booking-Site-Assignment-2

## Features
 - Login/Signup
 - Auth JWT based
 - If Admin,
   - Can create booking/slot
   - Can view every booking available or booked
 - If User,
   - Can only see own's list
   - Can book

## Client: 
 - https://github.com/maifeeulasad/Hospital-Booking-Site-Assignment-2/tree/main/client
 - navigate
 - in terminal:
   ```
   yarn
   yarn start #dev mode, to build, package.json needs to be changed
   ```
   
## Server
 - https://github.com/maifeeulasad/Hospital-Booking-Site-Assignment-2/tree/main/hbs
 - navigate
 - in terminal:
   ```
   mvn install
   ./mvnw spring-boot:run
   ```
## API details:
```
GET: /auth/check -> if the jwt token is valid, based on that route to login or home
POST: /auth/login({username,password}) -> login and return jwt based on valid login credential
POST: /auth/signup({username,password}) -> create login credential, and username is unique
GET: /timeslot/available -> returns all avialable timeslots
POST: /timeslot/book({id}) -> book if the timeslot is available, non admin
POST: /timeslot/create({startTime,endTime}) -> create timeslot, admin only
GET: /timeslot/detailed  -> get all timeslot with user details, admin only
GET: /timeslot/mine -> get all timeslot allocated for me
GET: /user/isadmin -> check if user is admin, render feature
```

# Admin View (With no booking):
![](https://github.com/maifeeulasad/Hospital-Booking-Site-Assignment-2/blob/doc/snaps/Screenshot%20from%202021-07-25%2013-18-17.png)

# Admin View (With booking):
![](https://github.com/maifeeulasad/Hospital-Booking-Site-Assignment-2/blob/doc/snaps/Screenshot%20from%202021-07-25%2013-18-57.png)

# User View (with no booking):
![](https://github.com/maifeeulasad/Hospital-Booking-Site-Assignment-2/blob/doc/snaps/Screenshot%20from%202021-07-25%2013-18-39.png)

# User View (with booking):
![](https://github.com/maifeeulasad/Hospital-Booking-Site-Assignment-2/blob/doc/snaps/Screenshot%20from%202021-07-25%2013-18-45.png)

# Login
![](https://github.com/maifeeulasad/Hospital-Booking-Site-Assignment-2/blob/doc/snaps/Screenshot%20from%202021-07-25%2013-24-02.png)

# Signup
![](https://github.com/maifeeulasad/Hospital-Booking-Site-Assignment-2/blob/doc/snaps/Screenshot%20from%202021-07-25%2013-24-07.png)



## Dependencies - React:
```
    "react-mua-login": "^2.1.3",         # library by me
    "react-mua-signup": "^2.1.3",        # library by me
    "@emotion/react": "^11.4.0",         #for material-ui
    "@emotion/styled": "^11.3.0",        #for material-ui
    "@material-ui/core": "^5.0.0-beta.1",  #for material-ui
    "@material-ui/lab": "^4.0.0-alpha.60", #for material-ui
    "@material-ui/pickers": "^3.3.10",     #for material-ui
    "axios": "^0.21.1",                    # for fetching data
    "qs": "^6.10.1",                       # json parsing
 ```
 
 ## Dependencies - Spring Boot:
 ```
 spring-boot-starter-data-jpa  #persistant API
 spring-boot-starter-web       # rest API
 lombok                        #getter,setter, constructor
 h2                            #sql database
 java-jwt + spring-boot-starter-security + spring-boot-starter-webflux   #security
 ```
