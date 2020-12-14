<template>
<span class="row">
        <ul class="col-md-3" v-for="comic in comics" v-bind:key="comic.id">
           <li class="comic">
                <img class="camic-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                <p class="comic-title">{{comic.comicTitle}}</p>
            </li>
        </ul>
  </span>
</template>

<script>
import comicServices from '../services/ComicServices';

export default {
    name: 'comics-list',
    data(){
        return{
            comics:{
            },
        }
    },
    created(){
        ComicServices.getComicsByColectionId().then(response => {
            this.comics = response.data
        })
    },
};
</script>
<style scoped>
.comic{
    padding:10px;
}
.comic:hover{
    background-color: wheat;
}
.comic-title{
    padding-top: 10px;
}
.row{
   margin: 10px auto;
}
</style>