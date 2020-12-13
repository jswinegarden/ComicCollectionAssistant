<template>
<div>
  <div class="jumbotron jumbotron-fluid shadow">
    <h1> About Us </h1>
      <div id="container">
        <img class="rounded-circle float-left mr-2 img-fluid mx-auto" id="cartoonedPicture" src="../../img/jacobCartoonEffect.jpg">
        <p class="text-center mx-auto"> Have you found yourself wanting a way to visually keep track of what comics you have in your personal collection?
          If so, look no further! The Comic League provides just that! A way for users to keep track of their comics that they have in their collection 
          and access to a community that is part of the same culture! Just recently, we have introudced our brand new system that will allow users to add their friends on the site!
          This allows you to see what vast collections they have! Our founder, Jacob Frey (pictured left), ....   
        </p>
      </div>
    <p class="text-center" id="stats"> Statistics are something that we hold near and dear to us and our statistics speak for itself with over 5,000 users registered nation wide and over 37,000 comics in our inventory!
    There are plenty of comics to be counted for towards a personalized collection of yours or a few that you are looking out for!
    </p>
    <div class="img-container"> 
      <img  class="img-fluid" src="../../img/thorFunny.gif">
    </div>
  </div>
</div>
</template>

<script>
export default {

}
</script>

<style >
.jumbotron.jumbotron-fluid {
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  color: white;
  background-color: rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: auto;
  padding: 20px;
  border: white solid 6px;
}
#container p{
  margin-top: 70px;
}
#stats{
  margin-top: 40px;
}
#cartoonedPicture{
  height:400px;
}
div h1{
  font-family: CrashLanding;
  font-weight: bold;
  font-size: 75px;
  color: black;
}
div p{
  font-family: AnimeAce;
  color: black;
}
.img-container{
  text-align: center;
  display:block;
  
}
#container {
  display: inline-block;
  text-align: center;
}
</style>