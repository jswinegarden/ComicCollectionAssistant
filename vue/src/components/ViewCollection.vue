<template>
    <div>
    <div id="Collection">
        <h1>{{ title }}</h1>
            <router-link :to="{ name: 'Account', params: { id: collection.id } }"
            class="collection"
            v-for="collection in this.$store.state.collections"
            v-bind:key="collection.id"
            v-bind:style="{ 'background-color': collection.backgroundColor }"
            >
            </router-link>
    </div>
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
                    this.$router.push(`/account/${response.data[0].id}`);
                }
            });
        },
    }
}
</script>