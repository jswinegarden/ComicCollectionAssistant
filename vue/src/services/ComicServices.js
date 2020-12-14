import axios from 'axios';

const http = axios.create({
    baseURL: "https://gateway.marvel.com:443/v1/public/"
});

export default {
    getComicIssue(){/* gets a list of 50 comics, plan to search by name and have a smaller limit to make selection form but not yet implemented*/
        return http.get(`comics?format=comic&formatType=comic&orderBy=title&limit=50&apikey=9d96d996f4bfce42975b47820c47174a&hash=eadb34d00cfcc0a0b08ebf5d5b1123ff&ts=1`);
    },
    getComicsByName(title){
        return http.get(`comics?format=comic&formatType=comic&orderBy=title&limit=12&title=${title}&apikey=9d96d996f4bfce42975b47820c47174a&hash=eadb34d00cfcc0a0b08ebf5d5b1123ff&ts=1`)
    }
    
}