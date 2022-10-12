import React from "react";

export class Database extends React.Component {
    constructor(props) {
        super(props);
        this.state = {someVal: "Query"}
    }
    render() {
        return (
            <div>
                <h2>Test {this.state.someVal}</h2>
                <input type="text" />
                <br />
                <br />
                <input type="submit" onClick={this.test}/>
            </div>
        );
    }

    test() {
        console.log("test");
    }
}
    