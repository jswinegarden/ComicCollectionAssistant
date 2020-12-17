<template>
    <div>
    <div class="header">
        <h1>{{ title }}</h1>
        <router-link :to="{ name: 'Comic', params: { id: comic.id } }"
        class="comic"
        v-for="comic in this.$store.state.comics"
        v-bind:key="comic.id"
        v-bind:style=" { 'background-color': comic.backgroundColor }"
        >
        {{ comic.title }}
        </router-link>
    </div>
    </div>
</template>

<script>
import comicService from '../services/ComicService';
export default {
    data() {
        return {
        };
    },
    methods: {
        
    }
}
</script>
/* references CardDetails from week19 lecture code */