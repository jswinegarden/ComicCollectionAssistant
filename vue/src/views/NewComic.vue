<template>
    <div>
        <div class="jumbotron jumbotron-fluid">
            <h2>Add Comics</h2>
        </div>
        <div class="row">
            <add-comic />
        </div>
    </div>
</template>

<script>
import AddComic from '../components/AddComic.vue'
export default {
    name: 'NewComic',
  components: { AddComic },

}
</script>

<style scoped>
.jumbotron{
    width: 75%;
    margin: auto;
    padding: 30px 15px;
    border: white solid 6px;
}
.row{
    width: 75%;
    height: 500px;
    margin: 10px auto;
    padding: 15px 5px 15px 5px;
    background-color: rgba(138, 138, 138, 0.94);
    border: white solid 6px;
}
</style>