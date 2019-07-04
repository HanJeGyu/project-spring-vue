<template>
  <v-toolbar
    id="core-toolbar"

    flat
    prominent
    style="background: #eee;"
  >
    <v-spacer />
    <v-toolbar-items>
      <v-flex
        align-center
        layout
        py-2
      > 
        <template class="">
          <v-btn v-if="this.$store.state.authenticated" v-on:click="logout" color="success" to="/home">logout</v-btn>
          <v-btn v-else v-on:click="logout" color="success" to="/login">login</v-btn>
        </template>
      </v-flex>
    </v-toolbar-items>
  </v-toolbar>
</template>

<script>

import {
  mapMutations
} from 'vuex'

export default {
  data(){
    return {
    }
  },
  methods: {
    logout(){
      this.$store.commit('confirmout')
      alert('로그아웃 되었습니다.')
    }
  }
}
</script>

<style>
  #core-toolbar a {
    text-decoration: none;
  }
</style>
