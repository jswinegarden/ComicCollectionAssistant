<template>
    <div id="collectionPage">
        <span class="row">
            <ul class="col-md-3" v-for="comic in comics" v-bind:key="comic.comicId">
                <li class="comic" v-on:click="toComicDetails(comics.comicName)">
                    <img class="comic-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                    <p class="comic-title">{{comic.comicName}}</p>
                </li>
            </ul>
    </span>
  </div>
</template>

<script>
import CollectionService from '../services/CollectionService';
import AccountServices from '../services/AccountServices';
export default {
    name: 'comics-list',
    data(){
        return{
            collectionName: '',
            collectionDesc: '',
            collection: {},
            comicName: '',
            accounts: {
                data:{}
            },
            comics: {
                data:{}
            }
        }
    },
    methods: {
        toComicDetails(comicName){
            this.$store.state.comic.comicName = comicName;
            this.$router.push(`/comic/`)
        },
        retrieveComics(collectionId) {
            AccountServices
            .getAccountsByCollectionId(collectionId)
            .then(response => {
                
                this.$store.commit("SET_ACCOUNTS", response.data.accounts);
            })
            /*this.account.comicId;
            this.account.colletionId;*/
            .catch(error => {
                if (error.response && error.response.status === 404) {
                    alert(
                        "Comics not available. This collection may have been deleted or you have entered an invalid collection ID."
                    );
                    this.$router.push("/");
                }
            })
        },
        
    },
    created() {
        AccountServices.getAccountsByCollectionId(this.$store.state.accounts.collectionId).then(response => {
            this.accounts = response.data
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