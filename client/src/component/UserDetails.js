import React from 'react'

import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import {Typography} from "@material-ui/core";

class UserDetails extends React.Component{

    render() {
        return(
            <div>

                <Card>
                    <CardContent>
                        <Typography variant="h5" component="h5">
                            {(this.props.user===undefined || this.props.user===null) ? "" : "Booked by:"}
                        </Typography>
                        <Typography color="textSecondary">
                            {(this.props.user===undefined || this.props.user===null) ? "Available" : "User ID: " + this.props.user["userId"]}
                        </Typography>
                    </CardContent>
                </Card>
            </div>
        )
    }

}

export default UserDetails;
