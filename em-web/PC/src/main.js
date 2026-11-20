import App from "./App"
import "@/router/guard"
import "./index.css"
import { createPinia } from "pinia"
import "@/assets/reset.css"
import appRouter from "@/router/index"
import { createApp } from "vue"

const app = createApp(App)
app.use(createPinia())
app.use(appRouter)
app.mount("#app")
