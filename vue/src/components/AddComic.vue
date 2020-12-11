<template>
    <div>
        <form class="row">
            <div class="col-md-10">
                <input type="search" class="form-control" placeholder="Search by Issue Name" name="q" v-on:submit="getComicIssue(name)">
            </div>
            <div class="col-md-2">
                <button type="button" class="btn btn-primary" >Search</button>
            </div>
        </form>
        <tr v-for="comic in this.$store.state.comics" v-bind:key="comic.id">
            <td>{{comic.title}}</td>
        </tr>
        <!-- equivolent to add message from post homework -->
    </div>
</template>

<script>
import comicServices from "@/services/ComicServices.js"

export default {
    name: "add-comic",
    methods:{
        getComics(name){
            comicServices.getComics(name).then(response => {
                this.$store.commit("SET_COMICS",response.data)
            })

        }
    },
    created(){
        this.getComics();
    }
}
</script>

<style scoped>
form{
    width: 100%;
    margin: 0%;
}
    div{
        width: 100%;
        margin: 0px;
    }
    .btn{
        margin: 0;
        width: 100%;
    }
</style>