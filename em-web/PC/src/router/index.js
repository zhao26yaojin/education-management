import Home from "@/pages/home"
import Login from "@/pages/login"
import Register from "@/pages/register"
import { createRouter, createWebHashHistory } from "vue-router"

const constRoutes = [
	{
		path: "/",
		component: Home,
		name: "home",
		children: [
			{
				path: "teacher/list",
				component: () => import("@/views/teacher/TeacherList")
			},
			{
				path: "teacher/edit",
				component: () => import("@/views/teacher/TeacherEdit")
			},
			{
				path: "course/list",
				component: () => import("@/views/course/CourseList")
			},
			{
				path: "course/info/detail",
				component: () => import("@/views/course/info/InfoDetail")
			},
			{
				path: "index",
				component: () => import("@/views/Index")
			}
		],
		redirect: "index"
	},
	{
		path: "/login",
		component: Login,
		name: "login",
		children: []
	},
	{
		path: "/register",
		component: Register,
		name: "register",
		children: []
	}
]
const router = createRouter({
	history: createWebHashHistory(),
	routes: constRoutes
})
export {constRoutes, router as default}