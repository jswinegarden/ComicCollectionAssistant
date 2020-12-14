<template>
    <div>
        <div class="account">
            <h2>{{ title }}</h2>
            <div class="collections">
                <div
                    class="collection"
                    v-for="collection in collections"
                    v-bind:key="collection.id"
                    v-on:click="viewCollection(collection.id)"
                >
                <div class="header">
                    <h3> {{ collection.title }}</h3>
                    <img  />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import collectionService from '../services/CollectionService';

export default {
    name: 'account',
    props: ['title', 'collections', 'collectionId'],
    methods: {
        viewCollection(collectionId) {
            this.$router.push(`/collection/${this.collectionId}`);
        }
    }
};
</script>