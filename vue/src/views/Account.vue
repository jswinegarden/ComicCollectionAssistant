<template>
 <div class="box">
   <div class="jumbotron jumbotron-fluid shadow">
     <h1>Account</h1>
     <p>Track your collection! Share with your friends!</p>
   </div>
 
   <div class="row shadow">
     <h4 class="col-md-12">My Collections:</h4>
     <div id="mycollection">
       <collections-list />
     </div>
   </div>
 </div>
</template>
 
<script>
import CollectionsList from '../components/CollectionsList.vue'
export default {
 name: "account",
 components: { CollectionsList },
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