/* view of the home page from a user who is not logged in */
<template>
    <div class="box">
        <div class="jumbotron jumbotron-fluid shadow">
            <h1>Comic League!</h1>
            <p>Track your collection! Share with your friends!</p>
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
        <span>
          <div class="row">
            <h4 class= "col-md-12"> Comics: </h4>
              <div class="comics row"> 
                  <ul class="col-md-4" v-for="comic in comics.data.results" v-bind:key="comic.title">
                    <li class="card">
                      <img class="card-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                      <p class="card-title">{{comic.title}}</p>
                      <div class="btn btn-dark">add comic</div>
                    </li>
                  </ul>
              </div>
            </div>
        </span> 
      </div>
</template>

<script>
import ComicServices from '../services/ComicServices.js'
export default {
    name: "viewer",
  data(){
        return{
            comicTitle: '',
            comics: {
                data:{}
            },
        }
    },
  created() {
       
        ComicServices.getComicIssue().then(response => {
      this.comics = response.data
        });

    },
    
}
</script>

<style scoped>
.comics{
  width: 100%;
  margin: auto;
  padding: 10px auto;
}
.box{
  height: 1080px;
}
.jumbotron {
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
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
.col-md-12 {
  background-color: white;
  padding: 10px 10px 5px;
  margin: 0px;
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
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
  font-family: AnimeAce, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-kerning: none;
}
.card{
    margin:10px auto;
    padding: 5px;
   
}


</style>
