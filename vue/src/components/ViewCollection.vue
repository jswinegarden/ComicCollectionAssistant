<template>
    <div id="Collections">
        <h1>My Collections</h1>
            <router-link :to="{ name: 'Account', params: { id: collection.id } }"
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
            collectionService.viewCollections().then(response => {
                this.$store.commit("SET_COLLECTIONS", response.data);
                
                if (this.$route.name == "Account" && response.status === 200 && response.data.length > 0) {
                    this.$router.push(`/collection/${response.data[0].id}`);
                }
            });
        },
    }
}
</script>

<style scoped>
div#collections {
    height: 100%;
    width: 40%;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    Padding-top: 20px;
    overflow-x: hidden;
}

.collections {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
}

</style>