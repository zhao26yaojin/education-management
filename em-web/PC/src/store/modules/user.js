import { defineStore } from "pinia"
import "@/store/modules/user"
import { ref } from "vue"

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
	const getUserInfo = () => {
		if (null == userInfo) {
			initUserInfo(userInfo)
		}

	}
	const initUserInfo = userInfo => {
		if (null == token.value) {
			return null
		}

		userInfo.value = loginInfo
	}
	return { setUserInfo, getUserInfo }
})
export default useUserStore