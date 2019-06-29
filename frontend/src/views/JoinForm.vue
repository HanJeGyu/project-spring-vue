<template>
<v-container fill-height fluid grid-list-xl>
  <v-layout justify-center wrap>
    <v-flex xs12 md6>
      <material-card color="green" title="회원가입">
        <v-form>
          <v-container py-0>
            <v-layout wrap>
              <v-flex xs12 md12>
                <v-text-field label="이름" class="purple-input"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="아이디" class="purple-input"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="비밀번호" class="purple-input"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="비밀번호 확인" class="purple-input"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="이메일" class="purple-input"/>
              </v-flex>
              <v-flex xs12 md12>
                <v-text-field label="휴대폰번호" class="purple-input"/>
              </v-flex>
              <v-flex xs12 text-xs-right>
                <v-btn class="mx-0 font-weight-light" color="success">가입하기</v-btn>
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
export default {

}
</script>
