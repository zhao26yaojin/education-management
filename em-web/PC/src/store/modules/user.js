import { defineStore } from "pinia"
import { ref } from "vue"
import "@/store/modules/user"

const useUserStore = defineStore("user", () => {
	let userInfo = ref(null)
	let token = ref("")
	const localToken = localStorage.getItem("token")
	if (localToken) {
		token.value = localToken
	}

	const setUserInfo = result => {
		token.value = result.token
		userInfo.value = result
		userInfo.value.token = ""
		localStorage.setItem(token, token.value)
	}
	return { setUserInfo }
})
export default useUserStore