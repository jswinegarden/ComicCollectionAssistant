<template>
<div>
  <div class="jumbotron jumbotron-fluid shadow">
      <h1>Comic book</h1>
  </div>
  <div class="row shadow">
      
      <div class="col-md shadow"> 
          <img class="img-fluid" src="https://images-na.ssl-images-amazon.com/images/S/cmx-images-prod/Item/724077/724077._SX1600_QL80_TTD_.jpg">
        
      </div>
       <div class="col-md shadow"><h3> Comic Book Title</h3>
        <h5 class="row"> Comic Book Details Insert Here </h5>
      </div>
      
    </div>
    <footer>
      &copy;  Comic League Enterprises 2020
    </footer>
</div>

  
</template>

<script>
export default {

}
</script>

<style scoped>

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
.col-md-12 {
  background-color: white;
  padding: 10px 10px 5px;
  margin: 0px;
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
/* ------------------ collection boxes ---------- */
.col-md{
  margin: 20px auto;
  padding: 0px;
  background-color: white; /*replace with image that represents collection */
  border: darkgrey solid 1px;
  text-align: center;
  font-family: AnimeAce;
}
div h5 {
  width: 100%;
  height: 200px;
  display: block;
  border-top: darkgrey solid 1px;
  padding: 5px;
  text-align: left;
  margin: 0px;
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
/* ------------- footer ------------ */
footer {
  text-align:center;
  width: 75%;
  margin:auto;
  padding: 10px;
  background-color:rgba(220, 207, 189, 0.94);
}

/* --------------- for buttons on a smaller screen -------------- */
@media only screen and (max-width: 800px) {
  .contain{
    width: 75%;
    margin:auto auto 20px;
  }  
}

</style>