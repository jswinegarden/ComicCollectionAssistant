<template>
   <div>
        <div v-for="details in comic.data.results" v-bind:key="details.comicId">
            <div class="col-md shadow"> 
                <img class="img-fluid" v-bind:src="details.thumbnail.path + '.' + details.thumbnail.extension">
            </div>
            <div class="col-md shadow"><h3> {{details.title}}</h3>
                <h5 class="row"> {{details.description}}</h5>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
import ComicServices from '../services/ComicServices.js';
export default {
    name: "comic-detail",
    data() {
        return {
            comic: {
                data:{}
            },
            image: "",
        }
    },
    methods: {
    },
    created(){
        ComicServices.getNonCollectionComicDetails(this.$store.state.comic.comicId).then(response =>{
            this.comic = response.data;
        })        
    }
}
</script>
