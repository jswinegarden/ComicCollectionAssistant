<template>
    <div>
    <div id="Collections">
        <h1>My Collections</h1>
            <router-link :to="{ name: 'Account', params: { id: collection.id } }"
            class="collection"
            v-for="collection in this.$store.state.collections"
            v-bind:key="collection.id"
            v-bind:style="{ 'background-color': collection.backgroundColor }"
            >
            {{ collection.title }}
            </router-link>
    </div>
    <div class="row shadow">
      <h4 class="col-md-12">My Collections:</h4>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
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

<style scoped>
.col-md-2{
  margin: 20px auto;
  padding: 0px;
  background-color: white; /*replace with image that represents collection */
  border: darkgrey solid 1px;
  text-align: center;
  font-family: AnimeAce;
}
div p.row {
  width: 100%;
  height: 30px;
  display: block;
  border-top: darkgrey solid 1px;
  padding: 5px;
  margin: 0px;
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
.col-md-12 .btn{
  margin: auto;
  background-color: none;
  border: none;
  padding: 5px;
}
</style>