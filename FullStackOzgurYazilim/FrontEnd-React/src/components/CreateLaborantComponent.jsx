import React, { Component } from 'react'
import LaborantService from '../services/LaborantService';

class CreateLaborantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
 
            id: this.props.match.params.id,
            firstName: '',
            lastName: '',
            hospitalNumber: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeSurnameHandler = this.changeSurnameHandler.bind(this);
        this.changeHospitalNumberHandler = this.changeHospitalNumberHandler.bind(this);
        this.saveLaborant = this.saveLaborant.bind(this);
    }

 
    saveLaborant = (e) => {
        e.preventDefault();
        let laborant = {
            name: this.state.name, 
            surname: this.state.surname, 
            hospitalNumber: this.state.hospitalNumber};
            console.log('laborant => ' + JSON.stringify(laborant));
            LaborantService.createLaborant(laborant).then(res =>{
                this.props.history.push('');
            });
        } 
    
    
    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changeSurnameHandler= (event) => {
        this.setState({surname: event.target.value});
    }

    changeHospitalNumberHandler= (event) => {
        this.setState({hospitalNumber: event.target.value});
    }

    cancel(){
        this.props.history.push('');
    }

    getTitle(){
            return <h3 className="text-center">Add Laborant</h3>
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
                                            <label> Name: </label>
                                            <input placeholder="Name" name="firstName" className="form-control" 
                                                value={this.state.name} onChange={this.changeNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Surname: </label>
                                            <input placeholder="Surname:" name="lastName" className="form-control" 
                                                value={this.state.surname} onChange={this.changeSurnameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Hospital No: </label>
                                            <input placeholder="Hospital No:" name="emailId" className="form-control" 
                                                value={this.state.hospitalNumber} onChange={this.changeHospitalNumberHandler}/>
                                        </div>
                                        <button className="btn btn-success" onClick={this.saveLaborant} style={{marginLeft: "10px"}} >Save</button>
                                        <button className="btn btn-danger"  onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}
export default CreateLaborantComponent