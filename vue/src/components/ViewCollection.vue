<template>
    <div>
        <div class="collections">
            <router-link :to="{ name: 'Collection', params: {id: collection.id} }"
            class="collection"
            v-for="collection in this.$store.state.collections"
            v-bind:key="collection.id"
            >
                {{ collection.title }}
            </router-link>
        </div>
    </div>
</template>

<script>
import collectionService from '../services/CollectionService';

export default {
    name: 'view-collection',
    methods: {
        retrieveComics() {
            collectionService
                .viewCollection(this.collectionId)
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
                });
        }
    }
};
</script>