<template>
  <v-container fill-height fluid grid-list-xl>
    <v-layout wrap>
      <v-flex md12 lg12>
        <material-card color="deep-orange" title="구직자 회원 목록">
          <v-data-table :headers="headers" :items="jobseekers" hide-actions>
            <template slot="headerCell" slot-scope="{ header } " >
              <td>{{ header.text }}</td>
            </template>
            <template slot="items" slot-scope="{ index, item }">
              <td>{{ index + 1 }}</td>
              <td>{{ item.seekerId }}</td>
              <td>{{ item.seekerName }}</td>
              <td>{{ item.birth6 }}</td>
              <td>{{ item.phone }}</td>
              <td>{{ item.email }}</td>
              <td>{{ item.industry }}</td>
              <td>{{ item.location }}</td>
            </template>
          </v-data-table>
        </material-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      context: 'http://localhost:8888/jobseekers',
      headers: [
        {text: 'No', value: 'ID'},
        {text: '회원ID', value: 'seekerId'},
        {text: '회원이름', value: 'seekerName'},
        {text: '생년월일', value: 'birth6'},
        {text: '휴대폰번호', value: 'phone'},
        {text: '이메일', value: 'email'},
        {text: '산업/직군', value: 'industry'},
        {text: '희망근무', value: 'location'}
      ],
      jobseekers: []
    }
  },
  created() {
    axios.get(`${this.context}/list`)
      .then(res=>{
        this.jobseekers = res.data
      })
      .catch(e=>{
        alert('ERROR')
      })
  },
  methods: {
    
  }
}
</script>

<style scoped>

</style>

