<template>
<div>
  <div class="jumbotron jumbotron-fluid shadow">
    <h1> About Us </h1>
    <p> Have you found yourself wanting a way to visually keep track of what comics you have in your personal collection?
      If so, look no further! The Comic League provides just that! A way for users to keep track of their comics that they have in their collection 
      and access to a community that is part of the same culture! Just recently, we have introudced our brand new system that will allow users to add their friends on the site!
      This allows you to see what vast collections they have! Our founder, Jacob Frey (pictured below), ....   </p>
    <div class="img-container" >
      <img id="cartoonedPicture" src="../../img/jacobCartoonEffect.jpg">
    </div>
    <p> Statistics are something that we hold near and dear to us and our statistics speak for itself with over 5,000 users registered nation wide and over 37,000 comics in our inventory!
    There are plenty of comics to be counted for towards a personalized collection of yours or a few that you are looking out for!
    </p>
    <div class="img-container"> 
      <img src="../../img/thorFunny.gif">
    </div>
  </div>
</div>
</template>

<script>
export default {

}
</script>

<style >
.jumbotron {
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  color: white;
  background-color: rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: auto;
  padding: 20px;
  border: white solid 6px;
}
#cartoonedPicture{
  height:400px;
  padding: 5px;
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
  padding: 5px;
}
</style>