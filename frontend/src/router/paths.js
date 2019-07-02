/**
 * Define all of your application routes here
 * for more information on routes, see the
 * official documentation https://router.vuejs.org/en/
 */
export default [
  { path: '/home', view: 'Home' },
/*   { path: '/want-list', name: 'Want List', view: 'WantList' },
  { path: '/interview-list', name: 'Interview List', view: 'InterviewList' },
  { path: '/pr-list', name: 'Pr List', view: 'PrList' },
  { path: '/fg', name: "F & Q", view: 'FandQ' },
  { path: '/maps', view: 'Maps' },
  { path: '/notifications', view: 'Notifications' }, */
  { path: '/login', name: 'LoginForm', view: 'LoginForm' },
  { path: '/join', name: 'JoinForm', view: 'JoinForm' },
  { path: '/mypage', name: 'MyPage', view: 'MyPage' },
  { path: '/seeker-list', name: 'Seeker List', view: 'SeekerList' }
]
