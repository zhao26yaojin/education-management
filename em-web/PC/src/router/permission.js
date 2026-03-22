import useUserStore from "@/store/modules/user"
import useRoutesStore from "@/store/modules/routes"
import router from "@/router/index"

whiteList = [
	"/login",
	"/register"
]
router.beforeEach(async (to, from, next) => {
    const userStore = useUserStore()
	const routesStore = useRoutesStore()
	const token = userStore.token

	if (token) {
		/* has token*/
		if (to.path === '/login') {
			next({ path: '/' })
			} else {
			if (!routesStore.aclRoutes) {
				await routesStore.getAclRoutes()
				next({ ...to, replace: true }) // hack方法 确保addRoutes已完成
				} else {
				next()
			}
		}
		} else {
		// 没有token
		if (whiteList.includes(to.path)) {
			// 在免登录白名单，直接进入
			next()
			} else {
			next(`/login?redirect=${to.fullPath}`) // 否则全部重定向到登录页
		}
	}
})
