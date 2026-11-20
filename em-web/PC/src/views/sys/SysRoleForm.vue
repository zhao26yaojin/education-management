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
import { getDetail as getRoleDetail, saveForm as saveRoleForm } from "@/api/sys/role"
import { onMounted, reactive } from "vue"
import { useRoute, useRouter } from "vue-router"

const route = useRoute()
const router = useRouter()
const role = reactive({
	id: null,
	name: '',
	status: null
})
const onSaveRoleForm = async () => {
	const { result } = await saveRoleForm(role)
	const success = result == null

	ElMessage({
		message: success ? "保存成功": result,
		type: success ? "success": "error"
	})

	if (success) {
		router.push("/sys/roleList")
	}

}
const onGetRoleDetail = async () => {
	const id = route.query.id

	if (id) {
		const query = {id: id }
		const { result } = await getRoleDetail(query)

				if (result) {
			Object.assign(role, result)
		}


	}

}
onMounted(() => onGetRoleDetail())

</script>
<style scoped>

</style>
