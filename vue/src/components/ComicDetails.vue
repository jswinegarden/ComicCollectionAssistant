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
    methods: {
        
    },
    created(){
        ComicServices.getNonCollectionComicDetails(this.comicId).then(response =>{
            this.comic = response.data
        }),
        image = ""
    }
}
</script>
/* references CardDetails from week19 lecture code */