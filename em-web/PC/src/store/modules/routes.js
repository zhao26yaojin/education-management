import { getRoleTree as getPermissionRoleTree } from "@/api/sys/permission"
import { defineStore } from "pinia"
import router, { constRoutes } from "@/router/index"
import "@/store/modules/routes"
import useUserStore from "@/store/modules/user"
import { traverseTree } from "@/utils/treeUtil"
import { ref } from "vue"

const modules = import.meta.glob("./../../views/**/*.vue")
const useRoutesStore = defineStore("routes", () => {
	let aclRoutes = ref(null)

	const getAclRoutes = async () => {
		if (null == aclRoutes.value) {
			await initRoutes()
		}

		return aclRoutes
	}

	const initRoutes = async () => {
		const userStore = useUserStore()
		const userInfo = await userStore.getUserInfo()

		if (null == userInfo) {
			return 
		}


		const treeParams = {
			roleId: userInfo.role_id,
			type: "menu"
		}
		const { result: aclMenuList } = await getPermissionRoleTree(treeParams)
		traverseTree(aclMenuList, item => {
			if (null != item.component) {
				item.component = loadView(item.component)
			}

		})

		aclMenuList.forEach(item => router.addRoute("home", item))

		aclRoutes.value = constRoutes
	}

	const loadView = view => {
        let res
		for (const path in modules) {
			const dir = path.split("views/")[1].split(".vue")[0]
			if (dir === view) {
				res = () => modules[path]()
			}
		}
        return res
	}

	return { getAclRoutes, aclRoutes }
})
export default useRoutesStore