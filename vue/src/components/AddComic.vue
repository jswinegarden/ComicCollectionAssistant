<template>
<span>
    <span class="row">
        <div class="form-check-inline" v-for="collection in collections" v-bind:key=" collection.collectionId">
            <label class="form-check-label">
            <input type="checkbox" class="form-check-input" value="">
                {{collection.collectionName}} - {{collection.collectionId}}
            </label>
        </div>
    </span> 

    <div class="row">
        <input v-model="comicTitle" type="search" class="form-control col-md-9" placeholder="Search by Issue Name" name="q">
        <button class="btn btn-dark col-md-2" v-on:click="searchComics(comicTitle)">Search</button>
    </div>
    <div class="row">
        <ul class="col-md-4" v-for="comic in comics.data.results" v-bind:key="comic.title">
            <li class="card">
                <img class="card-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                <p class="card-title">{{comic.title}}</p>
                <div class="btn btn-dark" v-on:click="addComic(comic)">Select Comic</div>
            </li>
        </ul>
    </div>
</span>
</template>

<script>
import CollectionService from '@/services/CollectionService.js'
import ComicServices from "@/services/ComicServices.js"

export default {
    name: "add-comic",
    data(){
        return{
            comicTitle: '',
            colections: {
            },
            comics: {
                data:{}
            },
            account:{
                comicId:'',
                collectionId:'',    /*collection id comic condition and trade status all selected by user */
                comicConditionId:'',
                comicTradableStatusId:''
            },
            comic:{
                comicId:'',
                comicName:'',
                comicCharacters:'',
                authorName:'',
                datePublished:''
            }
        }
    },
    methods: {
        searchComics(title) {
            ComicServices.getComicsByName(title).then(response => {
                this.comics = response.data;
                this.comicTitle = '';
            })
        },
        addComic(comic){
            this.comic.comicId = comic.id;
            this.comic.comicName = comic.title;
            this.comic.comicCharacters = comic.characters.items[0].name;
            this.comic.authorName = comic.creators.items[0].name;
            this.comic.datePublished = comic.dates[0].date;
            this.account.comicId = comic.id;
            this.account.comicConditionId = '';
            this.account.comicTradableStatusId = '';
            this.account.collectionId = '';
        }
    },
    created(){
        CollectionService.getCollectionByCurrentUser().then(response => {
            this.collections = response.data;
        })
    }
}
</script>

<style scoped>
.dropdown{
    margin:50px;
}
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