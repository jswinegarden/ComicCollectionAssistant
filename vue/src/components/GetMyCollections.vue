<template>
    <span class="row">
        <ul class="col-md-3" v-for="collection in collections.slice(0,3)" v-bind:key="collection.collectionId">
           <li class="card">
                <img class="card-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                <p class="card-title">{{collection.collectionName}}</p>
            </li>
        </ul>
        <span class="contain"> 
            <router-link class="btn btn-info" v-bind:to="{ name: 'account' }">view more</router-link> 
        </span>
  </span>
</template>

<script>
import CollectionService from '../services/CollectionService'
export default {
    name: 'get-my-collections',
    data(){
        return{
            collections:{    
            },
        }
    },
    created(){
        CollectionService.getCollectionByCurrentUser().then(response => {
            this.collections = response.data
        })
    }
}
</script>

<style scoped>
.card{
    padding:10px;
}
.card:hover{
    background-color: wheat;
}
.card-title{
    padding-top: 10px;
}
.row{
   margin: 10px auto;
}
.contain {
    width: 20%;
    margin: auto;
}
.btn-dark{
    width: 100%;
    padding: 20px 0;
}
.btn-dark:hover{
  background-color: rgb(80, 80, 76);
}
.btn-success{
    width: 100%;
    margin: 20px auto;
    padding: 20px 0;
}
.btn-info{
    width: 100%;
    padding: 20px 0;
}
</style>