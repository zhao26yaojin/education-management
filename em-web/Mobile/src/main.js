import "@/assets/css/reset.css"
import App from "./App"
import { createSSRApp } from "vue"
import uviewPlus from "@/uview-plus"

const createApp = () => {
	const app = createSSRApp(App)
	app.use(uviewPlus)
	return {app: app }
}
export {createApp}