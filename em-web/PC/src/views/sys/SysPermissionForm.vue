<template>
	<div>
		<el-form :model="permission" :inline="true">
			<el-form-item label="权限名">
				<el-input v-model="permission.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="权限类型: menu/operation">
				<el-input v-model="permission.type" placeholder="type" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="父级id">
				<el-input v-model="permission.parentId" placeholder="parentId" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="路径编码">
				<el-input v-model="permission.pidPath" placeholder="pidPath" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="路由">
				<el-input v-model="permission.path" placeholder="path" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="组件路径">
				<el-input v-model="permission.component" placeholder="component" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSavePermissionForm">Save</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script setup>
import { saveForm as savePermissionForm } from "@/api/sys/permission"
import { reactive } from "vue"

const permission = reactive({
	name: '',
	type: '',
	parentId: '',
	pidPath: '',
	path: '',
	component: ''
})
const onSavePermissionForm = async () => {
	const { result } = await savePermissionForm(permission)
	const success = result == null

	ElMessage({
		message: success ? "保存成功": result,
		type: success ? "success": "error"
	})
}

</script>
<style scoped>

</style>
