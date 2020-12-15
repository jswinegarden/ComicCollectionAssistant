import axios from 'axios';



export default {
        createCollection(collection){
            return axios.post(`/collections/`, collection)
        },
        getAllCollections(){
            return axios.get(`/collections`);
        },
        getCollectionByCurrentUser(){
            return axios.get(`/collections/mycollections`)
        }
}