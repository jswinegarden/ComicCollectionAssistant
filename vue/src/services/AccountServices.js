import axios from 'axios';

export default {
    addComicToAccount(account){
       return axios.post(`/account`, account)
    },
    getAccount(){
        return axios.get(`/account`)
    }


}