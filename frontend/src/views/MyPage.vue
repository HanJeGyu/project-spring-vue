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
                <v-text-field class="purple-input"/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>아이디</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input" value="ID" disabled/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>비밀번호</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input"/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>이메일</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input"/>
              </v-flex>
              <v-flex xs12 md1 style="font-size: 15px; padding:35px 0px 0px 0px;">
                <span>휴대폰번호</span>
              </v-flex>
              <v-flex xs12 md11>
                <v-text-field class="purple-input"/>
              </v-flex>
              <v-flex xs12 text-xs-right>
                <v-btn class="mx-0 font-weight-light" color="success">수정하기</v-btn>
                <v-btn to="/" class="mx-0 font-weight-light" color="success">취소</v-btn>
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
export default {

}
</script>

<style>

</style>
