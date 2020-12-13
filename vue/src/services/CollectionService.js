import axios from 'axios';

const http = axios.create({
    baseURL: "https://localhost:8080"
});

export default {
    methods:{
        createCollection(collection){
            return http.post(`/collections`,collection)
        },
        updateCollection(collection_id, collection){
            return http.post(`/collections/${collection_id}`, collection)
        }
    }

}