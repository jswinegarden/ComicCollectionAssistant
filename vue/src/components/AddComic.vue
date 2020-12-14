<template>
<span>
    <div class="row">
        <input v-model="comicTitle" type="search" class="form-control col-md-9" placeholder="Search by Issue Name" name="q">
        <button class="btn btn-dark col-md-2" v-on:click="searchComics(comicTitle)">Search</button>
    </div>
    <div class="row">
        <ul class="col-md-4" v-for="comic in comics.data.results" v-bind:key="comic.title">
            <li class="card">
                <img class="card-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                <p class="card-title">{{comic.title}}</p>
                <div class="btn btn-dark">add comic</div>
            </li>
        </ul>
    </div>
</span>
</template>

<script>
import ComicServices from "@/services/ComicServices.js"

export default {
    name: "add-comic",
    data(){
        return{
            comicTitle: '',
            comics: {
                data:{}
            },
        }
    },
    methods: {
        searchComics(title) {
            ComicServices.getComicsByName(title).then(response => {
                this.comics = response.data;
                this.comicTitle = '';
            })
        }
    }
}
</script>

<style scoped>
span{
    width: 100%;
    margin: auto 2%;
}
input{
    margin:auto;
}
button{
    margin:auto;
}
.card{
    margin:10px auto;
    padding: 5px;
}
ul{
   list-style-type: none; 
}

</style>