import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
        createCollection(collection){
            return http.post(`/collections`,collection)
        },
        updateCollection(collection_id, collection){
            return http.post(`/collections/${collection_id}`, collection)
        }
}