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
        <v-text-field
          v-if="responsiveInput"
          class="mr-4 mt-2 purple-input"
          label="Search..."
          hide-details
          color="purple"
        />
        <v-menu bottom left content-class="dropdown-menu" offset-y transition="slide-y-transition">
          <v-icon slot="activator" color="tertiary">mdi-account</v-icon>
          <!-- <v-card>
            <v-list>
              <v-list-tile>
                <v-list-tile-title>
                  <router-link to="/login">로그인</router-link>
                </v-list-tile-title>
              </v-list-tile>
              <v-list-tile>
                <v-list-tile-title>
                  <router-link to="/join">회원가입</router-link>
                </v-list-tile-title>
              </v-list-tile>
              <v-list-tile>
                <v-list-tile-title>
                  <router-link to="/mypage">마이페이지</router-link>
                </v-list-tile-title>
              </v-list-tile>
            </v-list>
          </v-card> -->
          <template class="">
            <tr><router-link to="/login">로그인</router-link></tr>
            <tr><router-link to="/join">회원가입</router-link></tr>
            <tr><router-link to="/mypage">마이페이지</router-link></tr>
          </template> 
        </v-menu>
      </v-flex>
    </v-toolbar-items>
  </v-toolbar>
</template>

<script>

import {
  mapMutations
} from 'vuex'

export default {
  data: () => ({
    responsive: false,
    responsiveInput: false
  }),

  mounted () {
    this.onResponsiveInverted()
    window.addEventListener('resize', this.onResponsiveInverted)
  },
  beforeDestroy () {
    window.removeEventListener('resize', this.onResponsiveInverted)
  },

  methods: {
    ...mapMutations('app', ['setDrawer', 'toggleDrawer']),
    onClickBtn () {
      this.setDrawer(!this.$store.state.app.drawer)
    },
    onResponsiveInverted () {
      if (window.innerWidth < 991) {
        this.responsive = true
        this.responsiveInput = false
      } else {
        this.responsive = false
        this.responsiveInput = true
      }
    }
  }
}
</script>

<style>
  #core-toolbar a {
    text-decoration: none;
  }
</style>
