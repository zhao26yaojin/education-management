<template>
	<div>
		<el-form :model="user" :inline="true">
			<el-form-item label="用户名">
				<el-input v-model="user.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="密码">
				<el-input v-model="user.password" placeholder="password" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="性别">
				<el-input v-model="user.gender" placeholder="gender" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="邮箱">
				<el-input v-model="user.email" placeholder="email" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="手机">
				<el-input v-model="user.phone" placeholder="phone" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="状态">
				<el-input v-model="user.status" placeholder="status" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="逻辑删除">
				<el-input v-model="user.deleted" placeholder="deleted" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSaveUserForm">Save</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script setup>
import { saveForm as saveUserForm } from "@/api/sys/user"
import { reactive } from "vue"

const user = reactive({
	name: '',
	password: '',
	gender: '',
	email: '',
	phone: '',
	status: '',
	deleted: ''
})
const onSaveUserForm = async () => {
	const { result } = await saveUserForm(user)
	const success = result == null

	ElMessage({
		message: success ? "保存成功": result,
		type: success ? "success": "error"
	})
}

</script>
<style scoped>

</style>
