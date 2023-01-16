import React, { Component } from 'react'
import ReportService from '../services/ReportService'

class ViewReportComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            report: {}
        }
        this.cancel = this.cancel.bind(this);
    }
    cancel(){
        this.props.history.push('');
    }
    componentDidMount(){
        ReportService.getReportById(this.state.id).then( res => {
            this.setState({report: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3" style={{
                     margin: "auto",
                     padding: "15px",
                     maxWidth: "600px",
                     alignContent: "center",
                 }}>
                    <h3 className = "text-center"> View Report Details</h3>
                    <button className="btn btn-danger" onClick={this.cancel}>Back</button>
                    <div className = "card-body">
                        <div className = "row">
                            <label> File No :  </label>
                            <div> { this.state.report.fileNo }</div>
                        </div>
                        <div className = "row">
                            <label> Paitent Name:  </label>
                            <div> { this.state.report.name }</div>
                        </div>
                        <div className = "row">
                            <label> Paitent Surname :  </label>
                            <div> { this.state.report.surname }</div>
                        </div>
                        <div className = "row">
                            <label> National ID: </label>
                            <div> { this.state.report.nationalID }</div>
                        </div>
                        <div className = "row">
                            <label> Disease : </label>
                            <div> { this.state.report.disease }</div>
                        </div>
                        <div className = "row">
                            <label> Description : </label>
                            <div> { this.state.report.description }</div>
                        </div>
                        <div className = "row">
                            <label> Create Date : </label>
                            <div> { this.state.report.createdDate }</div>
                        </div>
                        <div className = "row">
                            <label> Laborant Id:</label>
                            <div> { this.state.report.laborantId }</div>
                        </div>
                        <div className = "row">
                            <label> Laborant Name  : </label>
                            <div> { this.state.report.adminFirstName }</div>
                        </div>
                        <div className = "row">
                            <label> Laborant Surname</label>
                            <div> { this.state.report.adminLastName }</div>
                        </div>
                        <img src={ this.state.report.photoUrl } alt=""                           style={{ width: "500px" }} />
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewReportComponent