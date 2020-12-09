<template>
  <div>
    <div class="jumbotron jumbotron-fluid">
      <h1>Comic Collector!</h1>
      <p>A place to collect and share comics!</p>
    </div>

    <div class="row">
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

    <div class="row">
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

    <div class="row">
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
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
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
  background-color: lightgray;
  width: 75%;
  margin: auto;
  padding: 20px;
}
div.row {
  background-color: lightskyblue;
  width: 75%;
  margin: auto;
  padding: 20px;
  border: rgb(199, 218, 236) solid 1px;
}
div p.row {
  width: 100%;
  border-top: darkgrey solid 1px;
  padding: 5px;
  margin:0px;
  
}
.col-md-2{
  margin: 3px auto 0px;
  padding: 0px;
  background-color: lightgray;
  border: darkgrey solid 1px;
  text-align: center;
}
.col-md-12 {
  margin: 5px 0 0px;
}
footer {
  text-align:center;
  width: 75%;
  margin:auto;
  padding: 10px;
  background-color: lightgray;
}
</style>
