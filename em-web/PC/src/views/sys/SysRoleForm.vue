<template>
	<div>
		<el-form :model="role" :inline="true">
			<el-form-item label="角色名">
				<el-input v-model="role.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="状态">
				<el-input v-model="role.status" placeholder="status" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSaveRoleForm">Save</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script setup>
import { saveForm as saveRoleForm } from "@/api/sys/role"
import { reactive } from "vue"

const role = reactive({
	name: '',
	status: ''
})
const onSaveRoleForm = async () => {
	const { result } = await saveRoleForm(role)
	const success = result == null

	ElMessage({
		message: success ? "保存成功": result,
		type: success ? "success": "error"
	})
}

</script>
<style scoped>

</style>
