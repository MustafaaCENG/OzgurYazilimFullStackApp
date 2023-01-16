import React, { Component } from 'react'
import ReportService from '../services/ReportService'

    class ListReportComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            searchTerm :'',
            reports : []
        }
        this.addReport = this.addReport.bind(this);
        this.editReport = this.editReport.bind(this);
        this.deleteReport = this.deleteReport.bind(this);
        this.addLaborant = this.addLaborant.bind(this);
        this.getLaborants = this.getLaborants.bind(this);
        this.findInApi = this.findInApi.bind(this);
        this.queryDateMain = this.queryDateMain.bind(this);
        this.mainScreen = this.mainScreen.bind(this);
        this.returnBack = this.returnBack.bind(this);
        this.changeSearchValuelHandler = this.changeSearchValuelHandler.bind(this)
    }

    deleteReport(id){
        ReportService.deleteReport(id).then( res => {
            this.setState({reports: this.state.reports.filter(report => report.id !== id)});
        });
    }
    viewReport(id){
        this.props.history.push(`/view-report/${id}`);
    }
    editReport(id){
        this.props.history.push(`/update-report/${id}`);
    }

    addReport(){
        this.props.history.push('/add-report');
    }

    addLaborant(){
        this.props.history.push('/add-laborant')
    }

    getLaborants(){
        this.props.history.push('/laborants')
    }

    mainScreen(){
        this.props.history.push('')

    }
    queryDateMain(){
        this.props.history.push('/queryDate')
    }
    

    componentDidMount(){
        this.props.history.push('')
        ReportService.getReports().then((res) => {
            this.setState({reports: res.data}); 

        });
    }

    returnBack(){
         ReportService.getReports().then((res) => {
            this.setState({reports: res.data}); 
        })
    }

    findInApi(value){
       // this.props.history.push(`/searchResult/${value}`)
        ReportService.searchInApi(value).then((res) => {
            this.setState({reports: res.data}); 
    })}

    changeSearchValuelHandler= (event) => {
        this.setState({searchTerm: event.target.value});
    }

render() {
    return (
      <div style={{width:"1500px", alignContent:"center"}}>
        <h2 className="text-center">Report List</h2>
                 <div className = "row" style={{textAlign:"center" , marginLeft:"4px",}} >
                    <button className="btn btn-secondary" style={{textAlign:"center" , marginLeft:"4px"}} onClick={this.mainScreen}> Main</button>
                    <button className="btn btn-primary" style={{textAlign:"center" , marginLeft:"4px"}} onClick={this.addReport}> Add Report</button>
                    <button className="btn btn-primary" style={{textAlign:"center" , marginLeft:"4px"}} onClick={this.addLaborant}> Add Laborant</button>
                    <div></div>
                    <button className="btn btn-primary " style={{textAlign:"center" , marginLeft:"4px"}} onClick={this.getLaborants}> Gets Laborant</button>
                    <button className="btn btn-primary" style={{textAlign:"center" , marginLeft:"4px"}} onClick={this.queryDateMain}> List By Date</button>
    
                    
                    <br /><br />
                    <input type="text" placeholder="Search" style={{textAlign:"center" , marginLeft:"4px"}} value={this.state.searchTerm} onChange={ this.changeSearchValuelHandler} />
                    <button className="btn btn-primary" style={{textAlign:"center" , marginLeft:"4px"}} onClick={() => this.findInApi(this.state.searchTerm)}>
                    Search
                    </button>
                
                    <button className="btn btn-danger" style={{textAlign:"center" , marginLeft:"4px"}} onClick={this.returnBack}>Back</button>



                 </div>
                 <br></br>
        <div className="row" style={{textAlign:"center",alignContent:"center"}}>
            <table className="table table-stripd table-bordered">
                <thead>
                    <tr>
                    <th>ID</th>

                    <th>File No</th>
                    <th>Paitent Name</th>
                    <th>Paitent Surname</th>
                    <th>National Id</th>
                    <th>Disease</th>
                    <th>Date</th>
                    <th>Laborant</th>
                    <th style={{width:"250px"}}>Action</th>

                    </tr>
                </thead>

                <tbody style={{textAlign:"center"}}>
                    {
                        this.state.reports.map (
                            report => 
                            <tr key={report.id}>
                                <td>{report.id}</td>

                                <td>{report.fileNo}</td>
                                <td>{report.name}</td>
                                <td>{report.surname}</td>
                                <td>{report.nationalID}</td>
                                <td>{report.disease}</td>
                                <td>{report.createdDate}</td>
                                <th>{report.adminFirstName + " " + report.adminLastName}</th>
                                <td>             <button style={{marginLeft: "5px"}} onClick={ () => this.editReport(report.id)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "5px"}} onClick={ () => this.deleteReport(report.id)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "5px"}} onClick={ () => this.viewReport(report.id)} className="btn btn-info">View </button></td>

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
  export default ListReportComponent