<template>
<v-container fill-height fluid grid-list-xl>
  <v-layout justify-center wrap>
    <v-flex xs12 md6>
      <material-card color="green" title="개인회원">
        <v-form>
        <v-container py-0>
          <v-layout wrap>
          <v-flex xs12 md12>
            <v-text-field label="아이디" class="purple-input" v-model="seekerId"/>
          </v-flex>
          <v-flex xs12 md12>
            <v-text-field label="비밀번호" class="purple-input" v-model="password"/>
          </v-flex>
          <v-flex xs12 text-xs-right>
            <v-btn v-on:click="login" class="mx-0 font-weight-light" color="success">로그인</v-btn>
            <v-btn to="/join" class="mx-0 font-weight-light" color="success">가입하기</v-btn>
          </v-flex>
          </v-layout>
        </v-container>
        </v-form>
      </material-card>
    </v-flex>
  </v-layout>
</v-container>
</template>

<script>
import axios from 'axios'

export default {
  data(){
    return {
      context: 'http://localhost:8888/jobseekers',
      seekerId: '',
      password: ''
    }
  },
  methods: {
    login(){
      if(this.seekerId === ''){
        alert('아이디를 입력하세요')
      }else if(this.password === ''){
        alert('비밀번호를 입력하세요')
      }else{
        let data = {
          seekerId: this.seekerId,
          password: this.password
        }
        let headers = {
          'Content-Type': 'application/json',
          'Authorization': 'JWT fefege..'
        }
        axios.post(`${this.context}/login`, JSON.stringify(data), {headers: headers})
        .then(res=>{
          if(res.data.seekerId !== null){
            alert(`GET SUCCESS \nID : ${res.data.seekerId}\nNAME : ${res.data.seekerName}`)
          }else{
            alert(`가입된 정보가 없습니다. ID : ${this.seekerId}`)
          }
        }).catch(e=>{
          alert('통신 ERROR')
        })
      }
    }
  }
}
</script>
