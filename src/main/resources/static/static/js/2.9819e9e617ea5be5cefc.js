webpackJsonp([2],{J3hi:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("mtWM"),s=a.n(r),n={data:function(){return{context:"/jobseekers",headers:[{text:"No",value:"ID"},{text:"회원ID",value:"seekerId"},{text:"회원이름",value:"seekerName"},{text:"생년월일",value:"birth6"},{text:"휴대폰번호",value:"phone"},{text:"이메일",value:"email"},{text:"산업/직군",value:"industry"},{text:"희망근무",value:"location"}],jobseekers:[]}},created:function(){var e=this;s.a.get(this.context+"/list").then(function(t){e.jobseekers=t.data}).catch(function(e){alert("ERROR")})},methods:{}},i={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-container",{attrs:{"fill-height":"",fluid:"","grid-list-xl":""}},[a("v-layout",{attrs:{wrap:""}},[a("v-flex",{attrs:{md12:"",lg12:""}},[a("material-card",{attrs:{color:"deep-orange",title:"구직자 회원 목록"}},[a("v-data-table",{attrs:{headers:e.headers,items:e.jobseekers,"hide-actions":""},scopedSlots:e._u([{key:"headerCell",fn:function(t){var r=t.header;return[a("td",[e._v(e._s(r.text))])]}},{key:"items",fn:function(t){var r=t.index,s=t.item;return[a("td",[e._v(e._s(r+1))]),e._v(" "),a("td",[e._v(e._s(s.seekerId))]),e._v(" "),a("td",[e._v(e._s(s.seekerName))]),e._v(" "),a("td",[e._v(e._s(s.birth6))]),e._v(" "),a("td",[e._v(e._s(s.phone))]),e._v(" "),a("td",[e._v(e._s(s.email))]),e._v(" "),a("td",[e._v(e._s(s.industry))]),e._v(" "),a("td",[e._v(e._s(s.location))])]}}])})],1)],1)],1)],1)},staticRenderFns:[]};var d=a("VU/8")(n,i,!1,function(e){a("KFwU")},"data-v-5a1dc04a",null);t.default=d.exports},KFwU:function(e,t){}});
//# sourceMappingURL=2.9819e9e617ea5be5cefc.js.map