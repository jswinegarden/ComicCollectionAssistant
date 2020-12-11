<template>
  <div>
    <div class="jumbotron jumbotron-fluid shadow">
      <h1>Comic Collector!</h1>
      <p>A place to collect and share comics!</p>
    </div>

    <div class="row shadow">
      <h4 class="col-md-12">Featured Collections:</h4>
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
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
    </div>

    <div class="row shadow">
      <h4 class="col-md-12">Friends Collections:</h4>
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
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
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
      <div class="col-md-2 shadow"> <router-link class="btn btn-primary" 
          v-bind:to="{ name: 'newCollection' }" v-show="$store.state.token != ''">Create New Collection</router-link>
      </div>
    </div>

    <footer>
      footer stuff
    </footer>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style scoped>
.jumbotron {
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  color: white;
  background-color: rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: auto;
  padding: 20px;
  border: white solid 6px;
}
div.row {
  background-color:rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: 15px auto;
  padding: 0px;
  border: white solid 6px;
}
div p.row {
  width: 100%;
  border-top: darkgrey solid 1px;
  padding: 5px;
  margin: 0px;
}
.col-md-2{
  margin: 20px auto;
  padding: 0px;
  background-color: white; /*replace with image that represents collection */
  border: darkgrey solid 1px;
  text-align: center;
}
.col-md-12 {
  background-color: white;
  padding: 10px 10px 5px;
  margin: 0px;
  font-family:Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
footer {
  text-align:center;
  width: 75%;
  margin:auto;
  padding: 10px;
  background-color: lightgray;
}
</style>
