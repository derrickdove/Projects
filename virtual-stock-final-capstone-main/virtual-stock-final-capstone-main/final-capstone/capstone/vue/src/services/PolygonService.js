import axios from "axios";

export default {

    getResults(ticker) {
        return axios.get('/resultsObject', {
            params: {
                ticker : ticker
            }
        });
    }

}