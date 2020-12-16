import axios from 'axios';

export default {
    addComicToAccount(){
       return 
    },
    getAccountInfo(){
        return axios.get(`/account`);
    },
    getAccountsByCollectionId(collectionId){
        return axios.get(`account/collections/${collectionId}/comics`)
    },


}