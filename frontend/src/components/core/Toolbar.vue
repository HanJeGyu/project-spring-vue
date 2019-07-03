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
          <v-btn v-if="this.$store.state.authenticated" v-on:click="logout" color="success">logout</v-btn>
          <v-btn v-else v-on:click="logout" color="success" to="/login">login</v-btn>
        </template>
<!--         <v-text-field
          v-if="responsiveInput"
          class="mr-4 mt-2 purple-input"
          label="Search..."
          hide-details
          color="purple"
        />
        <v-menu bottom left content-class="dropdown-menu" offset-y transition="slide-y-transition">
          <v-icon slot="activator" color="tertiary">mdi-account</v-icon>
          <template class="">
            <tr><router-link to="/login">로그인</router-link></tr>
            <tr><router-link to="/join">회원가입</router-link></tr>
            <tr><router-link to="/mypage">마이페이지</router-link></tr>
          </template> 
        </v-menu> -->
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
      loginYN: null
    }
  },
  methods: {
    logout(){
      this.$store.state.userId = ''
      this.$store.state.authenticated = false
    }
  }
}
</script>

<style>
  #core-toolbar a {
    text-decoration: none;
  }
</style>
