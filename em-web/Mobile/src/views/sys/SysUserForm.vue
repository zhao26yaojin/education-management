<template>
	<div>
	</div>
	<view>
		<u-form :model="userForm">
			<u-form-item label="id" prop="userForm.id">
				<u-input v-model="userForm.id">
				</u-input>
			</u-form-item>
			<u-form-item label="用户名" prop="userForm.name">
				<u-input v-model="userForm.name">
				</u-input>
			</u-form-item>
			<u-form-item label="密码" prop="userForm.password">
				<u-input v-model="userForm.password">
				</u-input>
			</u-form-item>
			<u-form-item label="性别" prop="userForm.gender">
				<u-input v-model="userForm.gender">
				</u-input>
			</u-form-item>
			<u-form-item label="邮箱" prop="userForm.email">
				<u-input v-model="userForm.email">
				</u-input>
			</u-form-item>
			<u-form-item label="手机" prop="userForm.phone">
				<u-input v-model="userForm.phone">
				</u-input>
			</u-form-item>
			<u-form-item label="状态" prop="userForm.status">
				<u-input v-model="userForm.status">
				</u-input>
			</u-form-item>
			<u-form-item label="逻辑删除" prop="userForm.deleted">
				<u-input v-model="userForm.deleted">
				</u-input>
			</u-form-item>
		</u-form>
		<u-button @click="onSaveUserForm">Save</u-button>
	</view>
</template>
<script setup>
import uni from "@dcloudio/vite-plugin-uni"
import { saveForm as saveUserForm } from "@/api/sys/user"
import { reactive } from "vue"

const userForm = reactive({
	id: '',
	name: '',
	password: '',
	gender: '',
	email: '',
	phone: '',
	status: '',
	deleted: ''
})
const onSaveUserForm = () => {
	const { result } = saveUserForm(userForm)

	uni.showToast({
		icon: "success",
		title: "保存成功"
	})
}

</script>
<style scoped>

</style>
