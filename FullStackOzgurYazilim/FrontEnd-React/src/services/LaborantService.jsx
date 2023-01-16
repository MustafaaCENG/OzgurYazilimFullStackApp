import axios from 'axios'

const LABORANT_API_BASE_URL = "http://localhost:8888/api/laborants";

class LaborantService {

    getAllLaborants(){
        return axios.get(LABORANT_API_BASE_URL);

    }

    createLaborant(laborant){
        return axios.post(LABORANT_API_BASE_URL, laborant);
    }

}
export default new LaborantService();