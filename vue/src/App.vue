<template>
  <div id="app">
    <div class="shadow">
      <ul class="nav nav-tabs">
        <li class="nav-item">   
          <router-link class="nav-link active" 
          v-bind:to="{ name: 'home' }">Home</router-link>
        </li>
        <li class="nav-item" >
          <router-link class="nav-link" 
          v-bind:to="{ name: 'myAccount' }" v-show="$store.state.token != ''">Account</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" 
          v-bind:to="{ name: 'home' }"  v-show="$store.state.token != ''">Friends</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" 
          v-bind:to="{ name: 'home' }"  v-show="$store.state.token != ''">Trades</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" 
          v-bind:to="{ name: 'home' }" v-show="$store.state.token != ''">Leaderboards</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link"
          v-bind:to="{name: 'aboutUs'}" v-show="$store.state.token != ''"> About Us </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" 
          v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </li>
      </ul>
    </div>
    <router-view/>
  </div>
</template>

<style scoped>
 @font-face {
    font-family: CrashLanding;
    src: url("../fonts/crashlanding-bb.italic.ttf");
  }
  @font-face {
    font-family: AnimeAce;
    src: url("../fonts/anime-ace.italic.ttf");
 }
  #app{
    background-image: url("../img/HERO COLLAGE.png");
    background-repeat: repeat;
    background-size: contain;
    height: 1176px;
  }
  .nav-item {
    background-color:black;
    font-family: CrashLanding;
    font-size: 25px;
  }
  .nav-link {
    color: white;
  }
  .active.nav-link{
    background-color: lightgrey;
  }
  .nav-tabs{
    width: 75%;
    margin: auto;
    border-bottom: none;
  }
</style>
