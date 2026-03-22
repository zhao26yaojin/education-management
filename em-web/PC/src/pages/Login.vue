<template>
	<div class="container">
		<div class="sidebar">
			<h5 class="title">education management</h5>
			<el-menu height="100%" background-color="#ffb8e7" active-text-color="#04718" text-color="#fff" router>
			</el-menu>
		</div>
		<router-view>
		</router-view>
	</div>
	<div class="form">
		<el-form :model="loginLogin" class="form-inline">
			<el-form-item label="id">
				<el-input v-model="loginLogin.id" placeholder="id" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="名字">
				<el-input v-model="loginLogin.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="父级id">
				<el-input v-model="loginLogin.parentId" placeholder="parentId" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onLogin">Login</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script setup>
import { reactive } from "vue"
import useUserStore from "@/store/modules/user"
import { useRouter } from "vue-router"
import { login } from "@/api/sys/user"
import router from "@/router/index"

const data = reactive({
	id: '',
	name: '',
	parent_id: ''
})
userStore = useUserStore()
const onLogin = async () => {
	const { result } = await login(data)
	const success = result != null
	if (success) {
		userStore.setUserInfo(result)
		router.push("/")
	}

	ElMessage({
		message: success ? "登录成功": result,
		type: success ? "success": "error"
	})
}

</script>
<style scoped>
.container {
	min-height: 100vh;
	display: flex;
}

.sidebar {
	width: 200px;
	background-color: #ffb8e7;
}

.title {
	height: 50px;
	color: white;
	font-size: 20px;
	text-align: center;
	line-height: 50px;
}

form {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100%;
}

form-inline {
	padding: 50px;
}


</style>
