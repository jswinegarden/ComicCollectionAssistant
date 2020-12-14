<template>
    <div>
        <div class="myCollections">
            <router-link :to="{ name: 'Account', params: {id: user.id} }"
            class="allCollections"
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
    methods: {
        retrieveCollections() {
            collectionService.getAllCollections().then(response => {
                this.$store.commit("SET_COLLECTIONS", response.data);
                if (this.$route.name == "Account" && response.status === 200 && response.data.length > 0) {
                    this.$router.push(`/collection/${response.data[0].id}`);
                }
            });
        },
    }
    
}
</script>
