<template>
  <div>
    <div class="jumbotron jumbotron-fluid shadow">
<<<<<<< HEAD
      <h1>The Comic League!</h1>
      <p>A place to collect and share comics!</p>
=======
      <h1>Comic League!</h1>
      <p>Track your collection! Share with your friends!</p>
>>>>>>> d0d8d5f732b2bde2562a37b0023c1f32ffdfde78
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
<<<<<<< HEAD
      <div class="col-md-2 shadow"> <router-link class="btn btn-dark" 
          v-bind:to="{ name: 'newCollection' }" v-show="$store.state.token != ''">Create New Collection</router-link>
      </div>
=======
      <span class="contain"> <router-link class="btn btn-primary" 
        v-bind:to="{ name: 'newCollection' }" v-show="$store.state.token != ''">Create New Collection</router-link>
        <span> <router-link class="btn btn-success"
          v-bind:to="{ name: 'newComic' }" v-show="$store.state.token != ''">Add Comic</router-link>
        </span>
      </span>
>>>>>>> d0d8d5f732b2bde2562a37b0023c1f32ffdfde78
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
/* --------------------  header ---------------- */
.jumbotron {
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  color: white;
  background-color: rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: auto;
  padding: 20px;
  border: white solid 6px;
}
/* ------------------------ collection sections ------------- */
div.row {
  background-color:rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: 15px auto;
  padding: 0px;
  border: white solid 6px;
}
<<<<<<< HEAD
div p.row {
  width: 100%;
  border-top: darkgrey solid 1px;
  padding: 5px;
  padding-left: 5px;
  margin: 0px;
  text-align: center;
=======
.col-md-12 {
  background-color: white;
  padding: 10px 10px 5px;
  margin: 0px;
  font-family:Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
>>>>>>> d0d8d5f732b2bde2562a37b0023c1f32ffdfde78
}
/* ------------------ collection boxes ---------- */
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
<<<<<<< HEAD
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
.col-md-12 .btn{
  margin: auto;
  background-color: none;
  border: none;
  padding: 5px;
  
=======
>>>>>>> d0d8d5f732b2bde2562a37b0023c1f32ffdfde78
}
/* ----------- add comic and new collection buttons ------- */
.contain {
  width: 15%;
  margin: 20px auto;
}
.btn-primary{
  width: 100%;
}
.btn-success{
  width: 100%;
}
/* ------------- footer ------------ */
footer {
  text-align:center;
  width: 75%;
  margin:auto;
  padding: 10px;
  background-color: lightgray;
}

/* --------------- for buttons on a smaller screen -------------- */
@media only screen and (max-width: 800px) {
  .contain{
    width: 75%;
    margin:auto auto 20px;
  }  
}
</style>
