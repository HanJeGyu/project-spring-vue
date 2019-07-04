<template>
<v-container fill-height fluid grid-list-xl>
  <v-layout justify-center wrap>
    <v-flex xs12 md9>
      <material-card color="green" title="회원정보 수정">
        <v-form>
          <v-container py-0>
            <v-layout wrap>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>이름</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input" v-model="seekerName"/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>아이디</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input" v-model="seekerId" disabled/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>비밀번호</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field :type="'password'" class="purple-input" v-model="password"/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>생년월일</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input" v-model="birth6" disabled/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>휴대폰번호</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input" v-model="phone"/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>이메일주소</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input" v-model="email"/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>산업/직군</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input" v-model="industry"/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>희망근무지</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input" v-model="location"/>
              </v-flex>
              <v-flex xs12 text-xs-right>
                <v-btn v-on:click="modify" class="mx-0 font-weight-light" color="success">수정하기</v-btn>
                <v-btn v-on:click="del" class="mx-0 font-weight-light" color="success">탈퇴하기</v-btn>
                <v-btn to="/home" class="mx-0 font-weight-light" color="success">취소</v-btn>
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
      context: '/jobseekers',
      seekerId: '', 
      seekerName: '', 
      password: '', 
      birth6: '', 
      phone: '', 
      email: '', 
      industry: '', 
      location: ''
    }
  },
  created(){
    axios.get(`${this.context}/${this.$store.state.userId}`)
      .then(res=>{
        this.seekerId = res.data.seekerId
        this.seekerName = res.data.seekerName
        this.password = res.data.password,
        this.birth6 = res.data.birth6,
        this.phone = res.data.phone,
        this.email = res.data.email,
        this.industry = res.data.industry,
        this.location = res.data.location
      }).catch(e=>{
        if(this.$store.state.authenticated == false){
          alert('로그인을 먼저 해주세요')
        }else{
          alert('페이지를 불러오지 못했습니다.')
        }
        this.$router.push({path:'/home'})
      })
  },
  methods: {
    modify(){
      if(this.seekerName === ''){
        alert('이름을 입력하세요')
      }else if(this.password === ''){
        alert('비밀번호를 입력하세요')
      }else if(this.birth6 === ''){
        alert('생년월일을 입력하세요')
      }else if(this.phone === ''){
        alert('휴대폰번호를 입력하세요')
      }else if(this.email === ''){
        alert('이메일주소를 입력하세요')
      }else{
        let data = {
          seekerId: this.seekerId,
          seekerName: this.seekerName,
          password: this.password, 
          birth6: this.birth6, 
          phone: this.phone, 
          email: this.email, 
          industry: this.industry, 
          location: this.location
        }
        let headers = {
          'Content-Type': 'application/json',
          'Authorization': 'JWT fefege..'
        }
        axios.put(`${this.context}/modify`, JSON.stringify(data), {headers: headers})
        .then(res=>{
          alert(`회원정보 수정 ${res.data.result}`)
          this.$router.push({path:'/home'})
        }).catch(e=>{
          alert('ERROR')
        })
      }
    },
    del(){
      axios.delete(`${this.context}/${this.seekerId}`)
        .then(res=>{
          alert(`회원 탈퇴 ${res.data.result}`)
          this.$store.commit('confirmout')
          this.$router.push({path:'/home'})
        })
        .catch(e=>{
          alert('ERROR')
        })
    }
  }
}
</script>

<style>

</style>
