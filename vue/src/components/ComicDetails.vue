<template>
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
</template>

<script>
import comicService from '../services/ComicService';
export default {
    name: `comic-detail`,
    data() {
        return {
            comic: {
                data:{}
            },
        };
    },
<<<<<<< HEAD
    created(){
        ComicServices.getComicsByName(this.$store.state.comic.comicId).then(response => {
            this.comics = response.data;
            this.comicTitle = '';
=======
    methods: {
        
    },
    created(){
        ComicServices.getNonCollectionComicDetails(this.comicId).then(response =>{
            this.comic = response.data
>>>>>>> 9a0e82b7c140a7fd2b2e70be0cfebd7e5e91631e
        })
    }
}
</script>
/* references CardDetails from week19 lecture code */