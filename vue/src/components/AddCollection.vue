<template>
    <div>
        <div class="row">
            <div class="col-md-9">
                <input type="text" v-model="collection.collection_name" class="form-control" placeholder="Collection Title" name="Collection Title">
            </div>
            <div class="col-md-2">
                <button type="button" v-show="visibility" v-on:click="visibility = !visibility" class="btn btn-primary">Make Private</button>
                <button type="button" v-show="!visibility" v-on:click="visibility = !visibility" class="btn btn-primary">Make Public</button>
            </div>
            <div class="col-md-1">
                <button type="button" v-show="!fav" v-on:click="fav = !fav" class="btn btn-primary">Fav</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <textarea v-model="collection.collection_desc" class="form-control" rows="5" placeholder="Collection Description"/>
            </div>
            <div class="col">
                <router-link class="btn btn-primary" v-bind:to="{ name: 'newComic' }">Save Collection</router-link>
            </div>
        </div>
    </div>
</template>

<script>
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
                favorite_status_id:'',
                collection_visibility_id:''
            }
        };
    },
    methods: {
        saveCollection() {
            
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