<template>
    <div id="collectionPage">
        <span class="row">
            <ul class="col-md-3" v-for="comics in collection" v-bind:key="comics.collectionId">
                <li class="comic" v-on:click="toComicDetails(comic.comicName)">
                    <img class="comic-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                    <p class="comic-title">{{comic.comicName}}</p>
                </li>
            </ul>
    </span>
  </div>
</template>

<script>
import ComicServices from '../services/ComicServices';
export default {
    name: 'comics-list',
    data(){
        return{
            collectionName: '',
            collectionDesc: '',
            collection: {},
            comicName: '',
            comics: {
            },
        }
    },
    methods: {
        toComicDetails(comicName){
            this.$store.state.comic.comicName = comicName;
            this.$router.push(`/comic/`)
        },
    },
    created() {
        ComicServices.getComicsByCollectionId(this.collectionId).then(response => {
            this.comics = response.data
        })
    }
}
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