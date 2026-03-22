import "./index.css"
import "@/assets/reset.css"
import App from "./App"
import { createApp } from "vue"
import router from "@/router/index"
import permission from "@/router/permission"

const app = createApp(App)
app.use(router)
app.mount("#app")
