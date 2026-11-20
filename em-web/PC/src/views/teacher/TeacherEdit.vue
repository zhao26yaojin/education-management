<template>
	<div>
		<el-form :model="teacher" :inline="true">
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
				<el-input v-model="teacher.logo" placeholder="logo" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSaveTeacherForm">Save</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script setup>
import { getDetail as getTeacherDetail, saveForm as saveTeacherForm } from "@/api/edu/teacher"
import { onMounted, reactive } from "vue"
import { useRoute } from "vue-router"

const route = useRoute()
const teacher = reactive({
	id: null,
	name: '',
	level: null,
	logo: ''
})
const onSaveTeacherForm = async () => {
	const { result } = await saveTeacherForm(teacher)
	const success = result == null

	ElMessage({
		message: success ? "保存成功": result,
		type: success ? "success": "error"
	})
}
const onGetTeacherDetail = async () => {
	const id = route.query.id

	if (id) {
		const query = {id: id }
		const { result } = await getTeacherDetail(query)

				if (result) {
			Object.assign(teacher, result)
		}


	}

}
onMounted(() => onGetTeacherDetail())

</script>
<style scoped>

</style>
