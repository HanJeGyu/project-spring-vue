<template>
  <v-container fill-height fluid grid-list-xl>
    <v-layout wrap>
      <v-flex md12 lg12>
        <material-card color="deep-orange" title="채용공고">
          <v-data-table :items="notice" hide-actions>
            <template slot="items" slot-scope="{ index, item }">
              <td>{{ index + 1 }}</td>
              <td>{{ item.title }}</td>
              <td class="text-xs-right">{{ item.industy }}</td>
              <td class="text-xs-right">{{ item.lastdate }}</td>
            </template>
          </v-data-table>
        </material-card>
      </v-flex>
      <v-flex md12 lg12>
        <material-card color="green" title="자기PR 게시판">
          <v-data-table :items="items" hide-actions>
            <template slot="items" slot-scope="{ index, item }">
              <td>{{ index + 1 }}</td>
              <td>{{ item.title }}</td>
              <td class="text-xs-right">{{ item.industy }}</td>
              <td class="text-xs-right">{{ item.location }}</td>
              <td class="text-xs-right">{{ item.career }}</td>
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
      notice: [
        {title: '제목', industy: '산업/직군', lastdate: '마감일'},
        {title: '웹프로그래머 모집 공고', industy: 'SI/웹프로그래머', lastdate: '2019-09-09'},
        {title: '우리은행 은행원 모집공고', industy: '금융/은행원', lastdate: '2019-09-09'},
        {title: '제목4', industy: '건축/실내디자인', lastdate: '2019-09-09'},
        {title: '제목5', industy: '산업/직군', lastdate: '2019-09-09'}
      ],
      items: [
        {title: '제목1', industy: '산업/직군', location: '희망근무지', career: '경력'},
        {title: '웹프로그래밍 기술자(JAVA)', industy: 'SI/웹프로그래머', location: '서울', career: '신입'},
        {title: '제목3', industy: '금융/은행원', location: '부산', career: '경력3년'},
        {title: '제목4', industy: '건축/실내디자인', location: '인천', career: '경력'},
        {title: '제목5', industy: '산업/직군', location: '제주도', career: '경력'}
      ]
    }
  },
  methods: {
    complete (index) {
      this.list[index] = !this.list[index]
    }
  }
}
</script>

<style>

</style>

