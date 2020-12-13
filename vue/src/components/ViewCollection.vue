<template>
    <div id="Collections">
        <h1>Public Collections</h1>
            <router-link :to="{ name: 'Collection', params: { id: collection.id } }"
            class="collection"
            v-for="collection in this.$store.state.collections"
            v-bind:key="collection.id"
            v-bind:style="{ 'background-color': collection.backgroundColor }"
            >
            {{ collection.title }}
            </router-link>

    </div>
</template>

<script>
import collectionService from '../services/CollectionService';

export default {
    data() {
        return {

        };
    },
    methods: {
        retrieveCollections() {
            collectionService.getCollections().then(response => {
                this.$store.commit("SET_COLLECTIONS", response.data);
                
                if (this.$route.name == "Home" && response.status === 200 && response.data.length > 0) {
                    this.$router.push(`/collection/${response.data[0].id}`);
                }
            });
        },
        saveNewCollection() {
            collectionService.saveCollection(this.newCollection).then(response => {
                if (response.status === 201) {
                    this.retrieveCollections();
                    this.showAddCollection = false;
                    this.newCollection = {
                        title: '',
                        backgroundColor: this.randomBackgroundColor() 
                    }
                }
            }).catch(error => {
                if(error.response) {
                    this.errorMsg = "Error submitting new collection. Response received was '" error.response.statusText + "'.";
                } else if (error.request) {
                    this.errorMsg = "Error submitting new collection. Server could not be reached.";
                } else {
                    this.errorMsg = "Error submitting new collection. Request could not be created.";
                }
            })
        },
        
    }
}
</script>

<style scoped>

</style>