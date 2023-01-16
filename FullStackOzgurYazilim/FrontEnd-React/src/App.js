import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListReportComponent from './components/ListReportComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateReportComponents from './components/CreateReportComponent';
import UpdateReportComponent from './components/UpdateReportComponent';
import ViewReportComponent from './components/ViewReportComplement';
import CreateLaborantComponent from './components/CreateLaborantComponent';
import ListLaborantComponent from './components/ListLaborantComponent';
import QueryDateReportComponent from './components/QueryDateReportComponent';
function App() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container" style={{
          margin: "auto",
          padding: "15px",
          maxWidth: "1500px",
          alignContent: "center",
        }}>
                    <Switch>  
                          <Route path = "/" exact component = {ListReportComponent}></Route>
                          <Route path = "/reports" exact component = {ListReportComponent}></Route>
                          <Route path = "/add-report" exact component = {CreateReportComponents}></Route>
                          <Route path = "/update-report/:id" exact component = {UpdateReportComponent}></Route>
                          <Route path = "/view-report/:id" component = {ViewReportComponent}></Route>
                          <Route path = "/add-laborant" component = {CreateLaborantComponent}></Route>
                          <Route path = "/laborants" component = {ListLaborantComponent}></Route>
                          <Route path = "/queryDate" exact component = {QueryDateReportComponent}></Route>

                    </Switch>
                </div>
              {<FooterComponent />}
        </Router>
    </div>
  );
}

export default App;
