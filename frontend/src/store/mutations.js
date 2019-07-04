export default {
    confirmin(state, seekerId){
        state.authenticated = true,
        state.userId = seekerId
    },
    confirmout(state){
        state.authenticated = false,
        state.userId = ''
    }
}
