<template>
    <div>
        <div class="jumbotron jumbotron-fluid shadow">
            <h1>{{this.$store.state.collection.collectionName}}</h1>
        </div>
    <span class="row">
        <ul class="col-md-3" 
        v-for="comics in collection" 
        v-bind:key="comics.collectionId"
        v-on:click="retrieveComics(collectionId)"
        >
           <li class="comic">
                <img class="comic-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                <p class="comic-title">{{comic.comicTitle}}</p>
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
            collection: {},
            comicTitle: '',
            comics: {
                data:{}
            },
        }
    },
    methods: {
        retrieveComics(collectionId) {
            ComicServices
            .getComicsByCollectionId(collectionId)
            .then(response => {
                this.title = response.data.title;
                this.$store.commit("SET_COLLECTION_COMICS", response.data.comics);
            })
            .catch(error => {
                if (error.response && error.response.status === 404) {
                    alert(
                        "Comics not available. This collection may have been deleted or you have entered an invalid collection ID."
                    );
                    this.$router.push("/");
                }
            })
        }
    },
    created() {
        ComicServices.getComicsByCollectionId(this.collectionId).then(response => {
            this.comics = response.data
        })
    }
};
</script>
<style scoped>
/* --------------------  header ---------------- */
.jumbotron {
 font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
 color: white;
 background-color: rgba(220, 207, 189, 0.94);
 width: 75%;
 margin: auto;
 padding: 20px;
 border: white solid 6px;
 font-kerning: none;
}
/* ------------------------ collection sections ------------- */
div.row {
 background-color:rgba(220, 207, 189, 0.94);
 width: 75%;
 margin: 15px auto;
 padding: 0px;
 border: white solid 6px;
}
.col-md-12 {
 background-color: white;
 padding: 10px 10px 5px;
 margin: 0px;
 font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
 font-kerning: none;
}
/* ------------------ collection boxes ---------- */
.col-md-2{
 margin: 20px auto;
 padding: 0px;
 background-color: white; /*replace with image that represents collection */
 border: darkgrey solid 1px;
 text-align: center;
 font-family: AnimeAce;
 font-kerning: none;
}
div p.row {
 width: 100%;
 height: 30px;
 display: block;
 border-top: darkgrey solid 1px;
 padding: 5px;
 margin: 0px;
 font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
 font-kerning: none;
}
.col-md-12 .btn{
 margin: auto;
 background-color: none;
 border: none;
 padding: 5px;
 }
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