<template>
  <div>
      
        <div class="row shadow">
      <h4 class="col-md-12">{{ collectionTitle }}</h4>
      <div class="col-md-2 shadow"> image representing comic
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing comic
        <p class="row"> comic title </p>
      </div>
      <div class="col-md-2 shadow"> image representing comic
        <p class="row"> comic title </p>
      </div>
      <div class="col-md-2 shadow"> image representing comic
        <p class="row"> comic title </p>
      </div>
        <span> <router-link class="btn btn-success"
          v-bind:to="{ name: 'newComic' }" v-show="$store.state.token != ''">Add Comic</router-link>
        </span>
      </div>
    </div>
</template>

<script>
import ComicsList from '@/components/ComicsList';
export default {
  components: {
    ComicsList
  }
};
</script>

<style>

</style>