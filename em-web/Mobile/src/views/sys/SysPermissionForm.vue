<template>
	<div>
	</div>
	<view>
		<u-form :model="permissionForm">
			<u-form-item label="id" prop="permissionForm.id">
				<u-input v-model="permissionForm.id">
				</u-input>
			</u-form-item>
			<u-form-item label="权限名" prop="permissionForm.name">
				<u-input v-model="permissionForm.name">
				</u-input>
			</u-form-item>
			<u-form-item label="权限类型: menu/operation" prop="permissionForm.type">
				<u-input v-model="permissionForm.type">
				</u-input>
			</u-form-item>
			<u-form-item label="父级id" prop="permissionForm.parentId">
				<u-input v-model="permissionForm.parentId">
				</u-input>
			</u-form-item>
			<u-form-item label="路径编码" prop="permissionForm.pidPath">
				<u-input v-model="permissionForm.pidPath">
				</u-input>
			</u-form-item>
			<u-form-item label="路由" prop="permissionForm.path">
				<u-input v-model="permissionForm.path">
				</u-input>
			</u-form-item>
			<u-form-item label="组件路径" prop="permissionForm.component">
				<u-input v-model="permissionForm.component">
				</u-input>
			</u-form-item>
		</u-form>
		<u-button @click="onSavePermissionForm">Save</u-button>
	</view>
</template>
<script setup>
import uni from "@dcloudio/vite-plugin-uni"
import { saveForm as savePermissionForm } from "@/api/sys/permission"
import { reactive } from "vue"

const permissionForm = reactive({
	id: '',
	name: '',
	type: '',
	parentId: '',
	pidPath: '',
	path: '',
	component: ''
})
const onSavePermissionForm = () => {
	const { result } = savePermissionForm(permissionForm)

	uni.showToast({
		icon: "success",
		title: "保存成功"
	})
}

</script>
<style scoped>

</style>
