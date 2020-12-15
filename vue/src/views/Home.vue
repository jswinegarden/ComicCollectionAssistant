<template>
  <div class="box">
    <div class="jumbotron jumbotron-fluid shadow">
      <h1>Comic League!</h1>
      <p>Track your collection! Share with your friends!</p>
    </div>

    <div class="row shadow">
      <h4 class="col-md-12">My Collections:</h4>
      <div id="mycollection">
        <get-my-collections />
      </div>
    </div>
    <div class="row shadow">
      <h4 class="col-md-12">Featured Collections:</h4>
      <div class="col-md-2 shadow">image representing collection
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
  </div>
</template>

<script>
import GetMyCollections from '../components/GetMyCollections.vue'
export default {
  name: "home",
  components: { GetMyCollections },
};
</script>

<style scoped>
#mycollection{
  width: 100%;
  margin: auto;
  padding: 10px auto;
}
/* --------------------  header ---------------- */
.jumbotron {
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  color: white;
  background-color: rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: auto;
  padding: 20px;
  border: white solid 6px;
  font-kerning: none;
}
/* ------------------------ collection sections ------------- */
div.row {
  background-color:rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: 15px auto;
  padding: 0px;
  border: white solid 6px;
}
.col-md-12 {
  background-color: white;
  padding: 10px 10px 5px;
  margin: 0px;
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-kerning: none;
}
/* ------------------ collection boxes ---------- */
.col-md-2{
  margin: 20px auto;
  padding: 0px;
  background-color: white; /*replace with image that represents collection */
  border: darkgrey solid 1px;
  text-align: center;
  font-family: AnimeAce;
  font-kerning: none;
}
div p.row {
  width: 100%;
  height: 30px;
  display: block;
  border-top: darkgrey solid 1px;
  padding: 5px;
  margin: 0px;
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-kerning: none;
}
.col-md-12 .btn{
  margin: auto;
  background-color: none;
  border: none;
  padding: 5px;
  
}
</style>
