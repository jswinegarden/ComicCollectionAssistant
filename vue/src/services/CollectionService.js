import axios from 'axios';



export default {
        createCollection(collection){
            return axios.post(`/collections/`, collection)
        },
        viewCollection(collection){
            return axios.get(`/collections/`, collection)
        }
}