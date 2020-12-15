<template>
    <div id="collectionPage">
        <span class="row">
<<<<<<< HEAD
            <ul class="col-md-3" v-for="comics in collection" v-bind:key="comics.comicName">
                <li class="comic" v-on:click="toComicDetails(comic.comicName, comic.comicDescription)">
=======
            <ul class="col-md-3" v-for="comics in collection" v-bind:key="comics.collectionId">
                <li class="comic" v-on:click="toComicDetails(comic.comicName)">
>>>>>>> 182916ec85ab12b958bb17664772ecf1316a2e78
                    <img class="comic-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                    <p class="comic-title">{{comics.comicName}}</p>
                </li>
            </ul>
    </span>
  </div>
</template>

<script>
import CollectionService from '../services/CollectionService';
export default {
    name: 'comics-list',
    data(){
        return{
            collectionName: '',
            collectionDesc: '',
            collection: {},
            comicName: '',
            comics: {
                data:{}
            },
        }
    },
    methods: {
        toComicDetails(comicName){
            this.$store.state.comic.comicName = comicName;
            this.$router.push(`/comic/`)
        },
        retrieveComics(collectionId) {
            CollectionService
            .getComicsByCollectionId(collectionId)
            .then(response => {
                this.name = response.data.name;
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
<<<<<<< HEAD
        ComicServices.getComicsByCollectionId(this.$store.state.collection.collectionId).then(response => {
=======
        CollectionService.getComicsByCollectionId(this.$store.state.collection.collectionId).then(response => {
>>>>>>> 182916ec85ab12b958bb17664772ecf1316a2e78
            this.comics = response.data
        })
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