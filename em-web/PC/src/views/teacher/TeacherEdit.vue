<template>
	<div>
		<el-form :model="teacherForm" class="form-inline" :inline="true">
			<el-form-item label="id">
				<el-input v-model="teacherForm.id" placeholder="id" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="名字">
				<el-input v-model="teacherForm.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="级别">
				<el-input v-model="teacherForm.level" placeholder="level" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="头像">
				<el-input v-model="teacherForm.avatar" placeholder="avatar" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSaveTeacherForm">Save</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script setup>
import { reactive } from "vue"
import { saveForm as saveTeacherForm } from "@/api/edu/teacher"

const data = reactive({
	id: '',
	name: '',
	level: '',
	avatar: ''
})
const onSaveTeacherForm = async () => {
	const { result } = await saveTeacherForm(data)
	const success = result == null
	ElMessage({
		message: success ? "保存成功": result,
		type: success ? "success": "error"
	})
}

</script>
<style scoped>
form-inline {
}


</style>
