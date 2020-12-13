<template>
    <div>
        <div class="row">
            <div class="col-md-8">
                <input type="text" v-model="collection.collection_name" class="form-control" placeholder="Collection Title" name="Collection Title">
            </div>
            <div class="col-md-2">
                <button type="button" v-show="visibility" v-on:click="changeVis()" class="btn btn-primary">Make Private</button>
                <button type="button" v-show="!visibility" v-on:click="changeVis()" class="btn btn-primary">Make Public</button>
            </div>
            <div class="col-md-2">
                <button type="button" v-show="!fav" v-on:click="changeFav()" class="btn btn-primary">Make Favorite</button>
                <button type="button" v-show="fav" v-on:click="changeFav()" class="btn btn-primary">Unfavorite</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <textarea v-model="collection.collection_desc" class="form-control" rows="5" placeholder="Collection Description"/>
            </div>
            <div class="col">
                <router-link class="btn btn-primary"  v-bind:to="{ name: 'newComic' }">Save Collection</router-link>
            </div>
        </div>
    </div>
</template>

<script>
import collectionServices from "../services/CollectionService"
export default {
    name: "add-collection",
    
    data() {
        return {
            fav: false,
            visibility: false,
            collection: {
                collection_id: '',
                collection_name:'',
                colection_desc:'',
                favorite_status_id: 2,
                collection_visibility_id: 1
            }
        };
    },
    methods: {
        saveCollection() {
            collectionServices
        },
        changeVis(){
            if(this.collection.collection_visibility_id == 1){
                this.collection.collection_visibility_id = 2;
                this.visibility = !this.visibility;
            }else if(this.collection.collection_visibility_id == 2){
                this.collection.collection_visibility_id = 1;
                this.visibility = !this.visibility;
            }
        } ,
        changeFav(){
            if(this.collection.favorite_status_id == 1){
                this.collection.favorite_status_id = 2;
                this.fav = !this.fav;
            }else if(this.collection.favorite_status_id == 2){
                this.collection.favorite_status_id = 1;
                this.fav = !this.fav;
            }
        } 
    }
}

</script>

<style scoped>
    div{
        width: 100%;
        margin: 5px 0;
    }
    .btn{
        width: 100%;
    }
</style>