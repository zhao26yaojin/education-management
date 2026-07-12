import { getList as getMenuList } from "@/api/sys/menu"
import { defineStore } from "pinia"
import { getDetail as getRoleMenuDetail } from "@/api/sys/roleMenu"
import router from "@/router/index"
import "@/store/modules/routes"
import useUserStore from "@/store/modules/user"
import { ref } from "vue"

const useRoutesStore = defineStore("routes", () => {
	let aclRoutes = ref(null)
	const getAclRoutes = () => {
		if (null == aclRoutes.value) {
			initRoutes()
		}

		return aclRoutes
	}
	const initRoutes = async () => {
		const userStore = useUserStore()
		const userInfo = userStore.getUserInfo()
		if (null == userInfo) {
			return 
		}

		const roleMenuDetail = await getRoleMenuDetail(userInfo.roleIdList)
		const menuList = await getMenuList()
		const menuIdList = roleMenuDetail.result.menuIdList
		const aclMenuList = menuList.result.filter()
		aclMenuList.forEach(item => router.addRoute("layout", item))
		aclRoutes.value = constRoutes
	}
	return { getAclRoutes, aclRoutes }
})
export default useRoutesStore