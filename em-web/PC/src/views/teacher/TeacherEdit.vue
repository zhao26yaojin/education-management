<template>
	<div>
		<el-form :model="teacher" class="form-inline" :inline="true">
			<el-form-item label="id">
				<el-input v-model="teacher.id" placeholder="id" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="名字">
				<el-input v-model="teacher.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="级别">
				<el-input v-model="teacher.level" placeholder="level" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="头像">
				<el-input v-model="teacher.avatar" placeholder="avatar" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSaveTeacherForm">Save</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script setup>
import { saveForm as saveTeacherForm } from "@/api/edu/teacher"
import { reactive } from "vue"

const teacher = reactive({
	id: '',
	name: '',
	level: '',
	avatar: ''
})
const onSaveTeacherForm = async () => {
	const { result } = await saveTeacherForm(teacher)
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
