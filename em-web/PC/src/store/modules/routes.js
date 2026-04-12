import { defineStore } from "pinia"
import router from "@/router/index"
import useUserStore from "@/store/modules/user"

const useRoutesStore = defineStore("routes", () => {
	const getAclRoutes = () => {
		if (null == aclRoutes.value) {
			initRoutes()
		}

		return aclRoutes
	}
	const initRoutes = () => {
		const userStore = useUserStore()
		const userInfo = userStore.getUserInfo()
		if (null == userInfo) {
		}

		const menuIdList = roleMenuDetail.result.menuIdList
		const aclMenuList = menuList.result.filter()
		aclMenuList.forEach(item => router.addRoute("layout", item))
		aclRoutes.value = constRoutes
	}
	return { getAclRoutes }
})
export default useRoutesStore