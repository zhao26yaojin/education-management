<template>
	<div class="form">
		<el-form :model="userLogin" class="form-inline">
			<el-form-item label="用户名">
				<el-input v-model="userLogin.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="密码">
				<el-input v-model="userLogin.password" placeholder="password" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onLogin">Login</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script setup>
import router from "@/router/index"
import useUserStore from "@/store/modules/user"
import { login } from "@/api/sys/user"
import { reactive } from "vue"
import { useRouter } from "vue-router"

const userLogin = reactive({
	name: '',
	password: ''
})
const userStore = useUserStore()
const onLogin = async () => {
	const { result } = await login(userLogin)
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
.form {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100%;
}

.form-inline {
	padding: 50px;
}


</style>
