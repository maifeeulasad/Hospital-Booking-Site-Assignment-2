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
