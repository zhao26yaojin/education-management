import { defineStore } from "pinia"
import "@/store/modules/user"
import { getLoginInfo } from "@/api/sys/user"
import { ref } from "vue"

const useUserStore = defineStore("user", () => {
	let userInfo = ref(null)
	let token = ref(null)
	const localToken = localStorage.getItem("token")
	if (localToken) {
		token.value = localToken
	}

	const getUserInfo = async () => {
		if (null == userInfo.value) {
			await initUserInfo(userInfo)
		}

		return userInfo.value
	}
	const initUserInfo = async userInfo => {
		if (null == token.value) {
			return null
		}

		const loginInfo = await getLoginInfo()
		userInfo.value = loginInfo
	}
	const setUserInfo = result => {
		token.value = result.token
		userInfo.value = result
		userInfo.value.token = ""
		localStorage.setItem("token", token.value)
	}
	return { token, getUserInfo, setUserInfo }
})
export default useUserStore