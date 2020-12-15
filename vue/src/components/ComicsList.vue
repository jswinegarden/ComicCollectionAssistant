<template>
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
</template>

<script>
import ComicServices from '../services/ComicServices';

export default {
    name: 'comics-list',
    data(){
        return{
            comicTitle: '',
            comics: {
                data:{}
            },
        }
    },
    methods: {
        retrieveComics(collectionId) {
            ComicServices
            .getComicsByCollectionId(this.collectionId)
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
        ComicsServices.getComicsByCollectionId(collectionId).then(response => {
            this.comoics = response.data
        });

        ComicServices.getComicIssue().then(respnse => {
      this.comics = response.data
        });

    }
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