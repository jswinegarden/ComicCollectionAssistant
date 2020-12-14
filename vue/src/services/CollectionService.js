import axios from 'axios';



export default {
        createCollection(collection){
            return axios.post(`/collections/`, collection)
        },
        viewCollection(collectionId){
            return axios.get(`/collections/${collectionId}`)
        },
        getAllCollections(){
            return axios.get(`/collections`);
        }
}