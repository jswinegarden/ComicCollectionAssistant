import axios from 'axios';

export default {
    addComicToAccount(account){
       return axios.post(`/account/`, account)
    },
    getAccountsByCollectionId(collectionId){
        return axios.get(`/account/collections/${collectionId}/comics`)
    }
}