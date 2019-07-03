<template>
<v-container fill-height fluid grid-list-xl>
  <v-layout justify-center wrap>
    <v-flex xs12 md6>
      <material-card color="green" title="회원가입">
        <v-form>
          <v-container py-0>
            <v-layout wrap>
              <v-flex xs12 md12>
                <v-text-field label="이름" class="purple-input" v-model="seekerName"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="아이디" class="purple-input" v-model="seekerId"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field :type="'password'" label="비밀번호" class="purple-input" v-model="password"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="생년월일" class="purple-input" v-model="birth6"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="휴대폰번호" class="purple-input" v-model="phone"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="이메일주소" class="purple-input" v-model="email"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="산업/직군" class="purple-input" v-model="industry"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="희망근무지" class="purple-input" v-model="location"/>
              </v-flex>
              <v-flex xs12 text-xs-right>
                <v-btn v-on:click="join" class="mx-0 font-weight-light" color="success">가입하기</v-btn>
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
      context: 'http://localhost:8888/jobseekers',
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
  methods: {
    join(){
      if(this.seekerId === ''){
        alert('아이디를 입력하세요')
      }else if(this.seekerName === ''){
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
        axios.post(`${this.context}/join`, JSON.stringify(data), {headers: headers})
        .then(res=>{
          alert(`회원가입 ${res.data.result}`)
          this.$router.push({path:'/login'})
        }).catch(e=>{
          alert('ERROR')
        })
      }
    }
  }
}
</script>
