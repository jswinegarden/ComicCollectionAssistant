<template>
    <div>
        <form class="row">
            <div class="col-md-8">
                <input type="search" class="form-control" placeholder="Search by Issue Name" name="q" >
            </div>
        </form>
        <ul class="comics">
            <li v-for="comic in comics.data.results" v-bind:key="comic.id" class="row">
                <div class="col-lg-3">{{comic.title}}</div><div class="col-lg-8">{{comic.description}}</div>
            </li>
        </ul>
    </div>
</template>

<script>
import ComicServices from "@/services/ComicServices.js"

export default {
    name: "add-comic",
    data(){
        return{
            comics: {},
        }
    },
    created() {
        ComicServices.getComicIssue().then(response => {
            this.comics = response.data;
        });
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
    .row {
        padding: 5px;
    }
</style>