<template>
    <div>
        <div class="row">
            <div class="col-md-10">
                <input type="text" class="form-control" placeholder="Collection Title" name="Collection Title">
            </div>
            <div class="col-md-2">
                <button type="button" class="btn btn-primary">Private</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <textarea class="form-control" rows="5" placeholder="Collection Description"/>
            </div>
            <div class="col">
                <router-link class="btn btn-primary" v-bind:to="{ name: 'newComic' }">Save Collection</router-link>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "add-collection",
    data() {
        return {
            collection: {
                collection_id: '',
                user_id:'',
                collection_name:'',
                colection_desc:'',
                comic:[]
            }
        };
    },
    methods: {
        saveCollection() {
            
        }
    }
}

</script>

<style scoped>
    div{
        width: 100%;
        margin: 5px 0;
    }
    .btn{
        width: 100%;
    }
</style>