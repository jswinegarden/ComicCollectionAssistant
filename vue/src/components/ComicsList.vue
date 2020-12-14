<template>
<span class="row">
        <ul class="col-md-3" v-for="comics in collection" v-bind:key="comics.collectionId">
           <li class="comic">
                <img class="camic-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
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
            title: "",
            collectionId: 0
        }
    },
    methods: {
        retrieveComics() {
            comicServices
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
        this.collectionId = this.$route.params.id;
        this.retrieveComics();
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