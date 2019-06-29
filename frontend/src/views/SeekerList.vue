<template>
  <v-container fill-height fluid grid-list-xl>
    <v-layout wrap>
      <v-flex md12 lg12>
        <material-card color="deep-orange" title="구직자 회원 목록">
          <v-data-table :items="jobseeker" hide-actions>
            <template slot="items" slot-scope="{ index, item }">
              <td>{{ index + 1 }}</td>
              <td>{{ item.id }}</td>
              <td>{{ item.name }}</td>
              <td>{{ item.email }}</td>
              <td class="text-xs-right">{{ item.phone }}</td>
              <td class="text-xs-right">{{ item.del }}</td>
            </template>
          </v-data-table>
        </material-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  data () {
    return {
      jobseeker: [
        {id: 'han', name: '이름', email: '이메일', phone: '연락처', del: '삭제버튼'},
        {id: 'kim', name: '김씨', email: 'abcdcd@gmail.com', phone: '010-2496-4495', del: '삭제버튼'},
        {id: 'hong', name: '이름', email: '이메일', phone: '연락처', del: '삭제버튼'},
        {id: '아이디', name: '이름', email: '이메일', phone: '연락처', del: '삭제버튼'},
        {id: '아이디', name: '이름', email: '이메일', phone: '연락처', del: '삭제버튼'},
      ]
    }
  },
  methods: {
  }
}
</script>

<style>

</style>

