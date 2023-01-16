import React, { Component } from 'react'
import LaborantService from '../services/LaborantService'


class ListLaborantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                laborants: []
        }
    }

 

    componentDidMount(){
        LaborantService.getAllLaborants().then((res) => {
            this.setState({ laborants: res.data});
        });
    }

    cancel(){
        this.props.history.push('');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Laborant List</h2>
                 <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Back</button>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Id</th>
                                    <th> Laborant First Name</th>
                                    <th> Laborant Last Name</th>
                                    <th> Laborant Hospital Id</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.laborants.map(
                                        laborant => 
                                        <tr key = {laborant.id}>
                                            <td>  {laborant.id}</td>
                                             <td> {laborant.name} </td>   
                                             <td> {laborant.surname}</td>
                                             <td> {laborant.hospitalNumber}</td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListLaborantComponent