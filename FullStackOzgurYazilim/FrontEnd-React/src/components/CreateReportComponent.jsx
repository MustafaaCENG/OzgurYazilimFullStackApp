import React, { Component } from 'react'
import ReportService from '../services/ReportService';


class CreateReportComponents extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            fileNo : '',
            name: '',
            surname: '',
            nationalID: '',
            disease : '',
            description: '',
            createdDate : '',
            laborantId: '',
            photoUrl : ''
        }
        this.changeFileNoHandler = this.changeFileNoHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeSurnameHandler = this.changeSurnameHandler.bind(this);
        this.changeNatilonalIdHandler = this.changeNatilonalIdHandler.bind(this);
        this.changeDiseaseHandler = this.changeDiseaseHandler.bind(this);
        this.changeDescriptionHandler = this.changeDescriptionHandler.bind(this)
        this.changeDateHandler = this.changeDateHandler.bind(this);
        this.changeLaborantIdHandler = this.changeLaborantIdHandler.bind(this);
        this.changePhotoUrlHandler = this.changePhotoUrlHandler.bind(this);
        this.saveReport = this.saveReport.bind(this);
    }

   
    saveReport = (e) => {
        e.preventDefault();
        let newreport = {
            fileNo: parseInt(this.state.fileNo),
            name: this.state.name, 
            surname: this.state.surname, 
            nationalID: parseInt(this.state.nationalID),
            disease: this.state.disease,
            description: this.state.description,
            createdDate: this.state.createdDate,
            laborantId :parseInt(this.state.laborantId),
            photoUrl : this.state.photoUrl
        };
        console.log('report => ' + JSON.stringify(newreport));

            ReportService.createReport(newreport).then(res =>{
                this.props.history.push('');
            });
        
    }
    
    changeFileNoHandler= (event) => {
        this.setState({fileNo: event.target.value});
    }
    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changeSurnameHandler= (event) => {
        this.setState({surname: event.target.value});
    }

    changeNatilonalIdHandler= (event) => {
        this.setState({nationalID: event.target.value});
    }
     
    changeDiseaseHandler= (event) => {
        this.setState({disease: event.target.value});
    }
    changeDescriptionHandler= (event) => {
        this.setState({description: event.target.value});
    }
    changeDateHandler= (event) => {
        this.setState({createdDate: event.target.value});
    }
    changeLaborantIdHandler= (event) => {
        this.setState({laborantId: event.target.value});
    }
    changePhotoUrlHandler= (event) => {
        this.setState({photoUrl: event.target.value});
    }

    cancel(){
        this.props.history.push('');
    }

    getTitle(){
         
            return <h3 className="text-center">Add Report</h3>
         
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                    <div className = "form-group">
                                            <label> File No: </label>
                                            <input placeholder="File No" name="firstName" className="form-control" 
                                                value={this.state.fileNo} onChange={this.changeFileNoHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Name: </label>
                                            <input placeholder="First Name" name="firstName" className="form-control" 
                                                value={this.state.name} onChange={this.changeNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Surname: </label>
                                            <input placeholder="Last Name" name="lastName" className="form-control" 
                                                value={this.state.surname} onChange={this.changeSurnameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> National ID: </label>
                                            <input placeholder="National ID" name="nationalID" className="form-control" 
                                                value={this.state.nationalID} onChange={this.changeNatilonalIdHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Disease: </label>
                                            <input placeholder="Disease" name="Disease" className="form-control" 
                                                value={this.state.disease} onChange={this.changeDiseaseHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Description: </label>
                                            <input placeholder="Description" name="Description" className="form-control" 
                                                value={this.state.description} onChange={this.changeDescriptionHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Laborant Id: </label>
                                            <input placeholder="Laborant ID" name="laborantId" className="form-control" 
                                                value={this.state.laborantId} onChange={this.changeLaborantIdHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Photo Url: </label>
                                            <input placeholder="Photo Url" name="photoUrl" className="form-control" 
                                                value={this.state.photoUrl} onChange={this.changePhotoUrlHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveReport}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateReportComponents
