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
        },
        getComicsByCollectionId(collectionId){
            return axios.get(`account/collections/${collectionId}/comics`)
        },
        getComicDetails(collectionId, comicId){
            return axios.get(`/collections/${collectionId}/comics/${comicId}`)
        },
        getComicByComicId(comicId){
            return axios.get(`/comics/${comicId}`)
        }
}