import axios from 'axios';

const http = axios.create({
    baseURL: "http://comicvine.gamespot.com/api"
});

export default {
    getComicIssue(name){
        return http.get(`/issues/?api_key=47f0b6437656ab0357447c9de1cbdc532a5269fe&filter=name${name}&field_list=id,name,image`);
    },
    
}