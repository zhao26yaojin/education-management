import { defineStore } from "pinia"

const useRoutesStore = defineStore("routes", () => {
	const getAclRoutes = () => {
		if (null != aclRoutes.value) {
		}

		else () {
			initRoutes()
		}

		return aclRoutes
	}
	const initRoutes = () => {
	}
})
export {getAclRoutes}export default useRoutesStore